package com.neoteric.dec_dbconnection.creditcard.service;
import com.neoteric.dec_dbconnection.creditcard.entity.CreditCardEntity;
import com.neoteric.dec_dbconnection.creditcard.entity.EMIEntity;
import com.neoteric.dec_dbconnection.creditcard.model.BillPeriodDTO;
import com.neoteric.dec_dbconnection.creditcard.model.CreditCardDTO;
import com.neoteric.dec_dbconnection.creditcard.model.EMIDTO;
import com.neoteric.dec_dbconnection.creditcard.model.TransactionDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;

public class EMIService {
    public void saveEMI(EMIDTO dto) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            EMIEntity entity = EntityDTOMapper.toEntity(dto);
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error while saving EMI", e);
        } finally {
            em.close();
        }
    }

    public void convertToEMI(CreditCardDTO creditCardDTO, int emiMonths, double interestRate, Double monthlyExpense) {
        if (creditCardDTO == null || creditCardDTO.getCardNumber() == null) {
            throw new IllegalArgumentException("CreditCardDTO or cardNumber cannot be null");
        }

        BillPeriodDTO billPeriodDTO = creditCardDTO.getBillPeriod();
        if (billPeriodDTO == null || billPeriodDTO.getFromDate() == null || billPeriodDTO.getToDate() == null) {
            throw new IllegalArgumentException("BillPeriodDTO and its dates cannot be null");
        }

        CreditCardEntity creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCardNumber(creditCardDTO.getCardNumber());

        double debitTotal = new TransactionService().calculateDebitTotal(creditCardDTO);
        double creditTotal = new TransactionService().calculateCreditTotal(creditCardDTO);
        double principal = debitTotal - creditTotal;

        if (principal <= 0) {
            System.out.println("No EMI required as credits exceed or equal debits.");
            return;
        }

        double totalInterest = (principal * interestRate * emiMonths) / 1200;
        double totalAmount = principal + totalInterest;
        double emi = totalAmount / emiMonths;

        creditCardDTO.setBalance(creditCardDTO.getBalance() - debitTotal);

        LocalDate currentFromDate = billPeriodDTO.getFromDate();

        for (int i = 1; i <= emiMonths; i++) {
            LocalDate fromDate = currentFromDate;
            LocalDate toDate = fromDate.plusDays(29);

            // Create EMI transaction
            TransactionDTO emiTransaction = new TransactionDTO();
            emiTransaction.setTransactionId("EMI" + i);
            emiTransaction.setType("EMI");
            emiTransaction.setDate(fromDate);
            emiTransaction.setAmount(emi);
            creditCardDTO.getTransactions().add(emiTransaction);
            if (monthlyExpense != null && monthlyExpense > 0) {
                TransactionDTO expenseTransaction = new TransactionDTO();
                expenseTransaction.setTransactionId("EXP" + i);
                expenseTransaction.setType("Expense");
                expenseTransaction.setDate(fromDate);
                expenseTransaction.setAmount(monthlyExpense);
                creditCardDTO.getTransactions().add(expenseTransaction);
            }

            EMIEntity emiEntity = new EMIEntity();
            emiEntity.setEmiMonths(i);
            emiEntity.setFromDate(fromDate);
            emiEntity.setToDate(toDate);
            emiEntity.setEmiAmount(emi);
            emiEntity.setInterestRate(interestRate);
            emiEntity.setStatus(true);
            emiEntity.setCreditCard(creditCardEntity);

            saveEMI(EntityDTOMapper.toDTO(emiEntity));
            currentFromDate = fromDate.plusMonths(1);
        }
    }

    public EMIDTO findEMIById(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            EMIEntity entity = em.find(EMIEntity.class, id);
            if (entity == null) {
                throw new RuntimeException("EMI not found with ID: " + id);
            }
            return EntityDTOMapper.toDTO(entity);
        } finally {
            em.close();
        }
    }
}
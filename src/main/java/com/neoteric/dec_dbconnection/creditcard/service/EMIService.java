package com.neoteric.dec_dbconnection.creditcard.service;
import com.neoteric.dec_dbconnection.creditcard.entity.EMIEntity;
import com.neoteric.dec_dbconnection.creditcard.model.BillPeriodDTO;
import com.neoteric.dec_dbconnection.creditcard.model.CreditCardDTO;
import com.neoteric.dec_dbconnection.creditcard.model.EMIDTO;
import com.neoteric.dec_dbconnection.creditcard.model.TransactionDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;

public class EMIService {

    public void convertToEMI(CreditCardDTO creditCardDTO, int emiMonths, double interestRate, Double monthlyExpense) {
        if (creditCardDTO == null) {
            throw new IllegalArgumentException("CreditCardDTO cannot be null");
        }

        BillPeriodDTO billPeriodDTO = creditCardDTO.getBillPeriod();
        if (billPeriodDTO == null) {
            throw new IllegalArgumentException("BillPeriodDTO cannot be null in CreditCardDTO");
        }
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

        EMIEntity emiEntity = new EMIEntity();
        emiEntity.setFromDate(billPeriodDTO.getFromDate());
        emiEntity.setToDate(billPeriodDTO.getToDate());
        emiEntity.setPrincipalAmount(principal);
        emiEntity.setStatus(true);
        for (int i = 1; i <= emiMonths; i++) {
            LocalDate emiDate = LocalDate.ofEpochDay(billPeriodDTO.getFromDate().getDayOfMonth());

            TransactionDTO emiTransaction = new TransactionDTO();
            emiTransaction.setTransactionId("EMI" + i);
            emiTransaction.setType("EMI");
            emiTransaction.setDate(emiDate);
            emiTransaction.setAmount(emi);

            creditCardDTO.getTransactions().add(emiTransaction);

            if (monthlyExpense != null && monthlyExpense > 0) {
                TransactionDTO expenseTransaction = new TransactionDTO();
                expenseTransaction.setTransactionId("EXP" + i); // Unique transaction ID
                expenseTransaction.setType("Expense");
                expenseTransaction.setDate(emiDate);
                expenseTransaction.setAmount(monthlyExpense);

                creditCardDTO.getTransactions().add(expenseTransaction);
            }
        }


        saveEMI(EntityDTOMapper.toDTO(emiEntity));
    }

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
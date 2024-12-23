package com.neoteric.dec_dbconnection.creditcard.service;

import com.neoteric.dec_dbconnection.creditcard.entity.CreditCardEntity;
import com.neoteric.dec_dbconnection.creditcard.entity.TransactionEntity;
import com.neoteric.dec_dbconnection.creditcard.model.CreditCardDTO;
import com.neoteric.dec_dbconnection.creditcard.model.TransactionDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.Optional;

public class TransactionService {


    public void addTransaction(CreditCardDTO creditCard, TransactionDTO transaction) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transactionObj = em.getTransaction();
        try {
            transactionObj.begin();

            // Map DTOs to Entities
            CreditCardEntity creditCardEntity = EntityDTOMapper.toEntity(creditCard);
            TransactionEntity transactionEntity = EntityDTOMapper.toEntity(transaction);


            // Associate the transaction with the credit card
            creditCard.getTransactions().add(transaction);

            // Update balance based on transaction type
            if ("Debit".equalsIgnoreCase(transaction.getType())) {
                creditCard.setBalance(creditCard.getBalance() - transaction.getAmount());
            } else if ("Credit".equalsIgnoreCase(transaction.getType())) {
                creditCard.setBalance(creditCard.getBalance() + transaction.getAmount());
            }

            // Persist entities
            em.merge(creditCardEntity);
            em.persist(transactionEntity);

            transactionObj.commit();
        } catch (Exception e) {
            if (transactionObj.isActive()) {
                transactionObj.rollback();
            }
            throw new RuntimeException("Error while adding transaction", e);
        } finally {
            em.close();
        }

    }

    public  double calculateDebitTotal(CreditCardDTO creditCard) {
        return Optional.ofNullable(creditCard.getTransactions())
                .orElseThrow(() -> new IllegalArgumentException("Transactions list is null"))
                .stream()
                .filter(transaction -> "Debit".equalsIgnoreCase(transaction.getType()))
                .mapToDouble(TransactionDTO::getAmount)
                .sum();
    }

    public  double calculateCreditTotal(CreditCardDTO creditCard) {
        return Optional.ofNullable(creditCard.getTransactions())
                .orElseThrow(() -> new IllegalArgumentException("Transactions list is null"))
                .stream()
                .filter(transaction -> "Credit".equalsIgnoreCase(transaction.getType()))
                .mapToDouble(TransactionDTO::getAmount)
                .sum();
    }

    public TransactionDTO findTransactionById(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            TransactionEntity entity = em.find(TransactionEntity.class, id);
            if (entity == null) {
                throw new RuntimeException("Transaction not found with ID: " + id);
            }
            return EntityDTOMapper.toDTO(entity);
        } finally {
            em.close();
        }
    }
}
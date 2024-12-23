package com.neoteric.dec_dbconnection.creditcardsmartemi;


public class    TransactionService {
    public static void addTransaction(Creditcard creditCard, Transaction transaction) {
        creditCard.getTransaction().add(transaction);
        boolean isDebit = transaction.getTnxtype().equalsIgnoreCase("Debit");
        boolean isCredit = transaction.getTnxtype().equalsIgnoreCase("Credit");

        // Update the balance based on transaction type
        if (isDebit) {
            creditCard.setBalance(creditCard.getBalance() - transaction.getBalance());
        } else if (isCredit) {
            creditCard.setBalance(creditCard.getBalance() + transaction.getBalance());
        }
    }

    public static double calculateDebitTotal(Creditcard creditCard) {
        return creditCard.getTransaction().stream()
                .filter(transaction -> transaction.getTnxtype().equalsIgnoreCase("Debit"))
                .mapToDouble(Transaction::getBalance)
                .sum();
    }

    public static double calculateCreditTotal(Creditcard creditCard) {
        return creditCard.getTransaction().stream()
                .filter(transaction -> transaction.getTnxtype().equalsIgnoreCase("Credit"))
                .mapToDouble(Transaction::getBalance)
                .sum();
    }


    }




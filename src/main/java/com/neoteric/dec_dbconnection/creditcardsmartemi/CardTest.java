package com.neoteric.dec_dbconnection.creditcardsmartemi;

import java.time.LocalDate;
import java.util.ArrayList;

public class CardTest {
    public static void main(String[] args) {
        BillPeriod billPeriod = new BillPeriod(LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 25));
        Creditcard creditCard = new Creditcard("1234-5678-9876-5432", 50000, billPeriod,new ArrayList<>());

        TransactionService.addTransaction(creditCard, new Transaction("TXN001", 100, "Debit", LocalDate.of(2024, 12, 5)));
        TransactionService.addTransaction(creditCard, new Transaction("TXN002", 100, "Debit", LocalDate.of(2024, 12, 4)));
        TransactionService.addTransaction(creditCard, new Transaction("TXN003", 100, "Debit", LocalDate.of(2024, 12, 3)));
        TransactionService.addTransaction(creditCard, new Transaction("TXN004", 100, "Debit", LocalDate.of(2024, 12, 2)));
        TransactionService.addTransaction(creditCard, new Transaction("TXN005", 100, "Debit", LocalDate.of(2024, 12, 1)));
        TransactionService.addTransaction(creditCard, new Transaction("TXN006", 100, "Debit", LocalDate.of(2024, 12, 13)));
        TransactionService.addTransaction(creditCard, new Transaction("TXN007", 100, "Debit", LocalDate.of(2024, 12, 6)));
        TransactionService.addTransaction(creditCard, new Transaction("TXN008", 100, "Debit", LocalDate.of(2024, 12, 7)));
        TransactionService.addTransaction(creditCard, new Transaction("TXN009", 100, "Debit", LocalDate.of(2024, 12, 8)));
        TransactionService.addTransaction(creditCard, new Transaction("TXN010", 1000, "Debit", LocalDate.of(2024, 12, 15)));

        TransactionService.addTransaction(creditCard, new Transaction("TXN002", 1000, "Credit", LocalDate.of(2024, 12, 10)));

        System.out.println("Before EMI Conversion:");
        System.out.println(creditCard);

        EMIService.convertToEMI(creditCard, 10, 10,100.0); // 12 months EMI with 10% annual interest rate

       // TransactionService.addMonthlyExpenses(creditCard, 100, 12); // Monthly expense of 100 for 12 months

        System.out.println("After EMI Conversion and Adding Monthly Expenses:");
        System.out.println(creditCard);
    }
    }


package com.neoteric.dec_dbconnection.creditcardsmartemi;

import java.time.LocalDate;

public class EMIService {
    public static void convertToEMI(Creditcard creditCard, int emiMonths, double interestRate,Double monthlyExpense) {
        double debitTotal = TransactionService.calculateDebitTotal(creditCard);
        double creditTotal = TransactionService.calculateCreditTotal(creditCard);
        double principal = debitTotal - creditTotal;

        if (principal <= 0) {
            System.out.println("No EMI required as credits exceed debits.");
            return;
        }

        double totalInterest = (principal * interestRate * emiMonths) / 1200;
        double totalAmount = principal + totalInterest;
        double emi = totalAmount / emiMonths;

        creditCard.setBalance(creditCard.getBalance() - debitTotal);

        for (int i = 1; i <= emiMonths; i++) {
            LocalDate emiDate = creditCard.getBillPeriod().getFromDate().plusMonths(i);
            creditCard.getTransaction().add(new Transaction("EMI" + i, emi, "EMI", emiDate));
            double totalMonthlyExpense = emi + monthlyExpense;
            creditCard.getTransaction().add(new Transaction("EXP" + i, totalMonthlyExpense, "Expense", emiDate));
        }

    }

}

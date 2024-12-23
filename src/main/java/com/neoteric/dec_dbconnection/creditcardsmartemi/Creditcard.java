package com.neoteric.dec_dbconnection.creditcardsmartemi;

import java.util.List;

public class Creditcard {
    private  String cardNumber;

    private  double balance;
    private BillPeriod billPeriod;

    private List<Transaction> transaction;

    public Creditcard(String cardNumber, double balance, BillPeriod billPeriod, List<Transaction> transaction) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.billPeriod = billPeriod;
        this.transaction = transaction;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "Creditcard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                ", billPeriod=" + billPeriod +
                ", transaction=" + transaction +
                '}';
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BillPeriod getBillPeriod() {
        return billPeriod;
    }

    public void setBillPeriod(BillPeriod billPeriod) {
        this.billPeriod = billPeriod;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
}

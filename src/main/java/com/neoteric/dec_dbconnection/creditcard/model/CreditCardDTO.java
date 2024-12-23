package com.neoteric.dec_dbconnection.creditcard.model;

import java.util.ArrayList;
import java.util.List;

public class CreditCardDTO {
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    private String cardNumber;
    private double creditLimit;
    private BillPeriodDTO billPeriod;
    private List<TransactionDTO> transactions = new ArrayList<>();
    private List<EMIDTO> emis;

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public CreditCardDTO() {}


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BillPeriodDTO getBillPeriod() {
        return billPeriod;
    }

    public void setBillPeriod(BillPeriodDTO billPeriod) {
        this.billPeriod = billPeriod;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public List<EMIDTO> getEmis() {
        return emis;
    }

    public void setEmis(List<EMIDTO> emis) {
        this.emis = emis;
    }
}

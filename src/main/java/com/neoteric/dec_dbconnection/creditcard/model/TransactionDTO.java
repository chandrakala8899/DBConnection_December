package com.neoteric.dec_dbconnection.creditcard.model;

import com.neoteric.dec_dbconnection.creditcard.entity.TransactionKey;

import java.time.LocalDate;
import java.util.Date;

public class TransactionDTO {
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

    private String transactionId;
    private double amount;
    private String type;
    private LocalDate date;

    private String status;


    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}

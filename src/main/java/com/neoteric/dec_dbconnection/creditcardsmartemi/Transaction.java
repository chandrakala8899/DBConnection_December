package com.neoteric.dec_dbconnection.creditcardsmartemi;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private String tnxid;
    private double balance;

    private String tnxtype;

    @Override
    public String toString() {
        return "Transaction{" +
                "tnxid='" + tnxid + '\'' +
                ", balance=" + balance +
                ", tnxtype='" + tnxtype + '\'' +
                ", date=" + date +
                '}';
    }

    public String getTnxid() {
        return tnxid;
    }

    public void setTnxid(String tnxid) {
        this.tnxid = tnxid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getTnxtype() {
        return tnxtype;
    }

    public void setTnxtype(String tnxtype) {
        this.tnxtype = tnxtype;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private LocalDate date;

    public Transaction(String tnxid, double balance, String tnxtype, LocalDate date) {
        this.tnxid = tnxid;
        this.balance = balance;
        this.tnxtype = tnxtype;
        this.date = date;
    }
}

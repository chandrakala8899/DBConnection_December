package com.neoteric.dec_dbconnection.creditcard.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "creditcard_table",schema = "creditcard")
public class CreditCardEntity {
    public CreditCardEntity(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private double creditLimit;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    private BillPeriodEntity billPeriod;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditCard")
    private List<TransactionEntity> transactions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditCard")
    private List<EMIEntity> emis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BillPeriodEntity getBillPeriod() {
        return billPeriod;
    }

    public void setBillPeriod(BillPeriodEntity billPeriod) {
        this.billPeriod = billPeriod;
    }

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    public List<EMIEntity> getEmis() {
        return emis;
    }

    public void setEmis(List<EMIEntity> emis) {
        this.emis = emis;
    }
}
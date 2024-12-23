package com.neoteric.dec_dbconnection.creditcard.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "emi_table",schema = "creditcard")
public class EMIEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double principalAmount;
    private double emiAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }

    public int getEmiMonths() {
        return emiMonths;
    }

    public void setEmiMonths(int emiMonths) {
        this.emiMonths = emiMonths;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CreditCardEntity getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardEntity creditCard) {
        this.creditCard = creditCard;
    }

    private int emiMonths;
    private double interestRate;
    private boolean status;

    private LocalDate fromDate;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    private LocalDate toDate;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCardEntity creditCard;
}







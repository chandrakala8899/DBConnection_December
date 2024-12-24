package com.neoteric.dec_dbconnection.creditcard.model;

import java.time.LocalDate;

public class EMIDTO {
  //  private double principalAmount;
    private double emiAmount;
    private int emiMonths;
    private double interestRate;
    private  boolean status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public EMIDTO() {}

//    public double getPrincipalAmount() {
//        return principalAmount;
//    }
//
//    public void setPrincipalAmount(double principalAmount) {
//        this.principalAmount = principalAmount;
//    }

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

    public EMIDTO(double principalAmount, int emiMonths, double interestRate) {
      //  this.principalAmount = principalAmount;
        this.emiMonths = emiMonths;
        this.interestRate = interestRate;
    }
}

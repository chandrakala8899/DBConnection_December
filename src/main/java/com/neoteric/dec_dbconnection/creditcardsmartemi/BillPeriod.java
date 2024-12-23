package com.neoteric.dec_dbconnection.creditcardsmartemi;

import java.time.LocalDate;
import java.util.Date;

public class BillPeriod {

    private LocalDate fromDate;

    private LocalDate toDate;
    public BillPeriod(LocalDate fromDate, LocalDate toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    @Override
    public String toString() {
        return "BillPeriod{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
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
}
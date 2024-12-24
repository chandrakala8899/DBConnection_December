package com.neoteric.dec_dbconnection.creditcard.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TransactionKey implements Serializable {
    private String transactionId;
    private String transactionType;

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    // hashCode and equals for composite key comparison
    @Override
    public int hashCode() {
        return Objects.hash(transactionId, transactionType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TransactionKey that = (TransactionKey) obj;
        return Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(transactionType, that.transactionType);
    }

}

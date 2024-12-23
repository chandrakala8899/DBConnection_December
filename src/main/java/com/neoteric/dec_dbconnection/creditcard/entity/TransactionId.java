package com.neoteric.dec_dbconnection.creditcard.entity;

import java.io.Serializable;

public class TransactionId implements Serializable {
    private String tnxId;

    private   boolean status;

    public String getTnxId() {
        return tnxId;
    }

    public void setTnxId(String tnxId) {
        this.tnxId = tnxId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

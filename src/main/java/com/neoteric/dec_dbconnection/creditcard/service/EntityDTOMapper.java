package com.neoteric.dec_dbconnection.creditcard.service;

import com.neoteric.dec_dbconnection.creditcard.entity.BillPeriodEntity;
import com.neoteric.dec_dbconnection.creditcard.entity.CreditCardEntity;
import com.neoteric.dec_dbconnection.creditcard.entity.EMIEntity;
import com.neoteric.dec_dbconnection.creditcard.entity.TransactionEntity;
import com.neoteric.dec_dbconnection.creditcard.model.BillPeriodDTO;
import com.neoteric.dec_dbconnection.creditcard.model.CreditCardDTO;
import com.neoteric.dec_dbconnection.creditcard.model.EMIDTO;
import com.neoteric.dec_dbconnection.creditcard.model.TransactionDTO;

public class EntityDTOMapper {
    public static CreditCardDTO toDTO(CreditCardEntity entity) {
        if (entity == null) return null;

        CreditCardDTO dto = new CreditCardDTO();
        dto.setCardNumber(entity.getCardNumber());
        dto.setCreditLimit(entity.getCreditLimit());
        dto.setStatus(entity.getStatus());
        dto.setBillPeriod(toDTO(entity.getBillPeriod())); // Handles null BillPeriodEntity
        return dto;
    }

    public static CreditCardEntity toEntity(CreditCardDTO dto) {
        if (dto == null) return null;

        CreditCardEntity entity = new CreditCardEntity();
        entity.setCardNumber(dto.getCardNumber());
        entity.setCreditLimit(dto.getCreditLimit());
        entity.setStatus(dto.isStatus());
        entity.setBillPeriod(toEntity(dto.getBillPeriod())); // Handles null BillPeriodDTO
        return entity;
    }

    public static TransactionDTO toDTO(TransactionEntity entity) {
        if (entity == null) return null;

        TransactionDTO dto = new TransactionDTO();
        dto.setAmount(entity.getAmount());
        dto.setTransactionId(entity.getTransactionId());
        dto.setDate(entity.getDate());
        dto.setType(entity.getType());
        dto.setStatus(entity.isStatus());
        return dto;
    }

    public static TransactionEntity toEntity(TransactionDTO dto) {
        if (dto == null) return null;

        TransactionEntity entity = new TransactionEntity();
        entity.setStatus(dto.isStatus());
        entity.setType(dto.getType());
        entity.setAmount(dto.getAmount());
        entity.setDate(dto.getDate());
        entity.setTransactionId(dto.getTransactionId());
        return entity;
    }

    public static BillPeriodDTO toDTO(BillPeriodEntity entity) {
        if (entity == null) return null;

        BillPeriodDTO dto = new BillPeriodDTO();
        dto.setFromDate(entity.getFromDate());
        dto.setToDate(entity.getToDate());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static BillPeriodEntity toEntity(BillPeriodDTO dto) {
        if (dto == null) return null;

        BillPeriodEntity billPeriod = new BillPeriodEntity();
        billPeriod.setFromDate(dto.getFromDate());
        billPeriod.setToDate(dto.getToDate());
        billPeriod.setStatus(dto.getStatus());
        return billPeriod;
    }

    public static EMIDTO toDTO(EMIEntity entity) {
        if (entity == null) return null;

        EMIDTO dto = new EMIDTO();
        dto.setPrincipalAmount(entity.getPrincipalAmount());
        dto.setEmiAmount(entity.getEmiAmount());
        dto.setEmiMonths(entity.getEmiMonths());
        dto.setInterestRate(entity.getInterestRate());
        dto.setStatus(entity.isStatus());
        return dto;
    }

    public static EMIEntity toEntity(EMIDTO dto) {
        if (dto == null) return null;

        EMIEntity entity = new EMIEntity();
        entity.setPrincipalAmount(dto.getPrincipalAmount());
        entity.setEmiAmount(dto.getEmiAmount());
        entity.setEmiMonths(dto.getEmiMonths());
        entity.setInterestRate(dto.getInterestRate());
        entity.setStatus(dto.isStatus());
        return entity;
    }


    }
package com.neoteric.dec_dbconnection.creditcard.service;

import com.neoteric.dec_dbconnection.creditcard.entity.BillPeriodEntity;
import com.neoteric.dec_dbconnection.creditcard.model.BillPeriodDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class BillService {
    public void saveBillPeriod(BillPeriodDTO dto) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            BillPeriodEntity entity = EntityDTOMapper.toEntity(dto);
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public BillPeriodDTO findBillPeriodById(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            BillPeriodEntity entity = em.find(BillPeriodEntity.class, id);
            return EntityDTOMapper.toDTO(entity);
        } finally {
            em.close();
        }
    }
}

package com.neoteric.dec_dbconnection.creditcard.service;

import com.neoteric.dec_dbconnection.creditcard.entity.CreditCardEntity;
import com.neoteric.dec_dbconnection.creditcard.model.CreditCardDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class CreditCardService {
    public void saveCreditCard(CreditCardDTO dto) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            CreditCardEntity entity = EntityDTOMapper.toEntity(dto);
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public CreditCardDTO findCreditCardById(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            CreditCardEntity entity = em.find(CreditCardEntity.class, id);
            return EntityDTOMapper.toDTO(entity);
        } finally {
            em.close();
        }
    }
}
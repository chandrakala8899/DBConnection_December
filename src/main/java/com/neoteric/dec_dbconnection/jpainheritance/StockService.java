package com.neoteric.dec_dbconnection.jpainheritance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StockService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaDemo");

    public void saveStock(StockEntity stock) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(stock);
        em.getTransaction().commit();
        em.close();
    }

    public StockEntity getStock(Long id) {
        EntityManager em = emf.createEntityManager();
        StockEntity stock = em.find(StockEntity.class, id);
        em.close();
        return stock;
    }
}

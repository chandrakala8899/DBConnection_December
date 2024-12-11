package com.neoteric.dec_dbconnection.jpa_db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class EmployeeService {

public List<ProjectEntity> projectAlloctionEmployees(){
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();


    Query query = entityManager.createNativeQuery("SELECT p.id AS projectId, e.id AS employeeId, e.name AS employeeName " +
            "FROM ProjectEntity p INNER JOIN p.employees e", ProjectEntity.class);
    List<ProjectEntity> projectEntities = query.getResultList();

    entityManager.getTransaction().commit();
  return  projectEntities;
}
}

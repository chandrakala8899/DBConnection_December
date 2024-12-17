package com.neoteric.dec_dbconnection.jpa_db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class DatasetProjectService {

    public static void insertEmployee(EmployeeEntity employee) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();


        String sql = "INSERT INTO sonar.employee_latest (id, name, dept, salary) VALUES (?, ?, ?, ?)";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter(1, employee.getId());
        query.setParameter(2, employee.getName());
        query.setParameter(3, employee.getDepartment());
        query.setParameter(4, employee.getSalary());

        query.executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
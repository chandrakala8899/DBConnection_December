package com.neoteric.dec_dbconnection.jpa_db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatasetProjectService {
    public void insertEmployee(String name, String dept, double salary) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            EmployeeEntity employee = new EmployeeEntity();
            employee.setName(name);
            employee.setDepartment(dept);
            employee.setSalary(salary);

            entityManager.persist(employee);

            entityManager.getTransaction().commit();

            System.out.println("Employee inserted successfully: " + employee);
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
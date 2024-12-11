package com.neoteric.dec_dbconnection.jpaconnection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.*;

public class JpaService {
    public JpaService() {

    }

    public static List<Project> getAllocationEmployees() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaDemo");
        EntityManager entityManager = emf.createEntityManager();
        List<Project> projects = new ArrayList<>();
        Map<Integer, Project> projectMap = new HashMap<>();

        try {
            entityManager.getTransaction().begin();
            Integer projectId = 1;

            Query query = entityManager.createQuery(
                    "SELECT p FROM Project p LEFT JOIN FETCH p.employees e WHERE p.id = :projectId"
            );
            query.setParameter("projectId", projectId);

            List<Project> resultSet = query.getResultList();

            for (Project project : resultSet) {
                Project project2 = new Project();
                project2.setId(project.getId());
                project2.setName(project.getName());
                project2.setStartDate(project.getStartDate());
                project2.setEndDate(project.getEndDate());

                List<Employee> employees = new ArrayList<>();
                project2.setEmployees(employees);

                for (Employee employee : project.getEmployees()) {
                    Employee employeeObj = new Employee();
                    employeeObj.setName(employee.getName());
                    employees.add(employeeObj);
                }

                projectMap.put(project.getId(), project2);
            }

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return projects;
    }
}
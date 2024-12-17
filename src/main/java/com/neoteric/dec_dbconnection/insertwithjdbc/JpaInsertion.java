package com.neoteric.dec_dbconnection.insertwithjdbc;
import com.neoteric.dec_dbconnection.jpa_db.EmployeeEntity;
import com.neoteric.dec_dbconnection.jpa_db.ProjectEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.sql.Date;
import java.util.List;

public class JpaInsertion {

    // Create EntityManagerFactory and EntityManager
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaDemo");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    // Method to get max project ID
    public int getMaxProjectId(String query) {
        Query query1 = entityManager.createQuery(query);
        Object result = query1.getSingleResult();

        // If result is null, return 1, else return the maxId + 1
        Integer maxId = result != null ? (Integer) result : 0;
        return maxId + 1;
    }

    // Method to insert project
    public void insertProject(ProjectEntity project) {
        // Begin transaction
        entityManager.getTransaction().begin();
        try {
            // Insert project using a native SQL query
            String sql = "INSERT INTO sonar.project_latest(id, pname, startdate, enddate) VALUES (?, ?, ?, ?)";
            Query query = entityManager.createNativeQuery(sql);

            query.setParameter(1, project.getId());
            query.setParameter(2, project.getName());
            query.setParameter(3, new Date(project.getStartDate().getTime())); // Converting Date to sql.Date
            query.setParameter(4, new Date(project.getEndDate().getTime()));

            // Execute the insert query
            int status = query.executeUpdate();
            if (status == 1) {
                System.out.println("  Insertion successful");
            } else {
                System.out.println(" Insertion Failed ");
            }


            // Commit transaction
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            // Rollback transaction in case of error
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    // Method to insert employee
    public void insertEmployee(EmployeeEntity employee) {
        // Begin transaction
        entityManager.getTransaction().begin();
        try {
            // Insert employee using a native SQL query
            String sql = "INSERT INTO sonar.employee_latest(id, name, salary, dept, pid) VALUES (?, ?, ?, ?, ?)";
            Query query = entityManager.createNativeQuery(sql);

            query.setParameter(1, employee.getId());
            query.setParameter(2, employee.getName());
            query.setParameter(3, employee.getSalary());
            query.setParameter(4, employee.getDepartment());
            query.setParameter(5, employee.getPid());

            // Execute the insert query
      int status = query.executeUpdate();
            if (status == 1) {
                System.out.println("  Insertion successful");
            } else {
                System.out.println(" Insertion Failed ");
            }

            // Commit transaction
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            // Rollback transaction in case of error
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    // Method to save project and associated employees
    public void saveProjectEmployee(List<ProjectEntity> projects) {
        for (int i = 0; i < projects.size(); i++) {
            ProjectEntity project = projects.get(i);
            int maxProjectId = getMaxProjectId("SELECT MAX(p.id) FROM ProjectEntity p");
            project.setId(maxProjectId);
            insertProject(project);

            project.getEmployees().forEach(emp -> {
                int empMaxId = getMaxProjectId("SELECT MAX(e.id) FROM EmployeeEntity e");
                emp.setId(empMaxId);
                emp.setPid(project.getId());

                insertEmployee(emp);
            });
        }
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
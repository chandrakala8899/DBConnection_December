package com.neoteric.dec_dbconnection.jpaonetomany;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    public void savejpa(Project project){

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("JpaDemo");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ProjectEntity projectEntity=new ProjectEntity();
        projectEntity.setName(project.getName());
        projectEntity.setStartDate(project.getStartDate());
        projectEntity.setEndDate(project.getEndDate());

        List<EmployeeEntity> employeeEntityList = new ArrayList<>();

        for(int i=0; i<project.getEmployeeList().size();i++){
            Employee emp = project.getEmployeeList().get(i);
            EmployeeEntity employee = new EmployeeEntity();
            employee.setName(emp.getName());
            employee.setDepartment(emp.getDept());
            employee.setSalary(emp.getSalary());
            employee.setProject(projectEntity);

            AadharEntity aadharDetails = new AadharEntity();
            aadharDetails.setAadharNumber(emp.getAadharDetails().getAadharNumber());
            aadharDetails.setIssueDate(emp.getAadharDetails().getIssueDate());
            employee.setAadharDetails(aadharDetails);

            employeeEntityList.add(employee);

        }
        projectEntity.setEmployees(employeeEntityList);
        entityManager.persist(projectEntity);

        entityManager.getTransaction().commit();
    }
}




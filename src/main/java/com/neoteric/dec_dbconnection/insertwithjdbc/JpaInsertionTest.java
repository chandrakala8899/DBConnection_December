package com.neoteric.dec_dbconnection.insertwithjdbc;

import com.neoteric.dec_dbconnection.dbconnection.Employee;
import com.neoteric.dec_dbconnection.dbconnection.Project;
import com.neoteric.dec_dbconnection.jpa_db.EmployeeEntity;
import com.neoteric.dec_dbconnection.jpa_db.ProjectEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JpaInsertionTest {
    public static void main(String[] args) {
        List<ProjectEntity> projectList = new ArrayList<>();

        ProjectEntity avvota1 = new ProjectEntity();
        avvota1.setName("avvota1");
        avvota1.setStartDate(new Date());
        avvota1.setEndDate(new Date());


        ProjectEntity plumSoft1 = new ProjectEntity();
        plumSoft1.setName("plumSoft");
        plumSoft1.setStartDate(new Date());
        plumSoft1.setEndDate(new Date());

      projectList.add(avvota1);
      projectList.add(plumSoft1);

        EmployeeEntity chandu1 = new EmployeeEntity();
        chandu1.setName("chandu1");
        chandu1.setDepartment("IT");
        chandu1.setSalary(30000);

        avvota1.getEmployees().add(chandu1);

        EmployeeEntity chandu2 = new EmployeeEntity();
        chandu2.setName("chandu1");
        chandu2.setDepartment("IT");
        chandu2.setSalary(30000);

        avvota1.getEmployees().add(chandu2);

        EmployeeEntity chandu3 = new EmployeeEntity();
        chandu3.setName("chandu");
        chandu3.setDepartment("IT");
        chandu3.setSalary(30000);

        avvota1.getEmployees().add(chandu3);

        EmployeeEntity shekar1 = new EmployeeEntity();
        shekar1.setName("shekar1");
        shekar1.setDepartment("IT");
        shekar1.setSalary(30000);

        plumSoft1.getEmployees().add(shekar1);

        EmployeeEntity shekar2 = new EmployeeEntity();
        shekar2.setName("shekar2");
        shekar2.setDepartment("IT");
        shekar2.setSalary(30000);

        plumSoft1.getEmployees().add(shekar2);

        EmployeeEntity shekar3 = new EmployeeEntity();
        shekar3.setName("shekar3");
        shekar3.setDepartment("IT");
        shekar3.setSalary(30000);

        plumSoft1.getEmployees().add(shekar3);

        JpaInsertion jpaInsertion = new JpaInsertion();
        jpaInsertion.saveProjectEmployee(projectList);
    }
}

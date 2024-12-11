package com.neoteric.dec_dbconnection.jpaconnection;

import java.util.List;

public class JpaTest {
    public static void main(String[] args) {
        List<Project> projectList = JpaService.getAllocationEmployees();

        for (Project project : projectList) {
            System.out.println("Project Name: " + project.getName());
            for (Employee employee : project.getEmployees()) {
                System.out.println("Employee Name: " + employee.getName());
            }
        }
    }
}

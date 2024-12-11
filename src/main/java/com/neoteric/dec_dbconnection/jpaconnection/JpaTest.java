package com.neoteric.dec_dbconnection.jpaconnection;

import java.util.List;
import java.util.Map;

public class JpaTest {
    public static void main(String[] args) {
//        List<Project> projectList = JpaService.getAllocationEmployees();
//
//        for (Project project : projectList) {
//            System.out.println("Project Name: " + project.getName());
//            for (Employee employee : project.getEmployees()) {
//                System.out.println("Employee Name: " + employee.getName());
//            }
//
        JpaPractice jpaPractice = new JpaPractice();
        Map<Integer, List<Employee>> projectEmployeeMap = jpaPractice.getAllocationEmployeesJpa();

        for (Map.Entry<Integer, List<Employee>> entry : projectEmployeeMap.entrySet()) {
            System.out.println("Project ID: " + entry.getKey());
            for (Employee employee : entry.getValue()) {
                System.out.println("Employee Name: " + employee.getName());
            }
        }
    }
}

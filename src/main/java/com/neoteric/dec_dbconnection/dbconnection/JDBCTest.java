package com.neoteric.dec_dbconnection.dbconnection;

import java.util.List;

public class JDBCTest {
   public static void main(String[] args) {
//     JDBCConnection.getAllocationEmployees();
//        List<Project> projects =  JDBCConnection.getAllocationEmployees();
//        for (Project project : projects) {
//            System.out.println(project);
//        }


      List<Employee> employees = DBService.getEmployeeManagerHierarchy();
       for(Employee employee : employees){
           System.out.println(employee);
       }

    }
}

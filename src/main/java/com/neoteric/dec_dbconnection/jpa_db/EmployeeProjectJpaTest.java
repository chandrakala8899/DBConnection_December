package com.neoteric.dec_dbconnection.jpa_db;

import java.util.List;

public class EmployeeProjectJpaTest {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
       List<ProjectEntity> projectList =  employeeService.projectAlloctionJoinFetch();
        for(int i =0 ; i<projectList.size(); i++ ) {
            System.out.println(" Project  " + projectList.get(i));
            projectList.get(i).getEmployees().forEach(emp -> {
                System.out.println("  emp " + emp);
            });

        }
            System.out.println(projectList);

//        EmployeeService employeeService1 = new EmployeeService();
//        List<EmployeeEntity> employeeEntities  = employeeService1.projectAlloctionEmployeesSelfJoin();
//        for(int i =0 ; i<employeeEntities.size(); i++ ) {
//            System.out.println(" Project  " + employeeEntities.get(i));
//            employeeEntities.get(i).getEmployeeList().forEach(emp -> {
//                System.out.println("  emp " + emp);
//            });
//
//        }
//        System.out.println(employeeEntities);

    }
}



package com.neoteric.dec_dbconnection.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBService {
    public static List<Employee> getEmployeeManagerHierarchy() {
        String url = "jdbc:mysql://localhost:3307/sonar";
        String user = "root";
        String password = "sonar";

        List<Employee> managerList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        Map<Integer, Employee> employeeMap = new HashMap<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            String query = " select  m.name ,e. * from sonar.Employee e,sonar.Employee m  where e.mid = m.id";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int managerId = resultSet.getInt("mid");
                String managerName = resultSet.getString("name");

                int employeeId = resultSet.getInt("id");
                String employeeName = resultSet.getString("name");
                double employeeSalary = resultSet.getDouble("salary");
                String employeeDept = resultSet.getString("dept");
                int projectId = resultSet.getInt("pid");

                Employee manager = employeeMap.getOrDefault(managerId, new Employee());
                if (!employeeMap.containsKey(managerId)) {
                    manager.setId(employeeId);
                    manager.setMid(managerId);
                    manager.setPid(projectId);
                    manager.setName(managerName);
                    manager.setDept(employeeDept);
                    manager.setSalary(employeeSalary);
                    manager.setEmployeeList(new ArrayList<>());
                    managerList.add(manager);
                    employeeMap.put(managerId, manager);
                }

                    Employee employee = new Employee();
                    employee.setId(employeeId);
                    employee.setName(employeeName);
                    employee.setSalary(employeeSalary);
                    employee.setDept(employeeDept);
                    employee.setPid(projectId);
                    employee.setMid(managerId);

                    manager.getEmployeeList().add(employee);
                    employeeList.add(employee);
                }

        } catch (Exception e) {
            System.out.println("Error occurred while connecting to the database or processing data.");
            e.printStackTrace();
        }

        System.out.println("Managers List:");
        for (Employee manager : managerList) {
            System.out.println(manager.getName() + " (" + manager.getId() + ")");
        }

        System.out.println("Employees List:");
        for (Employee employee : employeeList) {
            System.out.println(employee.getName() + " (" + employee.getId() + ")");
        }

        return managerList;
    }
}
package com.neoteric.dec_dbconnection.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCSelfJoin {
    public static Map<Integer, Employee> getEmployeeManagerHierarchy() {
        String url = "jdbc:mysql://localhost:3307/sonar";
        String user = "sonar";
        String password = "sonar";

        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<Employee> employeeList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            String query = "SELECT e.id AS employee_id, e.name AS employee_name, e.salary, e.dept, e.pid, e.mid, " +
                    "m.name AS manager_name, m.id AS manager_id FROM sonar.Employee e " +
                    "JOIN sonar.Employee m ON e.mid = m.id;";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int managerId = resultSet.getInt("manager_id");
                String managerName = resultSet.getString("manager_name");

                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                double salary = resultSet.getDouble("salary");
                String dept = resultSet.getString("dept");
                int projectId = resultSet.getInt("pid");
              //  int employeeManagerId = resultSet.getInt("mid");

                Employee manager = employeeMap.getOrDefault(managerId, new Employee());
                if (!employeeMap.containsKey(managerId)) {
                    manager.setId(managerId);
                    manager.setName(managerName);
                    manager.setEmployeeList(new ArrayList<>());
                    employeeMap.put(managerId, manager);
                }

                Employee employee = new Employee();
                employee.setId(employeeId);
                employee.setName(employeeName);
                employee.setSalary(salary);
                employee.setDept(dept);
                employee.setPid(projectId);

                manager.getEmployeeList().add(employee);

                if (!employeeMap.containsKey(employeeId)) {
                    employeeMap.put(employeeId, employee);
                }

                employeeList.add(employee);
            }

        } catch (Exception e) {
            System.out.println("Error occurred while connecting to the database or processing data.");
            e.printStackTrace();
        }

        return employeeMap;
    }

    public static void main(String[] args) {

        Map<Integer, Employee> employeeMap = getEmployeeManagerHierarchy();

        System.out.println("Employee and Manager Hierarchy:");

        for (Employee employee : employeeMap.values()) {
            System.out.println(employee.getName() + " (Employee ID: " + employee.getId() + ")");

            Employee manager = employeeMap.get(employee.getMid());
            if (manager != null) {
                System.out.println("    Manager: " + manager.getName() + " (Manager ID: " + manager.getId() + ")");
            }

            List<Employee> subordinates = employee.getEmployeeList();
            if (!subordinates.isEmpty()) {
                System.out.println("    Subordinates: ");
                for (Employee subordinate : subordinates) {
                    System.out.println("        - " + subordinate.getName() + " (Employee ID: " + subordinate.getId() + ")");
                }
            }
        }
    }
}

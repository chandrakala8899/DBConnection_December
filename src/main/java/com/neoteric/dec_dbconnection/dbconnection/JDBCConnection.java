package com.neoteric.dec_dbconnection.dbconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCConnection {
    public  static List<Project> getAllocationEmployees(){

        String url = "jdbc:mysql://localhost:3307/sonar";
        String user = "root";
        String password = "sonar";

        List<Project> projects = new ArrayList<>();
        Map<Integer, Project> projectMap = new HashMap<>();
        Map<Integer, Employee> employeeMap = new HashMap<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            String query =  "SELECT " +"e.id AS EmployeeID, e.name AS EmployeeName, e.pid AS ProjectId, " + "e.salary, e.dept, " +
                    "m.id AS ManagerID, m.name AS ManagerName, " + "p.pname AS ProjectName, p.startdate, p.enddate " +
                    "FROM sonar.Employee e " + "LEFT JOIN sonar.Employee m ON e.mid = m.id " +"INNER JOIN sonar.project p ON e.pid = p.id";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {


                int projectId = resultSet.getInt("ProjectId");
                Project project = projectMap.getOrDefault(projectId, new Project());
                if (!projectMap.containsKey(projectId)) {
                    project.setId(projectId);
                    project.setPname(resultSet.getString("ProjectName"));
                    project.setStartdate(resultSet.getDate("startdate").toLocalDate());
                    project.setEnddate(resultSet.getDate("enddate").toLocalDate());
                    project.setEmployeeList(new ArrayList<>());
                    projectMap.put(projectId, project);
                    projects.add(project);
                }

                int employeeId = resultSet.getInt("EmployeeID");
                Employee employee = employeeMap.getOrDefault(employeeId, new Employee());
                if (!employeeMap.containsKey(employeeId)) {
                    employee.setId(employeeId);
                    employee.setName(resultSet.getString("EmployeeName"));
                    employee.setSalary(resultSet.getDouble("salary"));
                    employee.setDept(resultSet.getString("dept"));
                    employee.setPid(projectId);
                    employee.setEmployeeList(new ArrayList<>());
                    employeeMap.put(employeeId, employee);
                    project.getEmployeeList().add(employee);
                }

                int managerId = resultSet.getInt("ManagerID");
                if (managerId != 0) {
                    Employee manager = employeeMap.getOrDefault(managerId, new Employee());
                    if (!employeeMap.containsKey(managerId)) {
                        manager.setId(managerId);
                        manager.setName(resultSet.getString("ManagerName"));
                        manager.setEmployeeList(new ArrayList<>());
                        employeeMap.put(managerId, manager);
                    }
                    manager.getEmployeeList().add(employee);
                    employee.setMid(managerId);
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred while connecting to the database or processing data.");
            e.printStackTrace();
        }
        return projects;
    }
}

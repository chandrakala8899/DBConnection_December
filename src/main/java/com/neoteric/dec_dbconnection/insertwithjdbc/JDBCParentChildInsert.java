package com.neoteric.dec_dbconnection.insertwithjdbc;
import com.neoteric.dec_dbconnection.dbconnection.Employee;
import com.neoteric.dec_dbconnection.dbconnection.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCParentChildInsert {
    public int getMaxProjectId(String query) {

        int max = 0;
        Connection con;
        PreparedStatement smt;
        ResultSet resultSet;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sonar", "root", "sonar");
            smt = con.prepareStatement(query);
            resultSet = smt.executeQuery();

            if (resultSet != null && resultSet.next()) {
                max = resultSet.getInt(1) + 1;
            } else {
                max = 1;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return max;
    }

    public void insertEmployee(Employee employee) {

        int max = 0;
        Connection con;
        PreparedStatement smt;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sonar", "root", "sonar");
            smt = con.prepareStatement("insert into sonar.employee_latest(id,name,salary,dept,pid) values(?,?,?,?,?)");

            smt.setInt(1, employee.getId());
            smt.setString(2, employee.getName());
            smt.setDouble(3, employee.getSalary());
            smt.setString(4, employee.getDept());
            smt.setInt(5, employee.getPid());

            int status = smt.executeUpdate();

            if (status == 1) {
                System.out.println("  Insertion successful");
            } else {
                System.out.println(" Insertion Failed ");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void inserProject(Project project) {
        Connection con;
        PreparedStatement smt;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sonar", "root", "sonar");
           // con.setAutoCommit(false);
            smt = con.prepareStatement("insert into sonar.project_latest(id,pname,startdate,enddate) values(?,?,?,?)");

            smt.setInt(1, project.getId());
            smt.setString(2, project.getPname());
            smt.setDate(3, new Date(project.getStartdate().getTime()));
            smt.setDate(4, new Date(project.getEnddate().getTime()));

            int status = smt.executeUpdate();

            if (status == 1) {
                System.out.println("  Insertion successful");
            } else {
                System.out.println(" Insertion Failed ");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // iterate Project
    //get maxpid
    // insert project
    // get maxid
    // insert employee


    public void saveProjectEmployee(List<Project> projects) {
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            int maxProjectId = getMaxProjectId("select max(id) from sonar.project_latest");
            project.setId(maxProjectId);
            inserProject(project);
//  try {
//
//      Thread.sleep(60000);
//  }catch (Exception e){
//      System.out.println("after 60000");
//  }


  project.getEmployeeList().forEach(emp -> {

                        int empMaxId = getMaxProjectId("select  max(id) from sonar.employee_latest");
                        emp.setId(empMaxId);
                        emp.setPid(project.getId());

                        insertEmployee(emp);
                    }

            );
        }
    }

    public List<Employee> getEmployeesAllocation(double salary, String dept) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT id, name, dept, salary, pid FROM sonar.employee_latest WHERE salary < ? OR dept = ?";

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sonar", "root", "sonar");
                PreparedStatement smt = con.prepareStatement(query)
        ) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Bind parameters
            smt.setDouble(1, salary);
            smt.setString(2, dept);

            try (ResultSet resultSet = smt.executeQuery()) {
                while (resultSet.next()) {
                    Employee emp = new Employee();
                    emp.setId(resultSet.getInt("id"));
                    emp.setName(resultSet.getString("name"));
                    emp.setDept(resultSet.getString("dept"));
                    emp.setSalary(resultSet.getDouble("salary"));
                    emp.setPid(resultSet.getInt("pid"));
                    employees.add(emp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
}
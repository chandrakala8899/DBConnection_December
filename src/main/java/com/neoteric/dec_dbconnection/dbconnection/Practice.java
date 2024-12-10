package com.neoteric.dec_dbconnection.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Practice {
    public  static List<Project>   projectsAssignedEmployees() {
        String url = "jdbc:mysql://localhost:3307/sonar";
        String userName = "root";
        String passWord = "sonar";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(url,userName,passWord);
     con.prepareStatement("SELECT * FROM sonar.Employee WHERE dept = ? AND salary >= ?");



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

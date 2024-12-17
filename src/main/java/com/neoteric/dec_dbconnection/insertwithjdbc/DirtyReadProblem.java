package com.neoteric.dec_dbconnection.insertwithjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DirtyReadProblem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "root";
    private static final String PASSWORD = "Chandu@0210";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {

            simulateDirtyRead(conn);

            simulatePhantomRead(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Simulate Dirty Read (Read Uncommitted)
    public static void simulateDirtyRead(Connection conn) throws Exception {
        // Set the transaction isolation level to Read Uncommitted
        conn.setAutoCommit(false); // Begin transaction
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED); // Set isolation level

        // Transaction 1: Update an employee salary without committing
        try (Statement stmt = conn.createStatement()) {
            String updateQuery = "UPDATE employees SET salary = salary + 1000 WHERE employee_id = 101";
            stmt.executeUpdate(updateQuery);

            // Transaction 2: Read the uncommitted salary change (Dirty Read)
            try (Statement stmt2 = conn.createStatement()) {
                String selectQuery = "SELECT salary FROM employees WHERE employee_id = 101";
                ResultSet rs = stmt2.executeQuery(selectQuery);

                if (rs.next()) {
                    System.out.println("Transaction 2 - Dirty Read: Employee 101's salary is " + rs.getDouble("salary"));
                }
            }
        }

        // Rollback Transaction 1 to simulate dirty data
        conn.rollback();
        System.out.println("Transaction 1 rolled back, salary change is undone.");
    }

    // Simulate Phantom Read (Repeatable Read)
    public static void simulatePhantomRead(Connection conn) throws Exception {
        // Set the transaction isolation level to Repeatable Read
        conn.setAutoCommit(false); // Begin transaction
        conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ); // Set isolation level

        // Transaction 1: Select employees with salary > 50000
        try (Statement stmt = conn.createStatement()) {
            String selectQuery = "SELECT * FROM employees WHERE salary > 50000";
            ResultSet rs1 = stmt.executeQuery(selectQuery);

            // Print the initial set of employees
            System.out.println("Transaction 1 - Initial Read:");
            while (rs1.next()) {
                System.out.println("Employee ID: " + rs1.getInt("employee_id") + ", Name: " + rs1.getString("name") + ", Salary: " + rs1.getDouble("salary"));
            }

            // Simulate a second transaction inserting new data affecting the query
            try (Statement stmt2 = conn.createStatement()) {
                String insertQuery = "INSERT INTO employees (employee_id, name, salary) VALUES (102, 'John Doe', 60000)";
                stmt2.executeUpdate(insertQuery);
                System.out.println("Transaction 2 - Inserted a new employee.");
            }

            // Transaction 1: Re-read employees with salary > 50000 (Phantom Read)
            ResultSet rs2 = stmt.executeQuery(selectQuery);

            System.out.println("Transaction 1 - Re-read after Insert (Phantom Read):");
            while (rs2.next()) {
                System.out.println("Employee ID: " + rs2.getInt("employee_id") + ", Name: " + rs2.getString("name") + ", Salary: " + rs2.getDouble("salary"));
            }
        }

        // Commit transaction to finalize changes
        conn.commit();
    }
}


package com.neoteric.dec_dbconnection.jpa_db;

import static com.neoteric.dec_dbconnection.jpa_db.DatasetProjectService.insertEmployee;

public class DataInsertionTest {
    public static void main(String[] args) {

        EmployeeEntity sahasra = new EmployeeEntity();
        sahasra.setName("sahasra");
        sahasra.setDepartment("NON-IT");
        sahasra.setSalary(75000);

        insertEmployee(sahasra);

        System.out.println("Employee inserted successfully!");
    }
}



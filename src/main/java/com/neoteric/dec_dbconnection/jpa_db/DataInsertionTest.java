package com.neoteric.dec_dbconnection.jpa_db;

public class DataInsertionTest {
    public static void main(String[] args) {
        DatasetProjectService service =  new DatasetProjectService();

        service.insertEmployee(" Ravi", "IT", 60000);
        service.insertEmployee("Sunil", "HR", 50000);
        service.insertEmployee("Ganesh", "Finance", 70000);
    }
}

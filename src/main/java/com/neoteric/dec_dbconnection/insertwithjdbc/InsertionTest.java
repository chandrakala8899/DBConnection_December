package com.neoteric.dec_dbconnection.insertwithjdbc;

import com.neoteric.dec_dbconnection.dbconnection.Employee;
import com.neoteric.dec_dbconnection.dbconnection.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertionTest {
    public static void main(String[] args) {
List<Project> projectList = new ArrayList<>();

      Project avvota = new Project();
      avvota.setPname("avvota");
      avvota.setStartdate(new Date());
       avvota.setEnddate(new Date());


        Project plumSoft = new Project();
        plumSoft.setPname("plumSoft");
        plumSoft.setStartdate(new Date());
        plumSoft.setEnddate(new Date());

        projectList.add(avvota);
        projectList.add(plumSoft);

        Employee chandu = new Employee();
        chandu.setName("chandu");
        chandu.setDept("IT");
        chandu.setSalary(30000);

        avvota.getEmployeeList().add(chandu);

        Employee tiru = new Employee();
        tiru.setName("tiru");
        tiru.setDept("IT");
        tiru.setSalary(40000);

        avvota.getEmployeeList().add(tiru);

        Employee mahi = new Employee();
        mahi.setName("mahi");
        mahi.setDept("IT");
        mahi.setSalary(20000);

        avvota.getEmployeeList().add(mahi);

        Employee kk = new Employee();
        kk.setName("KK");
        kk.setDept("CSE");
        kk.setSalary(50000);

        plumSoft.getEmployeeList().add(kk);

        Employee Naveen = new Employee();
        Naveen.setName("Naveen");
        Naveen.setDept("CSE");
        Naveen.setSalary(25000);

        plumSoft.getEmployeeList().add(Naveen);

        Employee susheel = new Employee();
        susheel.setName("susheel");
        susheel.setDept("CSE");
        susheel.setSalary(45000);

        plumSoft.getEmployeeList().add(susheel);



        JDBCParentChildInsert jdbcParentChildInsert = new JDBCParentChildInsert();
        //jdbcParentChildInsert.saveProjectEmployee(projectList);


      List<Employee> employees =  jdbcParentChildInsert.getEmployeesAllocation(20000,"IT");
     for(Employee emp : employees){
      System.out.println("  Employee Name: " + emp.getName() + "  " + emp.getDept()+ "   " + emp.getSalary());
     }

    }
}

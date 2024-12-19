package com.neoteric.dec_dbconnection.jpaonetomany;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OneToManyTest {
    public static void main(String[] args) {
List<Project> projectList = new ArrayList<>();
      Project avvota = new Project();
        avvota.setName("avvota");
        avvota.setStartDate(new Date());
        avvota.setEndDate(new Date());


        Project plumSoft = new Project();
        plumSoft.setName("plumSoft");
        plumSoft.setStartDate(new Date());
        plumSoft.setEndDate(new Date());

        projectList.add(avvota);
        projectList.add(plumSoft);


        AadharDetails chanduAadhar = new AadharDetails();
        chanduAadhar.setAadharNumber("7766");
        chanduAadhar.setIssueDate(new Date());

        AadharDetails tiruAadhar = new AadharDetails();
        tiruAadhar.setAadharNumber("3284");
        tiruAadhar.setIssueDate(new Date());

        AadharDetails mahiAadhar= new AadharDetails();
        mahiAadhar.setAadharNumber("5069");
        mahiAadhar.setIssueDate(new Date());


        AadharDetails kkAadhar= new AadharDetails();
        kkAadhar.setAadharNumber("2244");
        kkAadhar.setIssueDate(new Date());

        AadharDetails naveenAadhar= new AadharDetails();
        naveenAadhar.setAadharNumber("5566");
        naveenAadhar.setIssueDate(new Date());

        AadharDetails susheelAadhar= new AadharDetails();
        susheelAadhar.setAadharNumber("7788");
        susheelAadhar.setIssueDate(new Date());


        Employee chandu = new Employee();
        chandu.setName("chandu");
        chandu.setDept("IT");
        chandu.setSalary(30000);
        chandu.setAadharDetails(chanduAadhar);

        avvota.getEmployeeList().add(chandu);

        Employee tiru = new Employee();
        tiru.setName("tiru");
        tiru.setDept("IT");
        tiru.setSalary(40000);
        tiru.setAadharDetails(tiruAadhar);

        avvota.getEmployeeList().add(tiru);

        Employee mahi = new Employee();
        mahi.setName("mahi");
        mahi.setDept("IT");
        mahi.setSalary(20000);
        mahi.setAadharDetails(mahiAadhar);

        avvota.getEmployeeList().add(mahi);

        Employee kk = new Employee();
        kk.setName("KK");
        kk.setDept("CSE");
        kk.setSalary(50000);
        kk.setAadharDetails(kkAadhar);

        plumSoft.getEmployeeList().add(kk);

        Employee naveen = new Employee();
        naveen.setName("Naveen");
        naveen.setDept("CSE");
        naveen.setSalary(25000);
        naveen.setAadharDetails(naveenAadhar);

        plumSoft.getEmployeeList().add(naveen);

       Employee susheel = new Employee();
        susheel.setName("susheel");
        susheel.setDept("CSE");
        susheel.setSalary(45000);
        susheel.setAadharDetails(susheelAadhar);

        plumSoft.getEmployeeList().add(susheel);

        EmployeeService service = new EmployeeService();
       for(int i=0;i<projectList.size();i++){
          service.savejpa(projectList.get(i));
       }
    }
}

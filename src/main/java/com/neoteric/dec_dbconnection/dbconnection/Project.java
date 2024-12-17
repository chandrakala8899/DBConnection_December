package com.neoteric.dec_dbconnection.dbconnection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {

    private  int id;
    private  String pname;
    private Date startdate;
    private Date enddate;



    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    private List<Employee> employeeList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getPname() {
        return pname;


    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", employeeList=" + employeeList +
                '}';
    }
}

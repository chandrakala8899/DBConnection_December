package com.neoteric.dec_dbconnection.jpa_db;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project", schema = "sonar")
public class ProjectEntity {
    public  ProjectEntity(){

    }
    @Id
    @Column(name = "id")
    private  int id;


    @OneToMany(mappedBy = "projectEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<EmployeeEntity> employeeEntityList;

    @OneToMany(mappedBy = "projectEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<EmployeeEntity> employees;

    @Column(name = "pname")
    private  String name;
    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private  Date endDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<EmployeeEntity> getEmployeeEntityList() {
        return employeeEntityList;
    }

    public void setEmployeeEntityList(List<EmployeeEntity> employeeEntityList) {
        this.employeeEntityList = employeeEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}



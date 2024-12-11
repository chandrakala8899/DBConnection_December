package com.neoteric.dec_dbconnection.jpaconnection;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Employee", schema = "sonar")
@Data
public class Employee{

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dept", nullable = false)
    private String dept;

    @Column(name = "salary", nullable = false)
    private double salary;

//    @Column(name = "pid", insertable = false, updatable = false)
//    private int pid;

    @ManyToOne
    @JoinColumn(name = "pid",referencedColumnName = "id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "mid", referencedColumnName = "id")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private List<Employee> employeeList;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", project=" + project +
                ", manager=" + manager +
                ", employeeList=" + employeeList +
                '}';
    }
}

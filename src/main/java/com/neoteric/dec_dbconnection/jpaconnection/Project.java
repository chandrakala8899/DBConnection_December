package com.neoteric.dec_dbconnection.jpaconnection;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project", schema = "sonar")
@Data
public class Project {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "pname")
    private String name;

    @OneToMany(mappedBy = "project")
    private List<Employee> employees;

     @Column(name = "startdate",nullable = false)
    private Date startDate;

    public Project() {

    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Column(name = "enddate",nullable = false)
    private Date endDate;
}
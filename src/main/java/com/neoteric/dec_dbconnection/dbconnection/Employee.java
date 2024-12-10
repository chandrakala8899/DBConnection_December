package com.neoteric.dec_dbconnection.dbconnection;

import java.util.ArrayList;
import java.util.List;

public class Employee {
        private int id;

        private int pid;
        private String name;
        private String dept;
 private  Employee manager;

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    private  double salary;

        private  int mid;
        private List<Employee> employeeList;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    // Constructor
        public Employee() {
            this.employeeList = new ArrayList<>();
        }


        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDept() {
            return dept;
        }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", mid=" + mid +
                ", employeeList=" + employeeList +
                '}';
    }

    public void setDept(String dept) {
            this.dept = dept;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;

    }
}



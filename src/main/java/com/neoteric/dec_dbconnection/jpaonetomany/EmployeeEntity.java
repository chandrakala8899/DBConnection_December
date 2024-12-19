package com.neoteric.dec_dbconnection.jpaonetomany;
import jakarta.persistence.*;
import lombok.Data;



    @Entity
    @Table(name = "employee_jpa",schema = "sonar")
    @Data
    public class EmployeeEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "dept")
        private String department;

        @Column(name = "salary")
        private double salary;


        @ManyToOne
        @JoinColumn(name = "pid",referencedColumnName = "id", nullable = false)
        private ProjectEntity project;

        public AadharEntity getAadharDetails() {
            return aadharDetails;
        }

        public void setAadharDetails(AadharEntity aadharDetails) {
            this.aadharDetails = aadharDetails;
        }

        @OneToOne(cascade = CascadeType.ALL)
        private AadharEntity aadharDetails;

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public ProjectEntity getProject() {
            return project;
        }

        public void setProject(ProjectEntity project) {
            this.project = project;
        }

        @Column(name = "pid",insertable = false,updatable = false)
        private int pid ;

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        // toString method for debugging
        @Override
        public String toString() {
            return "EmployeeEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    ", project=" + project +
                    '}';
        }
    }
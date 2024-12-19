package com.neoteric.dec_dbconnection.springbeanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private final DependencyBean dependencyBean;
    private String additionalProperty;

    // Constructor Injection
    public MyBean(DependencyBean dependencyBean) {
        this.dependencyBean = dependencyBean;
        System.out.println("1. Constructor: Bean is instantiated with DependencyBean.");
    }

    // Setter Injection
    public void setAdditionalProperty(String additionalProperty) {
        this.additionalProperty = additionalProperty;
        System.out.println("Setter: additionalProperty is set to " + additionalProperty);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("2. @PostConstruct: Initialization logic.");
    }

    public void customInit() {
        System.out.println("3. customInit(): Custom initialization logic.");
    }

    public void performTask() {
        System.out.println("4. Bean is in use: Performing tasks with DependencyBean.");
        dependencyBean.execute();
        System.out.println("Using additional property: " + additionalProperty);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("5. @PreDestroy: Pre-destroy logic.");
    }

    public void customDestroy() {
        System.out.println("6. customDestroy(): Custom destroy logic.");
    }

}

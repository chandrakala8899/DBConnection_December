package com.neoteric.dec_dbconnection.springbeanlifecycle;

import org.springframework.stereotype.Component;

@Component
public class DependencyBean {
    public void execute() {
        System.out.println("DependencyBean: Executing a dependent task.");
    }
}

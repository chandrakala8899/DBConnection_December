package com.neoteric.dec_dbconnection.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    PayService payService;

    public EmployeeService(){
        System.out.println(" from constructor  ===== ");
    }

    public void project(){
        System.out.println(" from project assignment");

        payService.pay();
    }
}

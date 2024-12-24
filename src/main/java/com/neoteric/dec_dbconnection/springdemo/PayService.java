package com.neoteric.dec_dbconnection.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PayService {

    ExternalEmployeeService externalJavaService;

    public PayService(@Autowired ExternalEmployeeService externalJavaService){
        this.externalJavaService= externalJavaService;
    }




    public void pay(){
        System.out.println(" from pay");
        externalJavaService.external();
    }


}

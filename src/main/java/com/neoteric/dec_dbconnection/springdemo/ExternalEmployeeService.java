package com.neoteric.dec_dbconnection.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ExternalEmployeeService {
    private final PayService payService;

    @Autowired
    public ExternalEmployeeService(PayService payService) {
        this.payService = payService;
        System.out.println("External Employee Service Initialized");
        payService.payService();
    }

    @Autowired
    @Qualifier("oracleConnectionService")
    private ConnectionService connectionService;

    public void performDatabaseOperation() {
        connectionService.connect("myDatabase", "user", "password");
    }

}

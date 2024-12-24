package com.neoteric.dec_dbconnection.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ExternalEmployeeService {
    @Qualifier("oracleConnectionService")
    @Autowired
    ConnectionService connectionService;

    public void external() {
        System.out.println(" external ");
        connectionService.connect("abc", "abc", "abc");
    }
}
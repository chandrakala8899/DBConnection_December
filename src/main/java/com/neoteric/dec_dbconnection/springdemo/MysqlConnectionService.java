package com.neoteric.dec_dbconnection.springdemo;

import org.springframework.beans.factory.annotation.Autowired;


public class MysqlConnectionService implements ConnectionService{


    public void connect(String dbName, String username, String password) {
        System.out.println("Connecting to MySQL database: " + dbName);
    }
    private TCPConnection tcpConnection;

    public MysqlConnectionService(@Autowired TCPConnection tcpConnection){
       this.tcpConnection=tcpConnection;
    }

}

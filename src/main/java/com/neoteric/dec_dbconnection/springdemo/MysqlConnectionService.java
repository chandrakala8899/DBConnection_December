package com.neoteric.dec_dbconnection.springdemo;

import org.springframework.beans.factory.annotation.Autowired;


public class MysqlConnectionService implements ConnectionService{


    private TCPConnection tcpConnectionService ;
    public MysqlConnectionService(TCPConnection tcpConnectionService){

        System.out.println("  from mysql constructor ");

        this.tcpConnectionService = tcpConnectionService;
    }


    @Override
    public NeoConnection connect(String dbName, String username, String password) {
        NeoConnection  conn= new NeoConnection("MysqlConnection");

        System.out.println(" getConnnection from mysql  ");
        tcpConnectionService.connect();
        return conn;
    }
}

package com.neoteric.dec_dbconnection.springdemo;

public class OracleConnectionService implements ConnectionService{


    private TCPConnection tcpConnectionService ;
    public OracleConnectionService(TCPConnection tcpConnectionService){

        System.out.println("  from oracle constructor ");

        this.tcpConnectionService = tcpConnectionService;
    }

    @Override
    public NeoConnection connect(String dbName, String username, String password) {
        NeoConnection  conn= new NeoConnection("MysqlConnection");

        System.out.println(" getConnnection from oracle  ");
        tcpConnectionService.connect();
        return conn;
    }
}


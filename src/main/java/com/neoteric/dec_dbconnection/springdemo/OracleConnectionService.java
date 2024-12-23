package com.neoteric.dec_dbconnection.springdemo;

public class OracleConnectionService implements ConnectionService{
    @Override
    public void connect(String dbName, String username, String password) {
        System.out.println("Connecting to Oracle database: " + dbName);
    }

    private TCPConnection tcpConnection;

    public  OracleConnectionService(TCPConnection tcpConnection){
        System.out.println("Tcp");
    }
}

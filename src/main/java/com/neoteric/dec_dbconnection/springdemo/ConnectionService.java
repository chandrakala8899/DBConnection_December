package com.neoteric.dec_dbconnection.springdemo;


public interface ConnectionService {
     NeoConnection connect(String dbName, String username, String password);

}

package com.neoteric.dec_dbconnection.springdemo;

import java.sql.Connection;

public interface ConnectionService {
     void connect(String dbName, String username, String password);

}

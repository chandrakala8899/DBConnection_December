package com.neoteric.dec_dbconnection.jpa_db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

    public class ConnectionPool{


        private static HikariDataSource hikariDataSource;

        static {

            HikariConfig hikariConfig= new HikariConfig();
            hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3307/sonar");
            hikariConfig.setUsername("root");
            hikariConfig.setPassword("sonar");
            hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");

            hikariConfig.setMaximumPoolSize(100);
            hikariConfig.setMinimumIdle(5);
            hikariConfig.setIdleTimeout(30000);
            hikariConfig.setMaxLifetime(1800000);

            hikariDataSource = new HikariDataSource(hikariConfig);


        }
        public static Connection getConnection()throws SQLException{
            return hikariDataSource.getConnection();
        }

        public static void main(String[] args) {
            try (Connection connection =getConnection()){
                System.out.println("connection established" + connection);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


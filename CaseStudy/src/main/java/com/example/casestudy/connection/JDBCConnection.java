package com.example.casestudy.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static final String  DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONN_URL = "jdbc:mysql://localhost:3306/personnel";
    private static final String USERNAME = "root";
    private static final String PASSWRORD ="123456";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONN_URL,USERNAME,PASSWRORD);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find driver for jdbc connection!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not find database!");
            e.printStackTrace();
        }
        return null;
    }
}

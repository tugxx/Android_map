 package com.example.myapplication.model;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 public class DBConnector {
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    IPConfigModel ipConfigModel = new IPConfigModel();
    private final String DATABASE_URL = "jdbc:mysql://"+ipConfigModel.getIpconfig()+":3306/PHP_API";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234567890";
    //init connection object
    private Connection connection = null;


    public DBConnector(){
    if (connection == null) {
        try {
           Class.forName(DATABASE_DRIVER).newInstance();
            connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
    // connect database
    public Connection getCon() {
        return connection;
    }
    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.Accio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection connection=null;
    public static Connection getConnection(){
        if(connection!=null){
            return connection;
        }
        String user="root";
        String pwd="Simanshu@123";
        String db="searchengine";
        return getConnection(user, pwd, db);
    }

    private static Connection getConnection(String user,String pwd,String db){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost/searchengine","root","Simanshu@123");
        }
        catch (SQLException | ClassNotFoundException sqlException){
            sqlException.printStackTrace();
        }
        return connection;
    }

}


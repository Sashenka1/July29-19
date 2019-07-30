package com.orangehrm0001.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {
	String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
    String dbUsername="Syntax";
    String dbPassword="syntax123";
    
    @Test
    public void dbConnection() throws SQLException {
    	//creating connection
    	Connection connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    	//create a statement 
    	Statement statement=connection.createStatement();
    	//execute Query and store results from database in resultSet object
    	ResultSet resultSet=statement.executeQuery("Select * from Countries");
    	//get values from resultSet
    	resultSet.next();
    	
    	String columDate=resultSet.getString("Country_Name");
    	System.out.println(columDate);
    	
    	while(resultSet.next()) {
    		columDate=resultSet.getString("Country_Name");
    		System.out.println(columDate);
    				
    	}
    	//close all db connection
    	resultSet.close();
    	statement.close();
    	connection.close();
    	
    }
     
}

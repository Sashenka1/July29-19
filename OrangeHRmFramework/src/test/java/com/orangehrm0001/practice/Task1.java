package com.orangehrm0001.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Task1 {
	//display dep id and dep name
	
	String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
    String dbUsername="Syntax";
    String dbPassword="syntax123";
    
    @Test
    public void printRowData() throws SQLException {
    	//creating connection
    	Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    	//create a statement 
    	Statement statement=conn.createStatement();
    	//execute Query and store results from database in resultSet object
    	ResultSet res=statement.executeQuery("Select DEPARTMENT_ID, DEPARTMENT_NAME from Departments");
    	//get values from resultSet
    while(res.next()) {
    	int dep_id=res.getInt("DEPARTMENT_ID");
    	String dep_name=res.getString("DEPARTMENT_NAME");
    	System.out.println(dep_id + "" + dep_name);
    }
	
  //close all db connection
	res.close();
	statement.close();
	conn.close();
}}

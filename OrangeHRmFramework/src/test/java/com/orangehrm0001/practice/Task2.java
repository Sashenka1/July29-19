package com.orangehrm0001.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Task2 {
	String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
    String dbUsername="Syntax";
    String dbPassword="syntax123";
    
    @Test
    public void printRowData() throws SQLException {
    	
      Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    
    	//print database name
    	DatabaseMetaData dbMetaData=conn.getMetaData();
    	String dbName=dbMetaData.getDatabaseProductName();
    	System.out.println(dbName);
    	//print datadace version
    	String dbVersion=dbMetaData.getDatabaseProductVersion();
    	System.out.println(dbVersion);
    	//____________________________________________________________
    	Statement st=conn.createStatement();
    	
    	ResultSet rs=st.executeQuery("SELECT * FROM EMPLOYEES WHERE JOB_ID='IT_PROG'");
    	ResultSetMetaData rsMetaData = rs.getMetaData();
    	//get total # of cols
    	int colNum=rsMetaData.getColumnCount();
    	System.out.println(colNum);
    	
    	//get name of spec col
    	String colName=rsMetaData.getColumnName(2);
    	System.out.println(colName);
    	//print all col names
    	for ( int i=1; i<colNum; i++) {
    		colName=rsMetaData.getCatalogName(i);
    		System.out.println(colName);
    		}
    	rs.close();
    	st.close();
    	conn.close();
    }}
    	
    	
    	
    	
   



package com.orangehrm0001.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SqlTask3 {
	
	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	String dbUsername = "Syntax";
	String dbPassword = "syntax123";
	////process query that will give result of street address, city and country name
	//and store results inside the list

	@Test
	public void getResultSetData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT STREET_ADDRESS, CITY, COUNTRY_NAME FROM LOCATIONS L JOIN COUNTRIES C ON L.COUNTRY_ID=C.COUNTRY_ID");
        
		List<Map<String, String>> rsList = new ArrayList<>();

		while (rs.next()) {
			Map<String, String> rsMap = new HashMap<>();
			rsMap.put("STREET_ADDRESS", rs.getString("STREET_ADDRESS"));
			rsMap.put("CITY", rs.getString("CITY"));
			rsMap.put("COUNTRY_NAME", rs.getString("COUNTRY_NAME"));
			
			rsList.add(rsMap);
		}

		System.out.println(rsList);

		rs.close();
		st.close(); 
		conn.close();
	}
	
	
	//@Test
	public void review() {
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("first_name", "Alexander");
		map.put("first_name", "Bruce");
		map.put("first_name", "David");
		
		System.out.println(map.size());
		System.out.println(map);
	}
}



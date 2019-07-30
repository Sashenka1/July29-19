package com.orangehrm0001.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JasonPathTest {
	
	public void test() {
		
		  RestAssured.baseURI="http://pure-ravine-92491.herokuapp.com/syntax";
		        Response resp1=given().pathParam("studentId",123).
		        when().get("/api/getStudentProfile/{studentId}");
		        resp1.prettyPrint();
		        resp1.then().assertThat().statusCode(200).
		        and().body("firstName", equalTo("Vladimir"));
		        
		        JsonPath jPath=resp1.jsonPath();
		        
		        String firstName=jPath.get("firstName");
		        System.out.println(firstName);
		        
		        String lastName=jPath.get("lastName");
		        System.out.println(lastName);
		        
	}

}

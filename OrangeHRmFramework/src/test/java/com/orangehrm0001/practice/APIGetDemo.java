package com.orangehrm0001.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.*;

public class APIGetDemo {
	@Test
	public void getWeather() {
		Response response=RestAssured.when().get("http://restapi.demoqa.com/utilities/weather/city/Fairfax");
	    response.prettyPrint();
	    int code=response.getStatusCode();
	    System.out.println(code);
	}
	
	@Test
	public void getCountry() {
		Response res=RestAssured.when().get("http://restcountries.eu/rest/v1/name/Russia");
		//res.prettyPrint();
		int code1=res.getStatusCode();
		Assert.assertEquals(200, code1);
		//retr. body string
		String body=res.asString();
		System.out.println(body);
		Assert.assertTrue(body.contains("Moscow"));
		
		//retr. body header date as String
		String header=res.getHeader("Date");
		System.out.println(header);
		
	}
	

}

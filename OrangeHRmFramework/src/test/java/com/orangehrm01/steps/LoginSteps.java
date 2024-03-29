package com.orangehrm01.steps;




import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends CommonMethods {
	
	LoginPage login;
	
	//@Given("I navigated to OrangeHrm")
	//public void i_navigated_to_OrangeHrm(){ 
	 //setUp();}
	
        @Given("I see OrangeHrm logo")
		public void I_see_OrangeHrm_logo() {
		login=new LoginPage();
		boolean isDisplayed=login.logo.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
	   sendText(login.userName,"Admin");
	   sendText(login.password, "Syntax123!");
	   
	}
	@When("I click login button")
	public void I_click_login_button() {
	   click(login.logInBtn);
	}

	 @Then("I successfully logged in")
		public void I_successfully_logged_in() {
	   HomePage home=new HomePage();
	   Assert.assertTrue(home.dashboardText.isDisplayed());
	}
	 
	@Then("I will close browser")
	public void i_will_close_browser() { 
	tearDown();}
	
	@When("I enter invalid username and password")
	public void i_enter_invalid_username_and_password() {
	    sendText(login.userName, "Test");
	    sendText(login.password, "Test123");
	}

	@Then("I see error message is displayed")
	public void i_see_error_message_is_displayed() {
	    Assert.assertTrue(login.message.isDisplayed());
	    String errorText=login.message.getText().trim();
	    Assert.assertEquals("Invalid Credentials", errorText);
	}
	
	
	@When("I enter invalid username and password I see errorMessage")
	public void i_enter_invalid_username_and_password_I_see_errorMessage(DataTable wrongCredentials) {
	   List<Map<String, String>> maps=wrongCredentials.asMaps();
	   //printing values of each key
	   for(Map<String, String> map:maps) {
		   System.out.println(map.get("UserName"));
		   System.out.println(map.get("Password"));
		   System.out.println(map.get("ErrorMessage"));
		   System.out.println("___________________________________");
		   //passing username and password values from database
		   sendText(login.userName, map.get("UserName"));
		   sendText(login.password, map.get("Password"));
		   click(login.logInBtn);
		   //verifying text of error message
		   String actualError=login.message.getText().trim();
		   String expectedError=map.get("ErrorMassage");
		   Assert.assertEquals(expectedError, actualError);
		   
	   }
	 


}}

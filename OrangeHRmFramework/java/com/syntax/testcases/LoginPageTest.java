package com.syntax.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.LoginPageWithoutPageFactory;
import com.orangeHRM.utils.BaseClass;
import com.orangeHRM.utils.CommonMethods;
import com.orangeHRM.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{

	@Test(groups="smoke")
	public void loginToOrangeHRM() throws Throwable {
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "@uAZlj92QF");
		//Thread.sleep(2000);
		CommonMethods.click(login.btnLogin);
		//Thread.sleep(2000);
		
		
	}
	@Test(groups="smoke")
	public void doLogIn() {
		LoginPage login=new LoginPage();
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.logInBtn);
		
		HomePage home =new HomePage();
		boolean isDisplayed = home.dashboardText.isDisplayed();
		Assert.assertTrue(false);}
	
	@Test(groups="resression")
	public void negativeLogin() {
		LoginPage login=new LoginPage();
		
	    login.login("admins", "test");

        String errorText=((WebElement) login.message).getText();
        AssertJUnit.assertEquals(errorText, "Invalid Credentials");
		
		
		   
		
	}}


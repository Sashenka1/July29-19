package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.utils.BaseClass;
import com.orangeHRM.utils.CommonMethods;

public class LoginPage extends BaseClass{

//	public WebElement username=driver.findElement(By.id("txtUsername"));
//	public WebElement password=driver.findElement(By.id("txtPassword"));
//	public WebElement btnLogin=driver.findElement(By.id("btnLogin"));
	
	//locating WE using @FindBy
	@FindBy(id="txtUsername")
	public WebElement userName;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement logInBtn;
	
	@FindBy(css="img[src*='logo.png']")
	public WebElement logo;

	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement message;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
	}
	public void login(String uname, String pwd) {
		CommonMethods.sendText(userName, uname);
	    CommonMethods.sendText(password, pwd);
		CommonMethods.click(logInBtn);
	
	
		
	
	
		
	}
	
		
	}
	



package com.orangehrm01.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.orangeHRM.utils.BaseClass;
import com.orangeHRM.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps extends BaseClass{
	WebDriver driver;
	String url ="https://www.google.com/";
	
	@Given("I navigated to the Google")
	public void i_navigated_to_the_Google() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get(url);
		System.out.println("I'm on google page");
		throw new cucumber.api.PendingException();}

	@When("I type search item")
	public void i_type_search_item() {
	    // Write code here that turns the phrase above into concrete actions
		sendText(driver.findElement(By.xpath("//input[@name='q']")),"Leningrad");
	    System.out.println("I search for items");
		throw new cucumber.api.PendingException();
	}

	private void sendText(WebElement findElement, String string) {
		// TODO Auto-generated method stub
		}

	@When("I click on google search button")
	public void i_click_on_google_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.FPdoLc.VlcLAe > center > input.gNO89b")).click();
		System.out.println("Clicked search button");
	    throw new cucumber.api.PendingException();
	}

	@Then("I see search results are displayed")
	public void i_see_search_results_are_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement present=driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div/div[1]/input"));
	  Assert.assertTrue(present.isDisplayed());
		System.out.println("results are displayed");
	    throw new cucumber.api.PendingException();
	}
	@Then("I close browser")
	public void i_close_browser() {
		driver.quit();
	}}


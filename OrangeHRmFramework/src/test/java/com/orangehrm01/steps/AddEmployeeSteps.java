package com.orangehrm01.steps;


	
import java.util.ArrayList;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangeHRM.pages.AddEmployeePage;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.utils.CommonMethods;
import com.orangeHRM.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

class AddEmployeeSteps extends CommonMethods {

    LoginPage login;
    HomePage home;
    AddEmployeePage emp;

	@Given("I logged in into OrangeHrm")

		public void i_logged_in_into_OrangeHrm() {
        login = new LoginPage();
        home = new HomePage();
        emp = new AddEmployeePage();
       login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		}
        @When("I click on PIM link")
        public void i_click_on_PIM_link() {
        click(home.PIM);}

		@When("I click on  Add Employee link")
        public void i_click_on_Add_Employee_link() {
        click(home.addEmployee);

		}
        //Add Employee 
		
		@When("I provide {string}, {string}, {string} and {string}")
        public void i_provide_and(String fName, String mName, String lName, String location) {
        sendText(emp.firstName, fName);
        sendText(emp.middleName, mName);
        sendText(emp.lastName, lName);
        click(emp.location);
        selectList(emp.locationList, location);

		}

        @When("I click on save button")
        public void i_click_on_save_button() {
        click(emp.saveBtn);
         }
        
        @Then("I see {string}, {string} is displayed")
        public void i_see_is_displayed(String fName, String lName) {
        waitForElementBeClickable(emp.empCheck, 20);
        String empName=emp.empCheck.getText();
        Assert.assertEquals(fName+" "+lName, empName);}
		

  @When("I provide firstname, midlename, lastname and location")
  public void i_provide_firstname_midlename_lastname_and_location() {
   sendText(emp.firstName, "John");
   sendText(emp.middleName, "H");
   sendText(emp.lastName, "Klone");
   click(emp.location);
   selectList(emp.locationList, "HQ");
}

  @When("I click on create login details")
  public void i_click_on_create_login_details() {
    click(emp.createLoginDetails);
}

  @When("I provide all mandatory fields")
  public void i_provide_all_mandatory_fields() {
	sendText(login.userName,"Admin123");
	sendText(login.password, "A2345");
   
}

 @Then("I see employee is added successful")
 public void i_see_employee_is_added_successful() {
	
	
}
	@Then("I see following labels")
	public void i_see_following_labels(DataTable addEmpLabels) {
		
    List<String>expectedLabels =addEmpLabels.asList();
    System.out.println("Printing label list");
    for( String label :expectedLabels) {
    	System.out.println(label);
    }
    //creat an empty arraylist  where we store label text
    List<String>actualLabels=new ArrayList<String>();
    
    //get all label element
    List<WebElement> labelList=emp.addEmpLabels;
    for(WebElement label: labelList) {
    	String labeltxt=label.getText();
    	//if text is not empty replace * and store it inside actual Labels
    	if(!labeltxt.isEmpty()) {
    		actualLabels.add(labeltxt.replace("*", ""));
    	}}
    Assert.assertTrue(actualLabels.equals(expectedLabels));
	}
	
	@When("I provide Employee details from {String}")
	public void i_provide_Employee_details(String sheetName) {
		//come from exel
		//fis
		//worksheet(sheetName)
		//# rows
		//#cols
		//sendText(emp.firstName, "John");
		  // sendText(emp.middleName, "H");
		   //sendText(emp.lastName, "Klone");
		   //click(emp.location);
		   //selectList(emp.locationList, "HQ");
		
		
		
	}



}



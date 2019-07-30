#Author: Alexandra K.    

Feature: Add Employee

Background: 

Given I logged in into OrangeHrm
And I click on PIM link
And I click on  Add Employee link
    
    
@smoke @addEmployee

Scenario Outline: Add Employee

When I upload 
When I provide "<FirstName>", "<MiddleName>", "<LastName>" and "<Location>"
And I click on save button
Then I see "<FirstName>", "<LastName>" is displayed

Examples: 

|FirstName|MiddleName|LastName|Location    |
| Jane	  |S	       |Smith   |Smart Office|
|James    |S         |West    | Tech Office|
|Jackie   |N         |Eats    | HQ         | 


  
  @smoke2  
Scenario: Add Employee and Create Login Details

When I provide firstname, midlename, lastname and location
And I click on create login details
And I provide all mandatory fields
And I click on save button
And I provide Employee details
Then I see employee is added successful

@smoke1
Scenario: Add Employee Labels Verification
Then I see following labels
|First Name|
|Middle Name|
|Last Name |
|Employee ID|
|Location  |





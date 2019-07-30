#Author: Alexandra K.
@sprint3
Feature: Login

Background:
Given I see OrangeHrm logo

@smoke @login
Scenario: Valid login

When I enter valid username and password
And I click login button
Then I successfully logged in 


@regression @test
Scenario: Invalid login

When I enter invalid username and password
And I click login button
Then I see error message is displayed
@smoke
Scenario: Error message
When I enter invalid username and password I see errorMessage
| UseName |Password  | ErrorMessage       |
|  Admin  |Admin123  | Invalid Credentials|
|  Admin1 |Syntax123!| errorMessage       |
| Admin2  |Syntax    | Invalid Credentials|




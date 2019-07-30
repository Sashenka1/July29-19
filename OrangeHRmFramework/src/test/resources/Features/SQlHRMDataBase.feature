#Author: A.K.

 Feature: Job title
 Validation for job tittle functionality
 
Background:
Given I logged into OrangeHrm
And I click on Admin Link
And I click on Job Link
When I click on Job Titles 

Scenario Outline: Add Job

Scenario Outline: Job title Validation
When I get all Job Titles from UI
When I execute "<SqlQuery>"
And I see results from UI and Database are matched

Examples:
|Query							                   |
| SELECT JOB_TITLE FROM JOBS ORDER BY 1|



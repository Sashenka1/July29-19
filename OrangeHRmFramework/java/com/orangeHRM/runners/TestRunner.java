package com.orangeHRM.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
                 glue="com/orangehrm01/steps",
                 monochrome=true,
                 tags= {"@smoke"},
                 plugin= {"pretty","html:target/cucumber-default-reports")


public class TestRunner {

}

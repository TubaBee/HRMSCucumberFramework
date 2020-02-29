package com.hrms.APIRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/featuresAPI", 
		glue = {"com/hrms/API/steps/practice" }, 
		dryRun = false, 
		tags = "@APIAll"

)

public class getAllEmployeeRunner {

}

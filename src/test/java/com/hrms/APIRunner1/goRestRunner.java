package com.hrms.APIRunner1;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featuresAPI", 
		glue = {"com.hrms.API.step.practice1" }, 
		dryRun = false, 
		tags = "@GoRest"

)

public class goRestRunner {

}

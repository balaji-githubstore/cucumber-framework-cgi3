package com.cgi.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = { "src/test/resources/Feature" }
		, glue = {"com.cgi.steps","com.cgi.base" }
		, monochrome = true
		, publish = false
		, plugin = {"html:target/cucumber-report.html","rerun:target/rerun.txt"}
		//, plugin = {"html:target/cucumber-report.html","progress","json:target/cucumber-report.json"}
		//, tags = "not (@valid or @invalid)"
		, tags="@login"
	    //, dryRun = true
				
		)

public class RunnerTest extends AbstractTestNGCucumberTests {

}

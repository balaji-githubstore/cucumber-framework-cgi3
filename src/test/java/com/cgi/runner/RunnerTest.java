package com.cgi.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = { "src/test/resources/Feature" }
		, glue = {"com.cgi.steps","com.cgi.base" }
		, monochrome = true
		, publish = false
		, plugin = {"html:target/cucumber-report.html","rerun:target/rerun.txt"}
		//, plugin = {"html:target/cucumber-report.html","progress","json:target/cucumber-report.json"}
		//, tags = "not (@valid or @invalid)"
		, tags="@invalid"
	    //, dryRun = true
				
		)

@RunWith(Cucumber.class)
public class RunnerTest {

}

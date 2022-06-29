package com.cgi.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = { "src/test/resources/Feature/Login.feature" }
		, glue = {"com.cgi.steps","com.cgi.base" }
		, monochrome = true
		, publish = false
		, plugin = {"html:target/cucumber-report.html"}
		)

@RunWith(Cucumber.class)
public class RunnerTest {

}

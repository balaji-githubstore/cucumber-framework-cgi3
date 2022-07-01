package com.cgi.steps;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;

public class Demo {

	@Given("I fill the data")
	public void i_fill_the_data(io.cucumber.datatable.DataTable dataTable) {
	   
		List<Map<String, String>> ls=dataTable.asMaps();
		
		Map<String, String> row1=ls.get(0);
		System.out.println(row1);
		
		Map<String, String> row2=ls.get(1);
		System.out.println(row2);
		
		System.out.println(row2.get("contactname"));
		
		System.out.println(ls.get(1).get("contactname"));
		
		
	}
}

package com.RestAssured;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExtractingNode_Values_FromResponse{
	
	@Test
	public void getNodeDetails() {
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get("/Delhi");
 
	// First get the JsonPath object instance from the Response interface
	JsonPath jsonPath = response.jsonPath();
	String city = jsonPath.get("City");
 
	System.out.println("City received from Response " + city);
	
	System.out.println("Humidity received from Response-> " + jsonPath.get("Humidity"));
	 
	System.out.println("Weather received from Response-> " + jsonPath.get("Weather"));
	 
	System.out.println("WindSpeed received from Response-> " + jsonPath.get("WindSpeed"));
	 
	System.out.println("Temperature received from Response-> " + jsonPath.get("Temperature"));
	 
	System.out.println("Wind Direction Degree received from Response-> " + jsonPath.get("WindDirectionDegree"));
	 }
	
}

package com.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class Validate_Response_String {
 
	@Test
	public void GetDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 
		// Get the RequestSpecification of the request 
		RequestSpecification Sendrequest = RestAssured.given();
 
		Response response = Sendrequest.request(Method.GET, "/Delhi");
 		
		String responseBody = response.getBody().asString();
		 
		System.out.println("Response Body is =>  " + responseBody);
		
         boolean responseText = responseBody.toString().contains("Humidity");
		
		Assert.assertEquals(responseText, true, "Response does not have the expected text");
 
	}
	
	// Ignore casing while validating the Response String
	
	@Test
	public void GetDetails_IgnoreCase()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 
		// Get the RequestSpecification of the request 
		RequestSpecification Sendrequest = RestAssured.given();
 
		Response response = Sendrequest.request(Method.GET, "/Chennai");
 		
		String responseBody = response.getBody().asString();
		 
		System.out.println("Response Body is =>  " + responseBody);
		
        boolean responseText = responseBody.toLowerCase().toString().contains("humidity");
		
		Assert.assertEquals(responseText, true, "Response does not have the expected text");
 
	}
 
	
}

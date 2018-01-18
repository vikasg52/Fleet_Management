package com.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Data_Request{
@Test
public void RegistrationSuccessful()
{		
	RestAssured.baseURI ="http://restapi.demoqa.com/customer";
	RequestSpecification request = RestAssured.given();
 
	JSONObject requestParams = new JSONObject();
	requestParams.put("FirstName","Vikas");
	requestParams.put("LastName","Singh21");
	requestParams.put("UserName", "sdimpleuser2dd20111");
	requestParams.put("Password", "password11");
    requestParams.put("Email",  "sample2ee26d99@gmail.com");
	request.body(requestParams.toJSONString());
	
	request.header("Content-Type", "application/json");
	  
	Response response = request.post("/register");
 
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode,200);
	int successCode = response.getStatusCode();
	
	System.out.println(successCode);
	
	System.out.println("Response String:->"+response.getBody());
	
	Assert.assertEquals(successCode, "OPERATION_SUCCESS","Sahi code aaya");
}
}
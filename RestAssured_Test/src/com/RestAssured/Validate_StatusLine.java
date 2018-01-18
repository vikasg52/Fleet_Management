package com.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class Validate_StatusLine {
 
  @Test
	public void getDetails() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification Sendrequest = RestAssured.given();
		
        Response response = Sendrequest.request(Method.GET, "/Hyderabad");
        
        System.out.println("Response Code Returned is:=>"+response.getStatusCode());
	    
	    Assert.assertEquals(response.getStatusCode(), 200, "Correct Status code is not returned");
	    
	    System.out.println("Response Line Returned is:=>"+response.getStatusLine());
	    
	    Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Correct Sstatus Line is Not Returned");
		
	}
}

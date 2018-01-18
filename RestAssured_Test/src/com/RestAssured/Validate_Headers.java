package com.RestAssured;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class Validate_Headers {
 
  @Test
	public void getDetails() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification Sendrequest = RestAssured.given();
		
        Response response = Sendrequest.request(Method.GET, "/Hyderabad");
        
        System.out.println("Response Code Returned is:=>"+response.getStatusCode());
        
        // Validating the response code
	    
	    Assert.assertEquals(response.getStatusCode(), 200, "Correct Status code is not returned");
	    
	    System.out.println("Response Line Returned is:=>"+response.getStatusLine());
	    
	    // Validating Status line message
	    
	    Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Wrong status line returned");
	    
	    String Content_Type=response.getHeader("Content-Type");
	    
	    System.out.println("Content_Type is:+>"+Content_Type);
	    
	    //Validating Content Type
	    
	    Assert.assertEquals(Content_Type, "application/json", "Content type is not correct");
	    
	    String Server = response.getHeader("Server");
	    
	    // Validating the server
	    
	    Assert.assertEquals(Server, "nginx/1.12.2", "Server is wrong");
	    	    
	    
	    System.out.println("Server is:=>"+Server);
	    
	    String ContentEncoding = response.getHeader("Content-Encoding");
	    
	    System.out.println("Content encoding is:=>"+ContentEncoding);
	    
	    // Validating Content Encoding
	    
	    Assert.assertEquals(ContentEncoding, "gzip", "Content Encoding is wrong");
	    
		
	}
  
  @Test
  public void All_Headers() {
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification Sendrequest = RestAssured.given();
		
        Response response = Sendrequest.request(Method.GET, "/Hyderabad");
        
        System.out.println(response.headers()+"\n");
      
  }
}

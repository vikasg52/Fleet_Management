import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class Simple_Get_Request {
 
	@Test
	public void GetDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 
		// Get the RequestSpecification of the request 
		RequestSpecification Sendrequest = RestAssured.given();
 
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = Sendrequest.request(Method.GET, "/Hyderabad");
 
		// Now let us print the body of the message to see what response
		// we have recieved from the server, body and code
		String responseBody = response.getBody().asString();
		
	    int ResponseCode = response.getStatusCode();
	    
	    System.out.println("The Status Code is:=>" +ResponseCode);
	    
	    Assert.assertEquals(ResponseCode, 200,"Correct Code Returned");
	    
		System.out.println("Response Body is =>  " + responseBody);
 
	}
 
	@Test
	public void getDetails() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification Sendrequest = RestAssured.given();
		
        Response response1 = Sendrequest.request(Method.GET, "/Hyderab8d");
	    
	    Assert.assertEquals(response1.getStatusCode(), 200, "Correct Status code is not returned");
		
	}
}

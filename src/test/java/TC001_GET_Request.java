import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getUserDetails()
	{
		//specify base URI
		RestAssured.baseURI = "https://reqres.in";
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//ResponseObject
		Response response = httprequest.request(Method.GET, "/api/users?page=2");
		
		//Print response
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody is = " + responseBody);
		
		//status code validation
		int statusCode = response.getStatusCode();
		
		System.out.println("status code is = " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//status line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status line = " + statusLine);
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
	}

}

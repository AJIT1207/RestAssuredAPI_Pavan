import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MyFirstRestAPIGetHarmony {
	
	@Test
	void getUserDetails()
	{
		//specify base URI
		RestAssured.baseURI = "https://vtapreportintegrations.sc2-prd.tas.vmware.com";
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//ResponseObject
		Response response = httprequest.request(Method.GET, "/report/getLiveQueueExecutionStatus/14317/54");
		
		//Print response
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody is = " + responseBody);
		
		//status code validation
		int statusCode = response.getStatusCode();
		
		System.out.println("status code is = " + statusCode);
		Assert.assertEquals(statusCode, 403);
		
		//status line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status line = " + statusLine);
		
	//	Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}

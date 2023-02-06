import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	@Test
	void registrationSuccessfull()
	{
		//specify base URI
		RestAssured.baseURI = "https://reqres.in";
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//ResponseObject
		
		//Request Payload sending along with POST request
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", "Ajit");
		requestParams.put("job", "IT");
		requestParams.put("name", "Shalu");
		requestParams.put("job", "Teacher");
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestParams.toJSONString());
		
		//Response object
		Response response = httprequest.request(Method.POST, "/api/users");
		
		//Print response
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody is = " + responseBody);
		
		//status code validation
		int statusCode = response.getStatusCode();
		
		System.out.println("status code is = " + statusCode);
		Assert.assertEquals(statusCode, 201);
		
		String successcode = response.jsonPath().get("SuccessCode");
		System.out.println("Success code validation = " + statusCode);
	//	Assert.assertEquals(successcode, "OPERATION_SUCCESS");
		//status line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status line = " + statusLine);
		
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
		
	}
}

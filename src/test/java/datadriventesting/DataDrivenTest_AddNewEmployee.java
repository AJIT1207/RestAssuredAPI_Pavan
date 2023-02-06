package datadriventesting;

import org.apache.http.HttpRequest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmployee {
	
	@Test
	void addNewEmployee()
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", "Shalu123522222");
		requestParams.put("salary", "12345");
		requestParams.put("age", "30");
		
		//Add a header stating the Request Body is JSON
		httprequest.header("Content-Type","application/json");
		
		//Add the json to the body of the request
		httprequest.body(requestParams.toJSONString());
		
		//Post Request
		Response response = httprequest.request(Method.POST,"/create");
		String responseBody = response.getBody().asString();
		
		Assert.assertEquals(responseBody.contains("Shalu123522222"),true);
		Assert.assertEquals(responseBody.contains("12345"),true);
		Assert.assertEquals(responseBody.contains("30"),true);
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
		
		/*
		 * void postNewEmpployee() {
		 * 
		 * @DataProvider(name="empdataprovider") String [][] getEmpData() { String
		 * empdata[][] = {
		 * {"adfdff123","133445","35"},{"dhjgfjd","24555","23"},{"dhfjgfk","1345","34"}}
		 * ; return(empdata); }
		 * 
		 * }
		 */
	}


}

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


//Validating all the fields in ResponseBody

public class TC004_GET_ValidatingJSONResponse {

	@Test
	public void jsonResponse()
	{
		//specify base URI
		RestAssured.baseURI = "https://reqres.in";

		//Basic authentication
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("postman");
		authscheme.setPassword("password");
		
		RestAssured.authentication=authscheme;

		//Request object
		RequestSpecification httprequest = RestAssured.given();

		//ResponseObject
		Response response = httprequest.request(Method.GET, "/api/users/2");

		//Print response
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody is = " + responseBody);

		Assert.assertEquals(responseBody.contains("Weaver"), true);

		JsonPath jsonpath = response.jsonPath();

		System.out.println(jsonpath.get("support"));

		//	Assert.assertEquals(jsonpath.get("support"), "url=https://reqres.in/#support-heading, text=To keep ReqRes free, contributions towards server costs are appreciated!");
	}

}

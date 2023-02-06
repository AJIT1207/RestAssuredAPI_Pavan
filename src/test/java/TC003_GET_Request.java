import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {

	@Test
	public void singleUser()
	{
		//specify base URI
				RestAssured.baseURI = "https://reqres.in";
				//Request object
				RequestSpecification httprequest = RestAssured.given();
				
				//ResponseObject
				Response response = httprequest.request(Method.GET, "/api/users/2");
				
				//Print response
				String responseBody = response.getBody().asString();
				System.out.println("ResponseBody is = " + responseBody);
				
				//validating headers
				String contentType = response.header("Content-Type");
				System.out.println("Content type is = "  + contentType);
				Assert.assertEquals(contentType, "application/json; charset=utf-8");
				
				Headers allheader = response.headers();
				
				for( Header headersnew : allheader)
				{
					System.out.println(headersnew.getName() + "   =>   " + headersnew.getValue());
				}
				
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

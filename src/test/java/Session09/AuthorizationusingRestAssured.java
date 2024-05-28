package Session09;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationusingRestAssured {
	
	@Test
	public void BearerToken() {
		
		//Bearer a83afb1e964a44b1ce4f60d157abc8a8b2466c06c8ba587680cad32eaef27f61
		
		RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		RequestSpecification requestSpec=RestAssured.given();
		
		//Post request is using hence we need to create the data
		/*{
		 * "name": "Jatin Rout",
		 * "gender": "Male",
		 * "email": "Code5555@gmail.com",
		 * "status": "Active"}
		  */
		 
		JSONObject payload=new JSONObject();
		payload.put("name", "Jatin Rout9");
		payload.put("gender", "Male");
		payload.put("email", "Code55555@gmail.com");
		payload.put("status", "Active");
		
		String AuthToken="Bearer a83afb1e964a44b1ce4f60d157abc8a8b2466c06c8ba587680cad32eaef27f61";
		
		
		//authorization code is used in headers in restassured.contentType(ContentType.JSON) is used because data will be given in json format
		Response response=requestSpec.headers("Authorization", AuthToken).contentType(ContentType.JSON).body(payload.toJSONString()).when().post();
		Assert.assertEquals(response.statusCode(), 201);
		
		System.out.println("Response code:-" + response.statusCode());
		System.out.println("Response staus line:-" + response.statusLine());
		System.out.println("Response body:-" + response.body().asString());

		
	}

}

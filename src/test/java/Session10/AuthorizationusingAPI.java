package Session10;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationusingAPI {
	
	//API key:-f2ba0399d71b48a3a1e02245f906ea62
	//URL:- https://api.openweathermap.org/data/2.5/weather?q={city id}&appid={API key}
	
	@Test
	public void AuthorizationAPIKey() {
		
		RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather";
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.queryParam("q", "Noida").queryParam("appid", "f2ba0399d71b48a3a1e02245f906ea62");
		Response response=requestSpecification.get();
		
		Assert.assertEquals(response.getStatusCode(), 200, "Response status through Assert");
		System.out.println("Response code:-" + response.statusCode());
		System.out.println("Response status line:-" + response.statusLine());
		System.out.println("Response body:-" + response.body().asString());
		


	
	}

}

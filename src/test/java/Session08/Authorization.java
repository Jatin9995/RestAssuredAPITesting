package Session08;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {
	
	//https://postman-echo.com/basic-auth
	//id-postman, password- password
	
	@Test
	public void Basicauth() {
		
		RestAssured.baseURI="https://postman-echo.com/basic-auth";
		
		RequestSpecification requestSpecification=RestAssured.given();
		
		//initiate get request with authorization id and pasword
		//Response response=requestSpecification.auth().basic("postman", "password").get();//"non-preemptive basic authorization" giving basic authorization id and pasword in a second go and then sending get request
		
		Response response=requestSpecification.auth().preemptive().basic("postman", "password").get();//preemptive basic authorization used to give the authorization in a first go.
		System.out.println("Response status code:-" + response.statusCode());
		System.out.println("Response statusline:-" + response.getStatusLine());
		System.out.println("Response Body:-" + response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);//validation
		
		//same with the digest authentication. same process used. Digest authentication is more secure and also provide the authentication is a first go.
		
		//Response response=requestSpecification.auth().digest("postman", "password").get(); this s used incase of digest authentication
		
		
		
	}

}

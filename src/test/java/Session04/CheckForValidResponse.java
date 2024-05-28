package Session04;

import javax.sound.sampled.Line;

import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {

	//Every request in Rest-assured liberary is represented by an interface called RequestSpecification
	//this interface allow to modiify the request, like adding headers or adding authntication details.
	
	@Test(enabled = false)
public void GetSingleUser() {
	
	RestAssured.baseURI="https://reqres.in/api/users/2";
  RequestSpecification requestSpec=RestAssured.given();	//We have used RequestSpecification as an interface. We can implement interface but cannot create an object.
  Response res=requestSpec.get();// we have saved the payload in res and used Response as a onstant value bcoz get request give response
  int statsCode=res.getStatusCode();//we have get the status code and saved it in statsCode
  	
  //validting the status code.
 Assert.assertEquals(statsCode, 200, "Correct Status code received");

 //Validating status line
 String statusline=res.getStatusLine();
 Assert.assertEquals(statusline, "HTTP/1.1 200 OK", "Correct Status Line Received");//HTTP/1.1 200 OK this will be given in SRS 
 
 
 
  
}	
	
	 //Using validatable response
	//there are several ways in RestAssured to execute commands.

	@Test(enabled = false)
	public void GetSingleUserusingValidatableResponse() {
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
	  RequestSpecification requestSpec=RestAssured.given();	//We have used RequestSpecification as an interface. We can implement interface but cannot create an object.
	  Response res=requestSpec.get();// we have saved the payload in res and used Response as a onstant value bcoz get request give response
	ValidatableResponse validatableres=res.then();	
	
	//Status code
	validatableres.statusCode(200);
	
	//Status line
	validatableres.statusLine("HTTP/1.1 200 OK");
	 
	
	}
	
	@Test
	
	public void GetSingleUserusing_BDDStyle() { // we have used static and .* in restassured import file so that we don't have to write RestAsured class agian n again.
		
		baseURI="https://reqres.in/api/users/2";
		given().
		when().get().
		then().statusCode(200).statusLine("HTTP/1.1 200 OK");
		
		
		
		
	}
	
}

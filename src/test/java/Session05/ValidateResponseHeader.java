package Session05;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {
	
	//https://reqres.in/api/users/2
	
	@Test
	
	public void ValidateHeader() {
		//specify base url
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		//get request specification
		RequestSpecification reqSpec=RestAssured.given();
		
		//create get request
		Response response=reqSpec.get();
		
	//validate response header
String headervalue=response.getHeader("Content-Type");
String connectionvalue=response.getHeader("Connection");
System.out.println("Value of Content-Type:- " + headervalue );
System.out.println("Value of connection:-" + connectionvalue);

//Validate header value
Assert.assertEquals(headervalue, "application/json; charset=utf-8", "Content type value matched");
Assert.assertEquals(connectionvalue, "keep-alive", "Connection type value matched");


//Read all headers and print their values.
//we will use for each loop to print all headers key and value

Headers headerlist=response.getHeaders();

for(Header header:headerlist) {
	
	System.out.println(header.getName() + ":" + header.getValue());
	
}



		
	}

	
	
	
}

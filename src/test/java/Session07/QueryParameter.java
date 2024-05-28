package Session07;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameter {
	
	//https://reqres.in/api/users?page=2
	
	@Test
	public void Querypatameter() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification reqSpec=RestAssured.given();
	    reqSpec.queryParam("page", "2").queryParam("id", 10);//if want to go in id 10 then use query parameter again
		
		//perform get request
	    
	    Response response=reqSpec.get();
	    //read response body
	  String responseString= response.getBody().asString();
	  //print resonse body
	  System.out.println("Response body:-" + responseString);
		
	  	//Validate first name using json path
	JsonPath jsonresponse= response.jsonPath();
	String firstname=jsonresponse.get("data.first_name");
	Assert.assertEquals(firstname, "Byron", "Validating first name");
	System.out.println("First name value:-" + firstname );
		
		
		
		
	}
	

}

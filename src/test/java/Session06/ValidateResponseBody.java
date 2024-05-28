package Session06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseBody {
	
	//https://reqres.in/api/users?page=2    
	
	
	@Test
	public void validateBody() {
		
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		RequestSpecification requestSpec= RestAssured.given(); //we have used RequestSpecification bcoz it is used as an interfce to represent restassured request
        Response res=requestSpec.get(); 	// we  have saves the get response in res variable and used Response class.
       ResponseBody resbody=res.getBody();//read the body. res.getBody will return a response body. hense we have saved it in respody using ResponseBody
       String responseString=resbody.asString();// converted it to String to print in console.
       System.out.println("Response Body:-" + responseString);
       
//validate and check for presence of George in response body. We will use contains.
       Assert.assertEquals(responseString.contains("George"), true, "Check for presence of George");
       
      
//To validate the response body, we need the json path like we did in postman. json path finder will help in this.
       //jsonpath is also a library available in RestAssured.
       //json path x.data[0].first_name which we have found from jsonpathfinder
       
       
       JsonPath jsonPathview=resbody.jsonPath();
      String Firstname= jsonPathview.get("data[0].first_name");
      Assert.assertEquals(Firstname, "George", "Check for presence of George name in response body");
      
      //to print anything from the body.
      
String linkString=jsonPathview.get("data[1].avatar");
System.out.println("Link name:-" + linkString);
               
	
	
	}

}

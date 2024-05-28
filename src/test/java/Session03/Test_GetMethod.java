package Session03;



import org.junit.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_GetMethod {

	@Test
	public void test01() {
		
		Response res=RestAssured.get("https://reqres.in/api/users?page=2");//opening the URL and saving its data into a variable. Response constant value taken bcoz get request will response a payload
		
		//now we will print the response code, response body, response header, response time
		
		//Print the payload received through get request
		
		System.out.println("Response Code:- "+ res.getStatusCode());//printed the status code
		System.out.println("Response Body:- " + res.body().asString());//printed the body
		System.out.println("Response Header:- " + res.getHeader("Content-Type"));//printed the content type value
		System.out.println("Response time:- " + res.getTime());//printed the response time
		
//validate status code
		int expectedStatusCode=200;
		int ActualStatusCode=res.getStatusCode();
		
Assert.assertEquals(expectedStatusCode, ActualStatusCode);
		
		
	}
	
	//Now we will write the above methods in BDD style
	@Test
    public void test02BDDStyle() {
    	
    	//given, when, then
    	
    	RestAssured.baseURI="https://reqres.in/api/users";
    	RestAssured.given().queryParam("page", "2").when().get().then().statusCode(200);
    	
    	//RestAssured.given().baseUri("https://reqres.in/api/users?page=2").when().get().then().statusCode(200); // another way
    	
    	
    }
	
	
	
	
}

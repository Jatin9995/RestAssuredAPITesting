package Session03;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_DeleteMethod {
	
	@Test
	
	public void test05() {
		
		RestAssured.baseURI="https://reqres.in/api/users/223";
		RestAssured.given().when().delete().then().statusCode(204).log().all();
		
		
		
	}
	

}

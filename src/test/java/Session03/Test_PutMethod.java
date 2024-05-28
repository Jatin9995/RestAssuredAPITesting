package Session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PutMethod {
	
	@Test
	public void test04() {
		
		JSONObject jsondata= new JSONObject();
		jsondata.put("name", "KK");
		jsondata.put("job", "Developer");
		
		
		RestAssured.baseURI="https://reqres.in/api/users/223";// we have takekn the id from postmethod class which we have generated.
		RestAssured.given().contentType(ContentType.JSON).
		body(jsondata.toJSONString()).
		when().put().
		then().statusCode(200).
		log().all();
		
		//everything is same like post but inpace of post we have used put.
		//contentType(ContentType.JSON) we have used so that we have give the data is json format.
	}
	
	

}

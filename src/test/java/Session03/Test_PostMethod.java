package Session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;



public class Test_PostMethod {
	
	@Test
	public void test03() {
		
		//data create karne k liye json object create karna hota hai kyu json format me data create hota hai restassured me. islye hum json simple ki depency add ki the
		
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "Jatin");
		jsondata.put("job", "QA");
		
		//String requestBody="{\"name\":\"Jatin\", \"job\": \"QA\"}";another way to create body data in rest assured
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RestAssured.given().contentType(ContentType.JSON).
		body(jsondata.toJSONString()).
		when().post().
		then().statusCode(201).
		log().all();  //if want to print the response logs then ue log().all();
	
	
	}
	

}

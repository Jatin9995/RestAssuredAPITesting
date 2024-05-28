package RestAssured;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Session2_FirstGetRequest {
	
	@Test
public void testcase01() {
	
	
Response res=RestAssured.get("https://reqres.in/api/users?page=2");//to send any request, RestAssured used before the request type. We have saved the get request in a variable and print it.
// We have use Response as a constant because get request provide a response
System.out.println(res.asString());// We have print the response as string
System.out.println("Status code of Get Request " + res.getStatusCode());// we have print the status code as well.

}

}

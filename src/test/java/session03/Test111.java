package session03;

 import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.annotations.Test;





public class Test111 {
	
	@Test
	
	public void myTest()
	{
		
		baseURI="https://www.reqres.in";
		
	JSONObject obj1= new JSONObject();
	
	obj1.put("name","morpheus");
	
	obj1.put("job", "leader");
	
	given().contentType("application/json").body(obj1.toString()).
	//given().contentType(ContentType.JSON).body(obj1.toJSONString()).
	when().post("https://reqres.in/api/users").
	then().
	
	assertThat().statusCode(201).log().all();
	
	}
	

}

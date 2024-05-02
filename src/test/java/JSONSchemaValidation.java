import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;


public class JSONSchemaValidation {
	
	@Test
	public void JsonValidation()
	{
		given().
		
		when().
		     get("https://reqres.in/api/unknown")
		
		.then()
		
		.assertThat().
		
		body(matchesJsonSchemaInClasspath("JsonSchema.json"));
		
	}
	
	
	//How to find field is Array or not
	public void jsonValidation2()
	{
		
		Response response=given().contentType(ContentType.JSON).
		
		when()
		
		.get("https://reqres.in/api/users?page=2");
		
		
		String jsondata="{ \"data\": [] }";
		response.then()
		.assertThat().
		body(matchesJsonSchema(jsondata));
		
		
		
	}

}

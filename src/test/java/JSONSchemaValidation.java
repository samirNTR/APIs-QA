import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;


public class JSONSchemaValidation {
	
	@Test
	public void JsonValodation()
	{
		given().
		
		when().
		     get("https://reqres.in/api/unknown")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchema.json"));
		
	}
	
	

}

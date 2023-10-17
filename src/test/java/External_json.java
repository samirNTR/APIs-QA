import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;

import org.testng.annotations.Test;



public class External_json {
	//Read data from external JSON file

	@Test

	public void testPostusing_ExternalJSONfile() throws FileNotFoundException {

File fis = new File(".\\Body.json");	
FileReader f= new  FileReader(fis);
JSONTokener jt = new JSONTokener(f);
JSONObject data = new JSONObject(jt);



	

	

		/*
		 * JSONObject requestjson= new JSONObject();
		 * 
		 * //JSONObject authorjson= new JSONObject();
		 * 
		 * requestjson.put("name", "morpheus");
		 * 
		 * requestjson.put("job", "leader");
		 */
		given()

		.contentType("application/json").body(data.toString()).

		when()
		
		.post("https://reqres.in/api/users").
		
		
		then()
      .statusCode(201).
      body("name", equalTo("morpheus")).
      body("job", equalTo("leader")).log().all();

}}

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;







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

}

	
@Test

public void testUsingjsonParser() throws  IOException, ParseException     //using json simple

{
	
	JSONParser jsonparser= new JSONParser();
	File fis= new File(".\\Body.json");
	FileReader reader= new FileReader(fis);
	try
	{
	//Object obj= jsonparser.parse(reader);  -----> convert json file to java object
	
	org.json.simple.JSONObject obj=  (org.json.simple.JSONObject) jsonparser.parse(reader);   //converting json file to--> JSON object	
	String name=(String)obj.get("name");
	String job=(String)obj.get("job");

	System.out.println("The name is " +name+":"+job);

Assert.assertEquals(obj.get("name"), "morpheus");

Assert.assertEquals(obj.get("job"), "leader");

	}
catch (IOException | ParseException e) {
    e.printStackTrace();
}

}


	}

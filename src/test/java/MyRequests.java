import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.*;

import java.util.Map;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MyRequests {
@Test
	public void JsonServer() // Use of JSON-PATH
	{
		baseURI = "https://reqres.in/";

		RequestSpecification request = given().contentType(ContentType.JSON);

		Response response = request.get("/api/users?page=2");

		System.out.println("The body is " + response.getBody().asPrettyString());

		String responseString = response.getBody().asString();
		JsonPath path = new JsonPath(responseString); // Json path always accept string
    
		// String pathName=path.getString("data");
		// System.out.println("The extracted path name is " +pathName);
		
		 int userId = path.getInt("data.find { it.id == 7 }.id");  //it represent each element of array
		 System.out.println("Id is "+ userId);
		 
		 String email = path.getString("data.find { it.id == 12 }.email"); //-----------1)
         System.out.println(email);
		 
         String name= path.getString("data.find{it.id==10}.first_name"); //---------2)
         Assert.assertEquals(name, "Byron");
         
         
		String dataType = path.get("data").getClass().getSimpleName(); //---------3)
		System.out.println("The Data type is :" + dataType);
		Assert.assertEquals(dataType, "ArrayList", "The 'data' field is not an array.");
	

	}

	
	
	
	
	/*
	 * @Test(priority=1)
	 * 
	 * public void postRequest1() { Pojo_class1 data = new Pojo_class1();
	 * data.setJob("leader"); data.setName("morpheus"); try { // Use ObjectMapper to
	 * convert the POJO to JSON ObjectMapper objectMapper = new ObjectMapper();
	 * String jsonBody = objectMapper.writeValueAsString(data);
	 * 
	 * given() .contentType(ContentType.JSON) .body(jsonBody) .when()
	 * .post("https://reqres.in/api/users") .then() .statusCode(201) .body("name",
	 * equalTo("morpheus")) .header("Content-Type",
	 * containsString("application/json")) .body("job", equalTo("leader"))
	 * .log().body(); } catch (Exception e) { // Handle exceptions
	 * e.printStackTrace(); } }
	 * 
	 * @Test
	 * 
	 * public void postRequest2() { Pojo_class1 data = new Pojo_class1();
	 * 
	 * data.setJob("leader"); data.setName("morpheus");
	 * 
	 * 
	 * JSONObject requestjson= new JSONObject();
	 * 
	 * //JSONObject authorjson= new JSONObject();
	 * 
	 * requestjson.put("name", "morpheus");
	 * 
	 * requestjson.put("job", "leader");
	 * 
	 * given()
	 * 
	 * .contentType(ContentType.JSON).body(data). // contentType("application/json")
	 * when()
	 * 
	 * .post("https://reqres.in/api/users").
	 * 
	 * 
	 * then() .statusCode(201) . body("name", equalTo("morpheus")).
	 * header("Content-Type", containsString("application/json")).
	 * 
	 * body("job", equalTo("leader")). log().body(); }
	 * 
	 * RequestSpecification reqspec= RestAssured.given().
	 * contentType(ContentType.JSON). body(requestjson.toJSONString());
	 * 
	 * Response response= reqspec.post("https://reqres.in/api/users");
	 * 
	 * int statuscode= response.getStatusCode();
	 * System.out.println("The status code is" +statuscode);
	 * System.out.println("Response Body "+ response.getBody().asPrettyString());
	 * System.out.println(response.getStatusLine());
	 * 
	 * 
	 * 
	 * 
	 * 
	 * String mymethod="{\r\n" + "    \"name\": \"morpheus\",\r\n" +
	 * "    \"job\": \"zion resident\"\r\n" + "}";
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * package io.restassured.http;
	 * 
	 * public enum ContentType { JSON("application/json"), XML("application/xml"),
	 * HTML("text/html"), // ...
	 * 
	 * private final String mimeType;
	 * 
	 * ContentType(String mimeType) { this.mimeType = mimeType; }
	 * 
	 * public String getMimeType() { return mimeType; } }
	 * 
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * public void deleteRequest() { baseURI="https://reqres.in/";
	 * 
	 * given().
	 * 
	 * when().
	 * 
	 * delete("api/users/2").
	 * 
	 * then().statusCode(204).log().all();
	 * 
	 * 
	 * 
	 * //log.body();
	 * 
	 * //log.cookies(); //log.cookies(); }
	 * 
	 * 
	 * @Test
	 * 
	 * public void RequestSpecification() {
	 * 
	 * baseURI="https://reqres.in";
	 * 
	 * JSONObject requestjson= new JSONObject();
	 * 
	 * // JSONObject authorjson= new JSONObject();
	 * 
	 * requestjson.put("name", "morpheus");
	 * 
	 * requestjson.put("job", "leader");
	 * 
	 * 
	 * 
	 * 
	 * RequestSpecification reqres=
	 * given().contentType("application/json").body(requestjson.toJSONString());
	 * 
	 * Response res= reqres.post("api/users");
	 * 
	 * 
	 * 
	 * int statuscode= res.statusCode(); // int statuscode= res.getstatusCode();
	 * System.out.println("The status code is "+statuscode);
	 * 
	 * System.out.println("The status line is "+res.statusLine());
	 * 
	 * System.out.println("Response Body : "+res.getBody().asPrettyString());
	 * 
	 * 
	 * String pathname= res.jsonPath().get("name"); String
	 * pathjob=res.jsonPath().get("job");
	 * 
	 * 
	 * //Header handling Headers r1= res.getHeaders();
	 * 
	 * for(Header r2:r1) { System.out.println(r2.getName() +": "+r2.getValue());
	 * 
	 * }
	 * 
	 * 
	 * //Cookie handling//Keyset to extract all the keys Map<String ,String>
	 * cookies=res.getCookies();
	 * 
	 * System.out.println("List of cookies are "+cookies.keySet());
	 * 
	 * for(String cookie: cookies.keySet()) {
	 * 
	 * String cookie_value=res.getCookie(cookie);
	 * 
	 * System.out.println(cookie+"  "+cookie_value); }
	 * 
	 * Assert.assertEquals(pathname, "morpheus","Assertion Failed");
	 * Assert.assertEquals(pathjob, "leader");
	 * 
	 * 
	 * String fullURI = baseURI +basePath + "/users/1";
	 * System.out.println("Full URI: " + fullURI);
	 * 
	 * 
	 * 
	 * }
	 */



	
}

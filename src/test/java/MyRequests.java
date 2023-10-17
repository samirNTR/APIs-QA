import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class MyRequests {

	@Test(priority=1)

	public void putRequest() {

		Pojo_class1 data = new Pojo_class1();

		data.setJob("leader");
		data.setName("morpheus");

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

		.contentType(ContentType.JSON).body(data).
    //  contentType("application/json")
		when()
		
		.post("https://reqres.in/api/users").
		
		
		then()
      .statusCode(201)
     . body("name", equalTo("morpheus")).
      header("Content-Type", containsString("application/json")).

      body("job", equalTo("leader")).
      log().body();
	}
		/*
		 * RequestSpecification reqspec= RestAssured.given().
		 * contentType(ContentType.JSON). body(requestjson.toJSONString());
		 * 
		 * Response response= reqspec.post("https://reqres.in/api/users"); 
		 * 
		 * int
		 *statuscode= response.getStatusCode(); System.out.println("The status code is"		
		 * +statuscode); System.out.println("Response Body "+
		 * response.getBody().asPrettyString());
		 * System.out.println(response.getStatusLine());
		 * 
		 * 
		 * 
		 * 
		 * 
		 * String mymethod="{\r\n" + "    \"name\": \"morpheus\",\r\n" +
		 * "    \"job\": \"zion resident\"\r\n" + "}";
		 * 
		 */
		
		
		
/*		
		package io.restassured.http;

		public enum ContentType {
		    JSON("application/json"),
		    XML("application/xml"),
		    HTML("text/html"),
		    // ...

		    private final String mimeType;

		    ContentType(String mimeType) {
		        this.mimeType = mimeType;
		    }

		    public String getMimeType() {
		        return mimeType;
		    }
		}


	}*/
	
	//@Test
	
	public void deleteRequest()
	{
		 baseURI="https://reqres.in/";
		
		given().
		
		when().
		
		delete("api/users/2").
		
		then().statusCode(204).log().all();
		
		//log.body();
		
		//log.cookies();  //log.cookies();
	}
	
	
	//@Test
	
	public void RequestSpecification()
	{
		
		 baseURI="https://reqres.in";
		
		  JSONObject requestjson= new JSONObject();
		 
		// JSONObject authorjson= new JSONObject();
		 
		 requestjson.put("name", "morpheus");
		 
		 requestjson.put("job", "leader");
		 
		 

		 
		 RequestSpecification reqres= given().contentType("application/json").body(requestjson.toJSONString());
		 
		 Response res= reqres.post("api/users");
		 

		
		 int statuscode= res.getStatusCode();
		 System.out.println("The status code is "+statuscode);
		 
		 System.out.println("The status line is "+res.statusLine());
		 
		 System.out.println("Response Body : "+res.getBody().asPrettyString());
		 
		 
		 String pathname= res.path("name");
		String pathjob=res.path("job");
	
		
		//Header handling
	Headers r1=	res.getHeaders();
	
	for(Header r2:r1)
	{
		System.out.println(r2.getName() +": "+r2.getValue());
		
	}
	
	
	//Cookie handling//Keyset to extract all the keys  
	Map<String ,String> cookies=res.getCookies();
	
	System.out.println("List of cookies are "+cookies.keySet());
	
	for(String cookie: cookies.keySet())
	{
		
		String cookie_value=res.getCookie(cookie);
		
		System.out.println(cookie+"  "+cookie_value);
	}
		
	Assert.assertEquals(pathname, "morpheus","Assertion Failed");
	Assert.assertEquals(pathjob, "leader");
	
	/*
	 * String fullURI = baseURI +basePath + "/users/1";
	 * System.out.println("Full URI: " + fullURI);
	 */
		
		
	}

}

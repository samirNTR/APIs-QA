import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Path_Queryparam {

	
	@Test
	
	public void queryparam()
	{
		baseURI="https://reqres.in/";
		RequestSpecification res=given().header("Content-Type" , "application/json").contentType(ContentType.JSON);
		
		res.basePath("/api/users");
		
		
		
		//queryparam
		res.queryParam("page", 2).queryParam("id", 10);
		//perform get request
		
		Response response=res.get();
		
		String responseBody=response.getBody().asPrettyString();
		
		System.out.println(responseBody);
		
         JsonPath pathview=response.jsonPath();
         
        String first_name= pathview.get("data.first_name");
        

         
         Assert.assertEquals(first_name,"Byron");	
         
      
         
	}

}

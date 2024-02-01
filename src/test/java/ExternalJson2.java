import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ExternalJson2 {

	
	@Test(priority=1)
	public void testUsingRestAssured() throws IOException, ParseException

	{
	
	JSONParser parser = new JSONParser();
	
	File fis= new File(".\\Body1.json");
	
	FileReader reader= new FileReader(fis);
	
	
JSONObject obj= (JSONObject) parser.parse(reader);  //obj is root object
     
System.out.println("JSON File Content:");
System.out.println(obj.toJSONString());
	
JSONObject person= (JSONObject) obj.get("person");// It will return as an Object type that's why casting to JSONObject
		 
	Assert.assertEquals(person.get("id"),123L);	
	Assert.assertEquals(person.get("name"),"Alice");	
	Assert.assertEquals(person.get("age"),30L);	
	
	
	
	 JSONObject education = (JSONObject) person.get("education");
     Assert.assertEquals(education.get("degree"), "Master's", "Incorrect degree");
     Assert.assertTrue(education.containsKey("university"), "University info missing");

     JSONArray interests = (JSONArray) person.get("interests");
     Assert.assertTrue(interests.contains("Programming"), "Programming interest not found");
	
	JSONArray contacts= (JSONArray) person.get("contacts");
	Assert.assertEquals(contacts.size(),2);


	     
	        
	        
		/*
		 * boolean
		 * emailFound=jsonpath.getList("person.contacts.type").contains("email");
		 * 
		 * boolean foundProgramming=
		 * jsonpath.getList("person.intersts").contains("Programming");
		 * 
		 * Assert.assertTrue(emailFound); Assert.assertTrue(foundProgramming);
		 */
		
		
		
		
		
		
	}
	
	
	

}

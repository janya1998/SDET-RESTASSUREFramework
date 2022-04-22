package DiffrentWaysRequestToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import CommonLibraies.JavaLibary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingProjectUsingJsonObject {
	@Test

	public  void CreatingProjectUsingJsonObject() {
		JavaLibary jlib=new JavaLibary();
		//step1: create pre requisites
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "nellu");
		jobj.put ("projectName","Acceunter"+jlib.getRandomNumber());
		jobj.put("status", "on processing");
		jobj.put("teamSize", 10);
		
		baseURI="http://localhost:8084";
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		
		
		
		
		

	}

}

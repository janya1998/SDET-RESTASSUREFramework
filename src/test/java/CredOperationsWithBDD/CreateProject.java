package CredOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	@Test

	public void CreateProject() {
	
			//step1: create the the pre requtsts -request body
			JSONObject jobj=new JSONObject();
			jobj.put("createdBy", "souju12345");
			jobj.put("projectName", "srilank12345678");
			jobj.put("status", "completed");
			jobj.put("teamSize", 10);
			
			baseURI="http://localhost";
			port=8084;
			
			given()
			.body(jobj)
			.contentType(ContentType.JSON)
			
			.when()
			.post("addProject")
			
			.then()
			.assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();	
	}

	
}
 
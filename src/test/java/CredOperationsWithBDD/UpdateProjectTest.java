package CredOperationsWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
	@Test

	public  void UpdateProjectTest() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "souju12345");
		jobj.put("projectName", "srilank12345678");
		jobj.put("status", "ON Going");
		jobj.put("teamSize", 10);
		
		baseURI="http://localhost";
		port=8084;
		
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("projects/TY_PROJ_1808")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
		
		
		
		
		
	}

}

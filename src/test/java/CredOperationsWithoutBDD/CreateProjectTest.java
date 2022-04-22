package CredOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	@Test

	public void CreateProjectTest() {
		//step1: create the the pre requtsts -request body 
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","souju");
		jobj.put("projectName", "srilanka12");
		jobj.put("status", "completed");
		jobj.put("teamSize",10);
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		//step2:perform the action
		Response respose = req.post("http://localhost:8084/addProject");
	
		
		//step 3:validate the response
		System.out.println(respose.getContentType());
		System.out.println(respose.asString());
		System.out.println(respose.prettyPrint());
		System.out.println(respose.prettyPeek());
	}

}

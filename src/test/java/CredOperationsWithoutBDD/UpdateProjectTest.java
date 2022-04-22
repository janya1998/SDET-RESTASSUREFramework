package CredOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test

	public void  UpdateProjectTest() {
		//step1: create the the pre requtsts -request body
				JSONObject jobj=new JSONObject();
				jobj.put("createdBy","souju");
				jobj.put("projectName", "srilanka1");
				jobj.put("status", "completed");
				jobj.put("teamSize",15);
				RequestSpecification req = RestAssured.given();
				req.body(jobj);
				req.contentType(ContentType.JSON);
				//step2:perform the action
				Response respose = req.put("http://localhost:8084/projects/TY_PROJ_1803");
				//step3: validate the action
				respose.then().log().all();
				int actsttus=respose.getStatusCode();
				Assert.assertEquals(200,actsttus);
				
			
		
	}

}

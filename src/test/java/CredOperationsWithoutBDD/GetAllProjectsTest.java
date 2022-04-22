package CredOperationsWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest {
	@Test

	public void GetAllProjects() {
		//step1: to perform action
		Response resp = RestAssured.get("http://localhost:8084/projects");
		//step3: validate the action
		resp.then().log().all();
		int actsttus=resp.getStatusCode();
		Assert.assertEquals(200,actsttus);
		
	}

}

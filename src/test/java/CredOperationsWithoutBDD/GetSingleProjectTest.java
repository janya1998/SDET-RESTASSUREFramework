package CredOperationsWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest {
	@Test

	public void GetSingleProjectTest() {
		//step1: to perform action
		Response respose = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1803");
		//step3: validate the action
		respose.then().log().all();
		int actsttus=respose.getStatusCode();
		Assert.assertEquals(200,actsttus);
		
	}

}

package CredOperationsWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {
	@Test

	public void DeleteProjectTest() {
		Response respose = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1804");
		//step3: validate the action
		respose.then().log().all();
		int actsttus=respose.getStatusCode();
		Assert.assertEquals(204,actsttus);
	}

}

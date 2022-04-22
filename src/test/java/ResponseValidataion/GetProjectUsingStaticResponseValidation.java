package ResponseValidataion;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class GetProjectUsingStaticResponseValidation {
	@Test

	public void GetProjectUsingStaticResponseValidation() {
		baseURI="http://localhost";
		port=8084;
		String expdata = "TY_PROJ_1003";
		
		 Response res = when().get("/projects");
		 //validation
		 String actdata = res.jsonPath().get("[0].projectId");
		 Assert.assertEquals(expdata, actdata);
		 System.out.println("data verified");
		 
		 res.then().log().all();
	}
		 
		
		
	}

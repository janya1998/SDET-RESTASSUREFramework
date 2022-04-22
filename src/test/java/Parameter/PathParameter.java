package Parameter;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test

	public void  PathParameter() {
		baseURI="http://localhost";
		port=8084;
		
	     Response res = given()
		.pathParam("pid", "TY_PROJ_806")
		
		//actions
		.when()
		.get("/projects/{pid}");
		
		//validation
		res.then()
		.log().all();
	}
		
		
	

}

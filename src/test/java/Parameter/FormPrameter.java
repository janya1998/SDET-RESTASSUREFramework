package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormPrameter {
	@Test

	public void FormPrameter() {
		baseURI ="http://localhost";
		port=8084;
		
		given()
		.formParam("createdBy", "madhu")
		.formParam("projectName","microsoft")
		.formParam("status","completed")
		.formParam("teamSize",19)
		
		//action
		.when()
		.post("/addProject")
		
		//validation
		.then().log().all();
	;
		
		
		
	}

}

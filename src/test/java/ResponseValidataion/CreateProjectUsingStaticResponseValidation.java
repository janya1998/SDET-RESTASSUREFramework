package ResponseValidataion;

import org.testng.annotations.Test;

import CommonLibraies.JavaLibary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingStaticResponseValidation {
	@Test

	public  void CreateProjectUsingStaticResponseValidation() {
		JavaLibary jlib=new JavaLibary();
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary plib=new ProjectLibrary("shreeram", "chrome"+jlib.getRandomNumber(), "created", 10);
		
		Response res = given()
		.body(plib)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
		
		res.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		

		
		
	

}


		
	}


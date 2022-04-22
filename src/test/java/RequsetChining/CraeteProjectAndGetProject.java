package RequsetChining;

import org.testng.annotations.Test;

import CommonLibraies.JavaLibary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CraeteProjectAndGetProject {
	@Test

	public void CraeteProjectAndGetProject() {
		JavaLibary jlib=new JavaLibary();
		ProjectLibrary plib=new ProjectLibrary("sadhana", "firefox", "created", 10);
		baseURI="http://localhost";
		port=8084;
		
		Response res = given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		//create the projectid
		String proId = res.jsonPath().get("projectId");
		System.out.println(proId);
		res.then().log().all();
		
		//create the get request and pass proid as path parameter
		given()
		.pathParam("pid", proId)
		.when()
		.get("/projects/{pid}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		
	}

}

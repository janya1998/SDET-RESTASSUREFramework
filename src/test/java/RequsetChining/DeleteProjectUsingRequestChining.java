package RequsetChining;

import org.testng.annotations.Test;

import CommonLibraies.JavaLibary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteProjectUsingRequestChining {
	@Test

	public void DeleteProjectUsingRequestChining() {
	
		Response res = when()
		.get("/projects");
		
		
		String freq = res.jsonPath().get("[0],projectId");
		
		given()
		.pathParam("projectId", freq)
		.delete("/projects/{projectId}")
		.then().log().all();
		
		
	}

}
       
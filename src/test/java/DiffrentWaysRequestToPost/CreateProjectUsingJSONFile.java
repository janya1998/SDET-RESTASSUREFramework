package DiffrentWaysRequestToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProjectUsingJSONFile {
	@Test
	

	public void CreateProjectUsingJSONFile() {
		//step1:create pre requrites
		File file = new File(".\\Data.json");
		baseURI ="http://localhost:8084";
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		
	}

}

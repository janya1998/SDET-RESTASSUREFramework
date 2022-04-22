package CredOperationsWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
	@Test

	public void DeleteProjectTest() {
		
		baseURI="http://localhost";
		port=8084;
		
		when()
		.delete("projects/TY_PROJ_1808")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(204)
		.log().all();
		
		
	}

}

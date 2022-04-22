package CredOperationsWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetSingleProject {
	@Test

	public void GetSingleProject() {
		
		baseURI="http://localhost";
		port=8084;
		
		when()
		.get("projects/TY_PROJ_1808")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();

	}

}

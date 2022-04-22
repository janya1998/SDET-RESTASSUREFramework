package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParametersTestForGit {
	@Test

	public void ParametersTestForGit() {
		
		baseURI="https://api.github.com";
		
		given()
		.pathParam("username", "soujanya")
		.queryParam("per_page",90)
		.queryParam("page", 1)
		
		.when()
		.get("/users/{username}/repos")
		
		.then().assertThat().statusCode(200).log().all();
		
	}

}

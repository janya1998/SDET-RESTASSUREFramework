package Parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameter {
	@Test
	

	public void QueryParameter() {
		baseURI="https://reqres.in";
		
		given()
		.queryParam("page", 2)
		
		.when()
		.get("/api/users")
		
		.then()
		.log().all();
				
				
	}

}

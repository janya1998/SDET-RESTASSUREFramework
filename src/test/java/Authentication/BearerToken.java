package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test

	public void  bearerToken() {
		baseURI="https://api.github.com";
		JSONObject jobj=new JSONObject();
		jobj.put("name", "sdet30-restAssure");
		
		given()
		.auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then().log().all();
	
		
	}

}

package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0 {
	@Test
	

	public  void auth2_0() {
		
		//CREATE A request to generate  acess token
		Response res = given()
		.formParam("client_id","sowndrya-SDET")
		.formParam("client_secret","5ec27646e295e2797f35aef24c44e994")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri", "http://example1.com")
		.formParam("code ", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		//capture the acess token from the response of the above request
		String token = res.jsonPath().get("access_token");
		System.out.println(token);
		
		//create the another request and use the token to acess the apis
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3139)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		
		.then().log().all();
		
		
	}

}

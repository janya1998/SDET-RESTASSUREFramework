package ResponseValidataion;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.mysql.cj.log.Log;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidation {
	@Test

	public void ResponseTimeValidation() {
		
		baseURI="http://localhost";
		port=8084;
		
		//action
	 Response res = when()
		.get("/projects");
		
		//validation
		res.then()
		.assertThat().time(Matchers.greaterThan(50L),TimeUnit.MILLISECONDS);
		long l1=res.time();
		System.out.println(l1);
	
		
		
		
	}

}

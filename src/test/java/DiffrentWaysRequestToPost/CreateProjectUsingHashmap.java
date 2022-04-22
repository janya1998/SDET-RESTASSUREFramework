package DiffrentWaysRequestToPost;

import org.testng.annotations.Test;

import CommonLibraies.JavaLibary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashmap {
	@Test

	public void  CreateProjectUsingHashmap() {
		JavaLibary jlib=new JavaLibary();
		baseURI="http://localhost:8084";
	//step 1:create the pre requites
	HashMap map=new HashMap();
	map.put("createdBy", "shivu");
	map.put("projectName","Acceunter"+jlib.getRandomNumber());
	map.put("status", "completed");
	map.put("teamSize", 12);
	
	given()
	.body(map)
	.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject")
	
	.then()
	.assertThat()
	.statusCode(201)
	.log().all();
	
	
	
		
		
		
	}

}

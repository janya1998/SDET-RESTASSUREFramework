package DiffrentWaysRequestToPost;

import org.testng.annotations.Test;

import CommonLibraies.JavaLibary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingProjectUsingPOJO {
	@Test

	public void CreatingProjectUsingPOJO() {
		
		JavaLibary jlib=new JavaLibary();
		baseURI="http://localhost:8084";
		
		//step1: create the pre requites
		ProjectLibrary pobj=new ProjectLibrary("sanjay","google"+jlib.getRandomNumber(),"completed",12);
		given()
		.body(pobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		
		
	}


		
	}



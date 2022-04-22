package rmgyantraTestWithFramework;

import static io.restassured.RestAssured.given;

import CommonLibraies.BaseAPIClass;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreateProjectAndVerifyinDatabase extends BaseAPIClass {

	
	public void createProjectVerifyInDb() throws Throwable
	{
		//Step 1: create Prerequistes
		
		ProjectLibrary plib=new ProjectLibrary("suhas", "browser","on going", 10);
		Response resp = given()
		                  .body(plib)
		                  .contentType(ContentType.JSON)
		 
	                   	  .when()
		                  .post(CommonLibraies.EndPointsLibrary.CreateProject);
		
		//Step 2: Capture the project ID
		String expData =rlib.getJsonPath(resp, "projectId");
		System.out.println(expData);
		
		//Step 3: Verify the project in API response
		given()
		 .pathParam("pid", expData)
		.when()
		 .get(CommonLibraies.EndPointsLibrary.GetAllprojects+"/{pid}")
		.then().log().all();
		System.out.println("Data successfuly verifies in API response");
		
		//Step 4: Vefify the project in Database
		String query = "select * from project";
		String data = dlib.executeQueryAndGetData(query,expData, 1);
		System.out.println(data);
		System.out.println("data verifed successfully in databse");
		 
		
	}

}


package ResponseValidataion;

import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GetProjectUsingDynamicResponseValidation {
	@Test

	public  void GetProjectUsingDynamicResponseValidation() {
		String expdata = "TY_PROJ_617";
	
		baseURI="http://localhost";
		port=8084;
		
		Response res = when().get("/projects");
		
		//validation
		boolean flag=false;
		List<String> pIDs = res.jsonPath().get("projectId");
		for(String projectId:pIDs)
		{
			if(projectId.equalsIgnoreCase(expdata))
			{
				flag=true;
			}
		}
		
		Assert.assertTrue(flag);
		System.out.println("data verified");
		
		res.then().log().all();
		
	}

}

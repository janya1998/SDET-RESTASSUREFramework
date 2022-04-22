package DataDrivenTesing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonLibraies.JavaLibary;
import ProjectLibrary.ProjectLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateMultipalProjectWithDiffData
{
	@Test(dataProvider ="getData")

	public void createMultipa(String createdBy, String projectName, String status, int teamSize) 
	{
		
		//create the pre requiestis
		JavaLibary jlib=new JavaLibary();
		ProjectLibrary plib=new ProjectLibrary(createdBy, projectName+jlib.getRandomNumber(), status, teamSize);
		
		baseURI="http://localhost";
		port=8084;
		
	//create pre requriztes
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		
		//actions
		.when()
		.post("/addProject")
		
		//validation
		.then().log().all();
		
	}	

		
	@DataProvider(name="getData")
	public Object[][] data()
	{
		
        Object[][] data=new Object[3][4];
		
			data[0][0]="janyya";
			data[0][1]="hp";
			data[0][2]="Created";
			data[0][3]=12;
			
			data[1][0]="suhas";
			data[1][1]="google";
			data[1][2]="Completed";
			data[1][3]=110;	
			
			data[2][0]="chinuu";
			data[2][1]="ibm";
			data[2][2]="On Going";
			data[2][3]=10;
			
			return data;
			
			
		}
			
		
	}




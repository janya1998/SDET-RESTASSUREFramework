package CommonLibraies;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;






public class BaseAPIClass {
	public DataBaseLibrary dlib=new DataBaseLibrary();
	public JavaLibary jlib=new JavaLibary();
	public RestAssuredLibrary rlib=new RestAssuredLibrary();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		//Establish databse connection
		dlib.connectToDB();
		System.out.println("=============db connection established============");
		
		//set base Uri and port
	    baseURI = "http://localhost";
	    port = 8084;
	    
	    
	}
	
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dlib.closeDB();
	}



	

	
	}



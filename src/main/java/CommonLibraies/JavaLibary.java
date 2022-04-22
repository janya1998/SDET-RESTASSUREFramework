package CommonLibraies;

import java.util.Random;

/**
 * this class contains genric method releted to java
 * @author User
 *
 */

public class JavaLibary {
	/**
	 * this method will generate a random for every execution
	 * @return 
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		return ran.nextInt(1000);
	}

		
	

}

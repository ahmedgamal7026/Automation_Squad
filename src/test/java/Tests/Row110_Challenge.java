package Tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Pages.Courses_LetsKodeIt;

public class Row110_Challenge extends TestBase{
	
	
	@Test
	public void Challenge110() throws AWTException {
		
		
		  Courses_LetsKodeIt JS = new Courses_LetsKodeIt(driver);
          JS.Challenge110(driver);

	}

}

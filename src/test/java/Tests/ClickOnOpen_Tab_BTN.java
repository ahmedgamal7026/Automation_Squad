package Tests;

import org.testng.annotations.Test;

import Pages.Courses_LetsKodeIt;

public class ClickOnOpen_Tab_BTN extends TestBase{
	
	
	@Test
	public void ClickOnOpen_Tab_BUtton() {
		
		
		
		Courses_LetsKodeIt CL= new Courses_LetsKodeIt(driver);
		CL.ClickOnOpen_Tab_Button(driver);
	}

}

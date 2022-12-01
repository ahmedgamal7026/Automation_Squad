package Tests;

import org.testng.annotations.Test;

import Pages.Open_New_Twitter_WindowPage;

public class Twitter_New_Window extends TestBase{
	
	
	@Test
	public void Open_Twitter_New_Window()  {
		
		
		Open_New_Twitter_WindowPage TP = new Open_New_Twitter_WindowPage(driver);
		TP.Open_Twitter_Window(driver);
		
	}

}

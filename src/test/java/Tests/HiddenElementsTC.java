package Tests;

import org.testng.annotations.Test;

import Pages.Courses_LetsKodeIt;

public class HiddenElementsTC extends TestBase{
	
	
	@Test
	public void Handling_Hidden_Elements() throws InterruptedException {
		
		Courses_LetsKodeIt Co= new Courses_LetsKodeIt(driver);
		Co.Handling_Hidden_elemen(driver);
	}

}

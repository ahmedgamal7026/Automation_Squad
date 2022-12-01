package Tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Pages.Broken_LinksPage;

public class Broken_LinksTC2 extends TestBase{
	
	
	Broken_LinksPage BL;
	
	
	@Test
	public void CheckingBrokenLinks() throws MalformedURLException, IOException {
		BL = new Broken_LinksPage(driver);
		BL.CheckingBrokenLinks("https://www.demoblaze.com/");
		
		
	}

}

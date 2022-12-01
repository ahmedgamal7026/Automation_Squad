package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AmazonPage;

public class LocalizationTo_English extends TestBase{

	
	AmazonPage AP;
	
	@Test
	public void Loc_To_English() {
		
		AP = new AmazonPage(driver);
		AP.Loc_To_English();
		
		Assert.assertTrue(driver.getTitle().contains("Change Language & Currency Settings"));
		
		

	}
}

package Tests;

import org.testng.annotations.Test;

import Pages.SaucedemoPage;

public class Find_Second_highest_price extends TestBase{
	
	SaucedemoPage SD;
	@Test
	public void Find2ndHighestPrice() {
		
		SD = new SaucedemoPage(driver);
		SD.Login(driver);
		SD.GetAllPrices(driver);
	}

}

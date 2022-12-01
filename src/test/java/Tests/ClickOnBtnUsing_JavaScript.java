package Tests;

import org.testng.annotations.Test;

import Pages.AmazonPage;

public class ClickOnBtnUsing_JavaScript extends TestBase{
	
	
	@Test
	public void ClickOnHello_signIN_Btn_With_JS() {
		
		AmazonPage AP = new AmazonPage(driver);
		AP.ClickBtnWith_JavaScript();
		
		
	}

}

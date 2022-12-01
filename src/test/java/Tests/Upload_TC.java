package Tests;

import org.testng.annotations.Test;

import Pages.UploadPage;

public class Upload_TC extends TestBase{
	
	
	@Test
	public void Uploading()  {
		
		
		UploadPage up = new UploadPage(driver);
		up.Upload_Function(driver);
		
	}

}

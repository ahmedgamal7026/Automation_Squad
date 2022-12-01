package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintTitleUsing_JavaScript extends TestBase {

	@Test
	public void PrintWith_JS() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String Title = (String) js.executeScript("return document.title");

		Assert.assertEquals(Title, "OrangeHRM");

		System.out.println(Title);
	}

}

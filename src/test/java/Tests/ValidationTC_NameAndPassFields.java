package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.OrangeHRM_LoginPage;

public class ValidationTC_NameAndPassFields extends TestBase{



	@DataProvider(name = "data")
	public Object[][] UserData() throws IOException {

		ExcelReader ER = new ExcelReader();
		return ER.getExcelData(1);

	}
	@Test(dataProvider = "data")
	public void inValidLogin(String Username, String Password) throws InterruptedException {


		OrangeHRM_LoginPage LP= new OrangeHRM_LoginPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LP.inValid_Login(driver,Username,Password);

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Assert.assertTrue(LP.LoginButton.isDisplayed());



		driver.navigate().refresh();


	}
}

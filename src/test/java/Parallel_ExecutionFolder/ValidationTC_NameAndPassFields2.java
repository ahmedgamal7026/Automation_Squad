package Parallel_ExecutionFolder;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Data.ExcelReader2;
import Pages.OrangeHRM_LoginPage;

public class ValidationTC_NameAndPassFields2 extends TestBase_For_Parallel_Execution_TC{



	@DataProvider(name = "data1")
	public Object[][] UserData() throws IOException {

		ExcelReader2 ER = new ExcelReader2();
		return ER.getExcelData(0);

	}
	@Test(dataProvider = "data1")
	public void inValidLogin(String Username, String Password) throws InterruptedException {


		OrangeHRM_LoginPage LP= new OrangeHRM_LoginPage(getDriver());
		getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LP.inValid_Login(getDriver(),Username,Password);

		String URL = getDriver().getCurrentUrl();
		Assert.assertEquals(URL, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Assert.assertTrue(LP.LoginButton.isDisplayed());



		getDriver().navigate().refresh();


	}
}

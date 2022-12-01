package Parallel_ExecutionFolder;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.OrangeHRM_Home_Page;
import Pages.OrangeHRM_LoginPage;


public class Valid_LoginTC2 extends TestBase_For_Parallel_Execution_TC {

    OrangeHRM_LoginPage LP;
    OrangeHRM_Home_Page HP;
   

    @DataProvider(name = "data")
    public Object[][] UserData() throws IOException {

        ExcelReader ER = new ExcelReader();
        return ER.getExcelData(0);

    }

    @Test(dataProvider = "data")
    public void ValidLogin(String Username, String Password) throws InterruptedException, IOException {

    	getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LP = new OrangeHRM_LoginPage(getDriver());
        LP.Valid_Login(getDriver(), Username, Password);

        HP = new OrangeHRM_Home_Page(getDriver());

//        HP.Logout(driver);
//        Assert.assertTrue(LP.LoginButton.isDisplayed());
//        Thread.sleep(3000);


		/*File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		File DestFile=new File("C:\\Users\\aothman\\eclipse-workspace\\Orange_LoginPage\\Screenshots");*/


//        ScreenShotClass SC = new ScreenShotClass();
//        ScreenShotClass.takeScreenShot(driver, "ValidLogin");
        


    }

}




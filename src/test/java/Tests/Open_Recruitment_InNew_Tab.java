	package Tests;


import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.OrangeHRM_Home_Page;
import Pages.OrangeHRM_LoginPage;


public class Open_Recruitment_InNew_Tab extends TestBase {

    OrangeHRM_LoginPage LP;
    OrangeHRM_Home_Page HP;
   

    @DataProvider(name = "data")
    public Object[][] UserData() throws IOException {

        ExcelReader ER = new ExcelReader();
        return ER.getExcelData(0);

    }

    @Test(dataProvider = "data")
    public void Open_Recruitment_Page_In_New_Tab(String Username, String Password) throws InterruptedException, IOException, AWTException {

    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    	
    	
        LP = new OrangeHRM_LoginPage(driver);
        LP.Valid_Login(driver, Username, Password);

        HP = new OrangeHRM_Home_Page(driver);
        
        
        HP.Open_Recruitment_Page(driver);
        HP.Open_In_New_Tab(driver);
        

    }

}




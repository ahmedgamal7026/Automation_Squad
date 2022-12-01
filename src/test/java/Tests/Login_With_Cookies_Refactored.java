package Tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.OrangeHRM_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_With_Cookies_Refactored extends TestBase{

	OrangeHRM_LoginPage LP;



	@DataProvider(name = "data")
	public Object[][] UserData() throws IOException {

		ExcelReader ER = new ExcelReader();
		return ER.getExcelData(0);

	}

	@Test(priority = 0, dataProvider = "data")
	public void First_Login(String Username, String Password) throws InterruptedException, IOException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		LP = new OrangeHRM_LoginPage(driver);
		LP.Valid_Login(driver, Username, Password);

		// Create a file to store Login Information
		File fileTest = new File("Cookies.data");
		try{
			// Delete old file if already exists
			fileTest.delete();
			fileTest.createNewFile();
			FileWriter file = new FileWriter(fileTest);
			BufferedWriter Bwritecookie = new BufferedWriter(file); //Getting the cookie information
			for(Cookie ck : driver.manage().getCookies()) {
				Bwritecookie.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
				Bwritecookie.newLine();
			}
			Bwritecookie.close();
			file.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}







	@Test(priority = 1,dependsOnMethods = ("First_Login"))
	public void Login_With_cookies() throws InterruptedException 
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();


		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


		try{

			File file = new File("Cookies.data");
			FileReader fileReader = new FileReader(file); 
			BufferedReader Buffreader = new BufferedReader(fileReader); 
			String strline;
			while((strline=Buffreader.readLine())!=null){
				StringTokenizer token = new StringTokenizer(strline,";");
				while(token.hasMoreTokens()){
					String name = token.nextToken(); String value = token.nextToken(); String domain = token.nextToken(); String path = token.nextToken(); Date expiry = null; String val; if(!(val=token.nextToken()).equals("null"))
					{
						expiry = new Date(val); }
					Boolean isSecure = new Boolean(token.nextToken()).
							booleanValue();
					Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure); System.out.println(ck); 
					driver.manage().deleteAllCookies(); 
					driver.manage().addCookie(ck); // This will add the stored cookie to your current session }
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace(); }

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
		driver.navigate().refresh(); Thread.sleep(3000); }

}





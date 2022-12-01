package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver;
	

	
	@BeforeMethod
	@Parameters({"Browser"})
	public void Setup(@Optional ("Chrome")String BrowserName)
	
	{
		

		
		if (BrowserName.equalsIgnoreCase("Chrome")) 
		{
//			String chromepath = System.getProperty("user.dir") + "\\New_drivers\\chromedriver.exe";
//			System.setProperty("webdriver.chrome.driver",chromepath );
			
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
			
		} 
		
		else
		{
			String Firefoxpath = System.getProperty("user.dir") + "\\New_drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",Firefoxpath );
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		}
		
		
//		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().window().maximize();
		
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		
//		driver.quit();
	}

}

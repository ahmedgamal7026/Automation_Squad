package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.AmazonPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalizationTo_Spanish {

	AmazonPage AP;


	public WebDriver driver;



	@BeforeMethod
	@Parameters({"Browser"})
	public void Setup(@Optional ("Chrome")String BrowserName)

	{
		if (BrowserName.equalsIgnoreCase("Chrome")) 
		{
			//			String chromepath = System.getProperty("user.dir") + "\\New_drivers\\chromedriver.exe";
			//			System.setProperty("webdriver.chrome.driver",chromepath );

			WebDriverManager.chromedriver().setup(); 
			//			driver = new ChromeDriver();


			ChromeOptions options = new ChromeOptions();
			options.addArguments("--lang=es");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		}
	} 


	@Test

	public void Loc_To_Spanish() {

		AP = new AmazonPage(driver);
		AP.Loc_To_Spanish(driver);




	}

}


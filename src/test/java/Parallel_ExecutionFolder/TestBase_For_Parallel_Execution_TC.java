package Parallel_ExecutionFolder;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase_For_Parallel_Execution_TC {

	protected static ThreadLocal <WebDriver> driver= new ThreadLocal<WebDriver>() ;

	//get thread-safe driver
	public static WebDriver getDriver() {

		return driver.get();
	}





	@BeforeTest
	public void Setup(){

		WebDriverManager.chromedriver().setup(); 
		driver.set(new ChromeDriver());


		//set driver
		getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}




	@AfterTest
	public void tearDown(){
		getDriver().quit();
		driver.remove();
	}



}

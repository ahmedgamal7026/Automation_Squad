package Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsWithTestNG {

	WebDriver driver;
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest ET;

	@BeforeTest
	public void Setup()

	{
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
	}

	@Test
	public void Test1() {

		 ET = extent.createTest("Login Function");

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.name("username")).sendKeys("Admin");
		ET.log(Status.INFO, "USerName is inserted");

		driver.findElement(By.name("password")).sendKeys("admin123");
		ET.log(Status.INFO, "Password is inserted");

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		ET.pass("User is loggedin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}



	@Test
	public void Test2() throws IOException {

		ExtentTest ET = extent.createTest("Login Function");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.name("username")).sendKeys("Admin");
		ET.log(Status.INFO, "USerName is inserted");

		driver.findElement(By.name("password")).sendKeys("admin12");
		ET.log(Status.INFO, "Wrong Password is inserted");
		ET.addScreenCaptureFromPath("ScreenShot.png");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		ET.fail("User is not Able to login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@AfterTest
	public void TearDown() {
		extent.flush();
		driver.quit();
	}

}

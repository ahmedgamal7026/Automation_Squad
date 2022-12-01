package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessChrome {

	@Test
	public void HeadlessTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aothman\\eclipse-workspace\\Challenges\\New_drivers\\chromedriver1.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("Headless");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwivq8LC3b_7AhVCUaQEHfl-DZcQPAgI");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement Srch = driver.findElement
				(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		WebElement Btn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));

		Srch.sendKeys("Amazon");
		Btn.sendKeys(Keys.ENTER);
	}

}

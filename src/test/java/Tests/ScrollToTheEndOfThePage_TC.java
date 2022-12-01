package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollToTheEndOfThePage_TC extends TestBase {


	@Test
	public void ScrollingToEndOfThePage() throws InterruptedException {


		driver.get("https://codebase.show/projects/realworld");
//		WebDriverWait w = new WebDriverWait(driver,5);
//		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create'])[1]/following::a[1]"))));

		
		
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,7000)");
	}

}

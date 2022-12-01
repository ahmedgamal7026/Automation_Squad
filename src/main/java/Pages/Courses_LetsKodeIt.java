package Pages;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Courses_LetsKodeIt extends PageBase{

	public Courses_LetsKodeIt(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//*[@id=\"course-list\"]/div[1]/div")
	WebElement JS_For_BeginnersButton;

	@FindBy(xpath="//*[@id=\"zen_cs_desc_with_promo_dynamic\"]/div/div/div[2]/div[3]/button")
	WebElement EnrollButton;

	@FindBy(id="opentab")
	WebElement Open_Tab_Button;


	public void Click_On_JS_Button(WebDriver driver) {


		JS_For_BeginnersButton.click();


	}

	public void Checking_Enroll_Button(WebDriver driver) {


		System.out.println(EnrollButton.getText());
		Assert.assertTrue(EnrollButton.isDisplayed());

	}


	public void ClickOnOpen_Tab_Button(WebDriver driver) {

		driver.get("https://courses.letskodeit.com/practice");

		Open_Tab_Button.click();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		System.out.println("_________________________________________");

		System.out.println(driver.getTitle());
		System.out.println("_________________________________________");

	}
	
	public void Challenge110(WebDriver driver) throws AWTException {

		driver.get("https://courses.letskodeit.com/practice");
		
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		
		Actions action = new Actions(driver); 
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); //switching to the New Window.
				
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getTitle());

		

	}
	
	@FindBy(id="hide-textbox")
	WebElement Hide_Button;
	
	@FindBy(id="show-textbox")
	WebElement Show_Button;
	
	@FindBy(id="displayed-text")
	WebElement Text_Box;
	

	public void Handling_Hidden_elemen(WebDriver driver) throws InterruptedException  {

		driver.get("https://courses.letskodeit.com/practice");
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(2));
		w1.until(ExpectedConditions.visibilityOf(Text_Box));
		
		
		Hide_Button.click();
		Assert.assertFalse(Text_Box.isDisplayed());
		Show_Button.click();
		Assert.assertTrue(Text_Box.isDisplayed());

	

		

	}
	
	@FindBy(xpath="//*[@id=\"course-list\"]/div[4]/div")
	WebElement AdvancedCourse;
	
	
	public void ScrollToAdvancedCourse() throws InterruptedException{
		
//		WebDriverWait w = new WebDriverWait(driver,5);
//		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create'])[1]/following::a[1]"))));

		
		driver.get("https://courses.letskodeit.com/practice");
		Thread.sleep(500); 

		
		driver.switchTo().frame("courses-iframe");
		
		
		Actions ac = new Actions(driver);
		ac.moveToElement(AdvancedCourse).build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AdvancedCourse);
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,500)");
		
		
	}
	


}

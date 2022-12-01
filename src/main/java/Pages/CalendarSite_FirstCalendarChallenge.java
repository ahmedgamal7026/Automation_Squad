package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarSite_FirstCalendarChallenge extends PageBase{
	
	
	public CalendarSite_FirstCalendarChallenge(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="day")
	WebElement Calendar_InButton;
	
	
	
	public void Handling_Calendar() {
		
		driver.get("https://trytestingthis.netlify.app/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		w1.until(ExpectedConditions.elementToBeClickable(Calendar_InButton));
		
		Actions Ac = new Actions(driver);
		Ac.moveToElement(Calendar_InButton).build().perform();
		Calendar_InButton.sendKeys("10/26/2023");
		

}}

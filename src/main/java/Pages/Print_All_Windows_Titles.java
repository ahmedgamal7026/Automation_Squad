package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Print_All_Windows_Titles extends PageBase{

	public Print_All_Windows_Titles(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(partialLinkText ="Follow On Twitter")
	WebElement TwitterButton;
	
	@FindBy(xpath ="//*[@id=\"__next\"]/section[3]/div/div/div[2]/div[1]/a[2]")
	WebElement FaceBookButton;
	
	@FindBy(id ="followboth")
	WebElement Twitter_And_FaceBook_Button;
	
	@FindBy(partialLinkText ="Follow All")
	WebElement Follow_All_Button;
	
	  
	
	
	public void Print_All_Titles(WebDriver driver) throws InterruptedException  {
		
		
		
		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,350)");
		
		Assert.assertTrue(TwitterButton.isDisplayed());
		Assert.assertTrue(FaceBookButton.isDisplayed());
		Assert.assertTrue(Twitter_And_FaceBook_Button.isDisplayed());
		Assert.assertTrue(Follow_All_Button.isDisplayed());

		
		
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		Actions ac1= new Actions(driver);
		ac1.moveToElement(TwitterButton).click().perform();
		driver.switchTo().window(newTb.get(0));	
		ac1.moveToElement(FaceBookButton).click().perform();
		driver.switchTo().window(newTb.get(0));	
		ac1.moveToElement(Twitter_And_FaceBook_Button).click().perform();
		driver.switchTo().window(newTb.get(0));	
		ac1.moveToElement(Follow_All_Button).click().perform();
		driver.switchTo().window(newTb.get(0));	
			
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		Set<String> Alltabs = driver.getWindowHandles();
		// Navigating and getting title without stream APIs
		for(String tab : Alltabs)
		{
			String title = driver.switchTo().window(tab).getTitle();
			System.out.println(title);
			System.out.println("====================OOOOOOOOOOOOOOOOOO==============");

		}
		

		
	}
	
	
	

}

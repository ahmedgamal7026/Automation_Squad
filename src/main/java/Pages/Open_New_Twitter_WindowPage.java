package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Open_New_Twitter_WindowPage extends PageBase{

	public Open_New_Twitter_WindowPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(partialLinkText ="Follow On Twitter")
	WebElement TwitterButton;
	
	
	@FindBy(xpath ="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[3]/div/div/div/div/div[1]/div[2]")
	WebElement LambdaTest_Followbtn;
	
	public void Open_Twitter_Window(WebDriver driver)  {
		
		
		
		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");



		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		Actions ac= new Actions(driver);
		ac.moveToElement(TwitterButton).build().perform();
		
		TwitterButton.click();
		
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));


		driver.manage().window().maximize();

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		Assert.assertTrue(LambdaTest_Followbtn.isDisplayed());
		
	}
	
	
	

}

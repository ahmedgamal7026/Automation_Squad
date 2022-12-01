package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UploadPage extends PageBase{

	public UploadPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//*[@id=\"file-upload\"]")
	WebElement UploadField;
	public void Upload_Function(WebDriver driver)  {
		
		
		
		driver.get("https://www.monsterindia.com/seeker/registration");


//		WebDriverWait w1= new WebDriverWait(driver, 5);
//		w1.until(ExpectedConditions.visibilityOf(UploadField));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		Actions ac= new Actions(driver);
		ac.moveToElement(UploadField).build().perform();
		
		UploadField.sendKeys("C:\\Users\\aothman\\Desktop\\To be uploaded.txt");
		
	}
	
	
	

}

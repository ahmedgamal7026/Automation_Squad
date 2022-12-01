package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class RightClickPage extends PageBase {

	
	
	public RightClickPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//*[@id=\"authentication\"]/span")
	WebElement RightClick_ME_Button;
	
	@FindBy(xpath="	//*[@id=\"authentication\"]/ul/li[3]")
	WebElement Copy_BTN;
	



	public void Right_Click_On_Button_Function(WebDriver driver) {
		
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(RightClick_ME_Button)); 
		
		Actions ac = new Actions(driver);
		ac.moveToElement(RightClick_ME_Button).contextClick().perform();
		
		
		
		ac.contextClick(Copy_BTN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();

		wait.until(ExpectedConditions.alertIsPresent()); 
		Alert alert=driver.switchTo().alert();
		String textCopy = alert.getText();
		System.out.println(textCopy);
		Assert.assertEquals(textCopy, "clicked: copy");

		
	
		
		
	}

}


package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Double_Click_Page extends PageBase{

	
	
	public Double_Click_Page(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//div")
	WebElement TheColoured_Block;


	public void Click_On_Coloured_Block(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2600)");	
		
		driver.switchTo().frame(0);
		Actions ac = new Actions(driver);
		ac.moveToElement(TheColoured_Block);
		ac.doubleClick(TheColoured_Block).perform();
		
	}

}

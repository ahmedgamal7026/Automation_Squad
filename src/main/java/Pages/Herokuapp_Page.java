package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Herokuapp_Page extends PageBase{

	  public Herokuapp_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void infiniteScroll() throws InterruptedException
	     {
			 
			 driver.get("https://the-internet.herokuapp.com/infinite_scroll");
//	         JavascriptExecutor jse = (JavascriptExecutor)driver;
	         
	         while(true) {
		         ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	         }
	     }
}

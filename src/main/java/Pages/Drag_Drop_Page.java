package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Drag_Drop_Page extends PageBase {

	public Drag_Drop_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "draggable")
	WebElement draggableElement;

	@FindBy(id = "droppable")
	WebElement DestinationElement;

	
	@FindBy(xpath = "//*[@id=\"content\"]/iframe")
	WebElement RequiredFrame;
	

	public void DragAndDrop(){

		driver.get("https://jqueryui.com/droppable/");

		driver.switchTo().frame(0);

//		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(3));
//		w1.until(ExpectedConditions.visibilityOf(RequiredFrame));

		
		Actions ac = new Actions(driver);
		ac.moveToElement(draggableElement).click().build().perform();
		ac.dragAndDrop(draggableElement, DestinationElement).build().perform();



	}

}

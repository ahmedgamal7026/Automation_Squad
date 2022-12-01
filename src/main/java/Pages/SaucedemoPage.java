package Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SaucedemoPage extends PageBase {

	public SaucedemoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "user-name")
	WebElement UserName;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "login-button")
	WebElement LoginButton;

	//	
	//	
	//	List<Double> input2;
	//	List<String> ModifiedNumbers;

	public void Login(WebDriver driver) {

		driver.get("https://www.saucedemo.com/");
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,2600)");

		Actions ac = new Actions(driver);
		ac.moveToElement(UserName);
		UserName.sendKeys("standard_user");
		Password.sendKeys("secret_sauce	");
		LoginButton.click();

	}

	public void GetAllPrices(WebDriver driver) {

		List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
		System.out.println(prices.size());
		String text;
		String newText;
		Float TheNumber;
		List<Float> input = new ArrayList<>();

		for (int i = 0; i < prices.size(); i++) {

			text = prices.get(i).getText();
			newText = text.replace("$", "");
			TheNumber = Float.parseFloat(newText);
			input.add(TheNumber);
			System.out.println(TheNumber);
		}

		Collections.sort(input);
		System.out.println("##########################################");
		System.out.print(" The Second Heighest price is ");
		System.out.println(input.get(input.size() - 2));
		System.out.println("##########################################");

	}

}

package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Recruitment_Page extends PageBase {

	public Recruitment_Page(WebDriver driver) {
		super(driver);
	}

	

	@FindBy(partialLinkText ="Vacancies")
	WebElement VacanciesTab;

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div")
	WebElement JobField_In_Recruitment_Screen;
	
	
	public void Open_Vacancies_Tab(WebDriver driver) {
		
		
		WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(3));
		w2.until(ExpectedConditions.elementToBeClickable(JobField_In_Recruitment_Screen));
		
		Assert.assertTrue(VacanciesTab.isDisplayed());
		System.out.println(VacanciesTab.getText());
		
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
			
		Actions ac = new Actions(driver);
		ac.moveToElement(VacanciesTab).click().perform();
		
		
		
		
		
	}
}

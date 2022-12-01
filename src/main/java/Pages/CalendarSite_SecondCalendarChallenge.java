package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarSite_SecondCalendarChallenge extends PageBase{


	public CalendarSite_SecondCalendarChallenge(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="datepicker")
	WebElement Calendar_Button;
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")
	WebElement Months_DDL;


	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")
	WebElement Years_DDL;

	//@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[7]")
	//WebElement Fifth_Day;

	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table")
	WebElement Days_Table;



	public void Handling_Calendar() {

		driver.get("https://jqueryui.com/resources/demos/datepicker/dropdown-month-year.html");


		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		w1.until(ExpectedConditions.elementToBeClickable(Calendar_Button));

		Actions Ac = new Actions(driver);
		Ac.moveToElement(Calendar_Button).click().perform();



		Ac.moveToElement(Months_DDL).build().perform();
		Select s1 = new Select(Months_DDL);
		s1.selectByValue("5");

		Ac.moveToElement(Years_DDL).build().perform();
		Select s2 = new Select(Years_DDL);
		s2.selectByVisibleText("2023");


		ArrayList<WebElement> rows = (ArrayList<WebElement>) Days_Table.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				if (cell.getText().equals("5")) {
					
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
					Actions Ac2 = new Actions(driver);
					WebElement Required_day= driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[2]"));
					
					
					
					Ac2.moveToElement(Required_day).click().perform();
				}
			}
		}














	}}

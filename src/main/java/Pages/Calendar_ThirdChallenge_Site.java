package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Calendar_ThirdChallenge_Site extends PageBase{


//	public String required_year = "2023";
//	public String required_Month = "Dec";
//	public String required_Day = "25";

	public Calendar_ThirdChallenge_Site(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="datepicker")
	WebElement Calendar;

	@FindBy(xpath="/html/body/div[2]/div[1]/table/thead/tr[1]/th[2]")
	WebElement MiddleButton;

	@FindBy(xpath="/html/body/div[2]/div[2]/table/thead/tr/th[3]")
	WebElement NextButton;

	@FindBy(xpath="/html/body/div[2]/div[2]/table/thead/tr/th[1]")
	WebElement prevButton;

	@FindBy(xpath="/html/body/div[2]/div[3]/table")
	WebElement Years_Table;

	public void Handling_Calendar(String Y,String M, String D) {

		WebElement DaySelection = null ;
		 String required_year = Y;
		 String required_Month = M;
		 String required_Day = D;

		driver.get("https://webdriveruniversity.com/Datepicker/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		Calendar.click();
		MiddleButton.click();
		WebElement Current_Year= driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr/th[2]"));
		int Displayed_Year =  Integer. parseInt(Current_Year.getText());
		System.out.println(Displayed_Year);




		while (!Integer.valueOf(Displayed_Year).equals(Integer.valueOf(required_year))) {

			if (Integer.valueOf(Displayed_Year) < Integer.valueOf(required_year)) {

				//press on the next button with the value of the current year - required year


				int LoopCount =Integer.valueOf( required_year)-Integer.valueOf( Displayed_Year);
				for (int i = 0; i < LoopCount; i++) {
					NextButton.click();
					System.out.println("Next Button is Used");

					Displayed_Year++;
					System.out.println(Displayed_Year);


				}
			}

			else if (Integer.valueOf(Displayed_Year) > Integer.valueOf(required_year))  {

				//press on the prev button with the value of the current year - required year
				int LoopCount =Integer.valueOf( Displayed_Year)-Integer.valueOf( required_year);
				for (int i = 0; i < LoopCount; i++) {
					prevButton.click();
					System.out.println("prev Button is Used");
					Displayed_Year--;
					System.out.println(Displayed_Year);

				}

			}

		}

		if (Integer.valueOf(Displayed_Year).equals(Integer.valueOf(required_year))) {
			System.out.println("We Reached The Required Year");
			List<WebElement> Months = driver.findElements(By.className("month"));
			for (int i = 0; i < Months.size(); i++) 
			{
				if (required_Month.equalsIgnoreCase(Months.get(i).getText())) {
					Months.get(i).click();


				}
			}

			List<WebElement> Days = driver.findElements(By.className("day"));

			for (int i = 0; i < Days.size(); i++) 
			{

				if (required_Day.equalsIgnoreCase(Days.get(i).getText())) {
					DaySelection = Days.get(i);
					System.out.println(Days.get(i).getText());

				}
			}
			DaySelection.click();
		}


	}

}




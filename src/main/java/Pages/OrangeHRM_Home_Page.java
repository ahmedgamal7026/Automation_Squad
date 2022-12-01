package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrangeHRM_Home_Page extends  PageBase {

	public OrangeHRM_Home_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
	WebElement AddNewEmpButton;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li")
	WebElement UserList;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")
	WebElement Logoutbutton;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	WebElement UsernameField;


	@FindBy(xpath="xpath=//div[@id='app']/div/div/aside/nav/div[2]/ul/li[5]/a/span")
	WebElement RecruitmentPageButton;
	

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]")
	WebElement VacanciesTab;

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div")
	WebElement JobField_In_Recruitment_Screen;




	public void Check_Existence_of_AddNewEmp_Button(WebDriver driver) throws InterruptedException {


		Thread.sleep(2000);
		Assert.assertTrue(AddNewEmpButton.isDisplayed());

	}


	public void Logout(WebDriver driver) throws InterruptedException {


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		UserList.click();
		Logoutbutton.click();
		WebDriverWait w1= new WebDriverWait(driver, Duration.ofSeconds(5));
		w1.until(ExpectedConditions.elementToBeClickable(UsernameField));


	}



	public void Open_Recruitment_Page(WebDriver driver) throws InterruptedException, AWTException {


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w1= new WebDriverWait(driver, Duration.ofSeconds(5));
		w1.until(ExpectedConditions.visibilityOf(UserList));

		Robot robot = null;
		robot = new Robot();

		String CurrentElement="";

		while (!CurrentElement.equals("Recruitment")) {
			CurrentElement = driver.switchTo().activeElement().getText();
			if (!CurrentElement.equals("Recruitment")) {

				robot.keyPress(KeyEvent.VK_TAB);
				System.out.println(driver.switchTo().activeElement().getText());

				w1.until(ExpectedConditions.visibilityOf(UserList));
			}
			else 
			{
				System.out.println("we reached the required element, will press enter now");

			
				Actions ac= new Actions(driver);
				ac.moveToElement(driver.switchTo().activeElement()).click().perform();
				WebDriverWait w2= new WebDriverWait(driver, Duration.ofSeconds(5));
				w2.until(ExpectedConditions.elementToBeClickable(JobField_In_Recruitment_Screen));


			}
		}	
		if (!driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates")) {

			Actions ac= new Actions(driver);
			ac.moveToElement(driver.switchTo().activeElement()).click().perform();
			
			WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(3));
			w2.until(ExpectedConditions.elementToBeClickable(JobField_In_Recruitment_Screen));
		}

		
		
	}
		public void Open_In_New_Tab(WebDriver driver) throws AWTException {
			
			Robot robot = null;
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL); 
			robot.keyPress(KeyEvent.VK_L);

			robot.keyRelease(KeyEvent.VK_CONTROL); 
			robot.keyRelease(KeyEvent.VK_L); 



			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);

			robot.keyRelease(KeyEvent.VK_CONTROL); 
			robot.keyRelease(KeyEvent.VK_C); 

			robot.keyPress(KeyEvent.VK_CONTROL); 
			robot.keyPress(KeyEvent.VK_T);

			robot.keyRelease(KeyEvent.VK_CONTROL); 
			robot.keyRelease(KeyEvent.VK_T);

			robot.keyPress(KeyEvent.VK_CONTROL); 
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL); 
			robot.keyRelease(KeyEvent.VK_V); 



			robot.keyPress(KeyEvent.VK_ENTER);

		}
		
		
		public void Hover_Over_Recruitment(WebDriver driver) throws InterruptedException, AWTException {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(3));
			w1.until(ExpectedConditions.visibilityOf(UserList));

			Robot robot = null;
			robot = new Robot();

			String CurrentElement="";

			while (!CurrentElement.equals("Recruitment")) {
				CurrentElement = driver.switchTo().activeElement().getText();
				if (!CurrentElement.equals("Recruitment")) {

					robot.keyPress(KeyEvent.VK_TAB);
					System.out.println(driver.switchTo().activeElement().getText());

					w1.until(ExpectedConditions.visibilityOf(UserList));
				}
				else 
				{
					System.out.println("we reached the required Element to Hover on");

				


				}
			}	
		

		
	}
		}

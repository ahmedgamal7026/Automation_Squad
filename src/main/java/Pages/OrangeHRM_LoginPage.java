package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrangeHRM_LoginPage extends PageBase{

	public OrangeHRM_LoginPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	WebElement UsernameField;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	WebElement PasswordField;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	public WebElement LoginButton;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
	WebElement ValidationMessage;


	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[1]/a[2]")
	WebElement FaceBookButton;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[1]/a[1]")
	WebElement LinkedinButton;

	@FindBy(xpath  = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")
	WebElement Forgot_your_password;

	@FindBy(xpath  = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")
	WebElement RequiredValidationMessage;

	
	@FindBy(xpath  = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[2]/a")
	WebElement OrangeSiteURL;
	


	public void Valid_Login(WebDriver driver,String UserName,String Password) throws InterruptedException {


//		WebDriverWait w1= new WebDriverWait(driver, 5);
//		w1.until(ExpectedConditions.elementToBeClickable(UsernameField));
		Thread.sleep(5000);
		
		UsernameField.sendKeys(UserName);
		PasswordField.sendKeys(Password);

		LoginButton.click();

		//		Assertion on URL
		String CurrentURL = driver.getCurrentUrl();
		System.out.println(CurrentURL);
		Assert.assertEquals(CurrentURL, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


	}



	public void inValid_Login(WebDriver driver,String UserName,String Password) throws InterruptedException {


//		WebDriverWait w1= new WebDriverWait(driver, 5);
//		w1.until(ExpectedConditions.elementToBeClickable(UsernameField));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		UsernameField.sendKeys(UserName);
		PasswordField.sendKeys(Password);
		
//		WebDriverWait w2= new WebDriverWait(driver, 5);
//		w2.until(ExpectedConditions.elementToBeClickable(LoginButton));

		LoginButton.click();
	




//
//		if (UserName.isEmpty()&&Password.isEmpty()) {
//
//			Assert.assertTrue(RequiredValidationMessage.isDisplayed());
//
//			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//			driver.navigate().refresh();
//		}
//		
//		else {
//			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//
//			
//			WebDriverWait w1 = new WebDriverWait(driver, 5);
//			w1.until(ExpectedConditions.visibilityOf(ValidationMessage));
//			Assert.assertTrue(ValidationMessage.getText().contains("Invalid credentials"));
//
//
//		}
		driver.navigate().refresh();
//		UsernameField.clear();
//		PasswordField.clear();
		Thread.sleep(2000);

	}


	public void Validating_FaceBookButton_Functionlality(WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		

		WebDriverWait w2= new WebDriverWait(driver, Duration.ofSeconds(3));
		w2.until(ExpectedConditions.elementToBeClickable(FaceBookButton));
		FaceBookButton.click();




	}





	public void Validating_LinkedinButton_Functionlality(WebDriver driver) {


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");	

		WebDriverWait w2= new WebDriverWait(driver, Duration.ofSeconds(3));
		w2.until(ExpectedConditions.elementToBeClickable(LinkedinButton));
		LinkedinButton.click();





	}


	public void Validating_ForgotYourPassButton_Functionlality(WebDriver driver) {


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");	

		WebDriverWait w2= new WebDriverWait(driver, Duration.ofSeconds(3));
		w2.until(ExpectedConditions.elementToBeClickable(Forgot_your_password));
		Forgot_your_password.click();

	}
	
	public void Validating_OrangeHRMSITE_HyperLink(WebDriver driver) throws InterruptedException {


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");	
		
		
		Thread.sleep(3000);
		OrangeSiteURL.click();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		

	}



}

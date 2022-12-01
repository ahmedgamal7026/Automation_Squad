package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmazonPage extends PageBase {

	public AmazonPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "nav-link-accountList")
	WebElement Hello_SignInButton;

	@FindBy(xpath = "//*[@id=\"nav-al-your-account\"]/a[1]")
	WebElement AccountButton;

	public void ClickBtnWith_JavaScript() {

		driver.get("https://www.amazon.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//		Print Page Title 

		String Script = "return document.title;";
		String Title = (String) js.executeScript(Script);
		System.out.println(Title);

		//		print the button Text

		//		WebElement ConfigMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul"));

		//		Click on a Button with JAVA SCRIPT

		//		js.executeScript("document.getElementById('nav-link-accountList').click();");

		// Or

		js.executeScript("arguments[0].click();", AccountButton);

	}


	@FindBy(id = "icp-nav-flyout")
	WebElement LanguagesTab;

	@FindBy(xpath = "//*[@id=\"icp-language-settings\"]/div[2]")
	WebElement English_Button;


	@FindBy(xpath = "//*[@id=\"icp-language-settings\"]/div[5]")
	WebElement Deutsch_Button;


	@FindBy(xpath = "//*[@id=\"icp-language-settings\"]/div[3]")
	WebElement Spanish_Button;


	@FindBy(id = "icp-save-button")
	WebElement Save_Button;

	@FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/span")
	WebElement TheDisplayedWordUnderHello;

	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement TheDisplayedWordHello;


	public void Loc_To_English() {

		driver.get("https://www.amazon.com/");
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		w1.until(ExpectedConditions.elementToBeClickable(LanguagesTab));
		LanguagesTab.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		English_Button.click();
		Save_Button.click();
		w1.until(ExpectedConditions.elementToBeClickable(LanguagesTab));
		String Title =driver.getTitle() ;
		System.out.println("the Current Page Title is : " + Title);
		String HelloButton = Hello_SignInButton.getText();

		Assert.assertTrue(HelloButton.contains("Hello, sign in"));
		Assert.assertTrue(HelloButton.contains("Account & Lists"));





	}

	public void Loc_To_Deutsch(WebDriver driver) throws InterruptedException {

		driver.get("https://www.amazon.com/");
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		w1.until(ExpectedConditions.elementToBeClickable(LanguagesTab));
		
		String Title = driver.getTitle();
		System.out.println("the Current Page Title is : " + Title);


		String Hello = TheDisplayedWordHello.getText();

		String UnderHello =TheDisplayedWordUnderHello.getText();
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println(Hello);
		System.out.println(UnderHello);


				Assert.assertTrue(Hello.contains("Hallo, anmelden"));
				Assert.assertTrue(UnderHello.contains("Konto und Listen"));


	}

	public void Loc_To_Spanish(WebDriver driver) {
		driver.get("https://www.amazon.com/");
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		w1.until(ExpectedConditions.elementToBeClickable(LanguagesTab));
		
		
		String Title = driver.getTitle();
		System.out.println("the Current Page Title is : " + Title);
		
		
		System.out.println(TheDisplayedWordUnderHello.getText());
		System.out.println(TheDisplayedWordHello.getText());

		Assert.assertTrue(Title.contains("Gasta menos. Sonríe más"));

		Assert.assertTrue(TheDisplayedWordUnderHello.getText().contains("Cuenta y Listas"));
		Assert.assertTrue(TheDisplayedWordHello.getText().contains("Hola, Identifícate"));


	}
}

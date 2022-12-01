package steps;

import java.time.Duration;

import Pages.OrangeHRM_Home_Page;
import Pages.OrangeHRM_LoginPage;
import Tests.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login extends TestBase{

	OrangeHRM_Home_Page HP;
	OrangeHRM_LoginPage LP;

	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {

//		WebDriverManager.chromedriver().setup(); 
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		TestBase.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		

	}

	@When("the user fills the username and password and clicks on the login button")
	public void the_user_fills_the_username_and_password_and_clicks_on_the_login_button(DataTable whendata) throws InterruptedException {

		LP = new OrangeHRM_LoginPage(driver);
		LP.Valid_Login(driver,whendata.cell(0, 0) , whendata.cell(0, 1));

	}
	@Then("user is navigated to the Home Page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {


		HP = new OrangeHRM_Home_Page(driver);
		HP.Logout(driver);		
	}

}

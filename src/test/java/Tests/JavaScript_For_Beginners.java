package Tests;

import java.time.Duration;

import org.testng.annotations.Test;

import Pages.Courses_LetsKodeIt;


public class JavaScript_For_Beginners extends TestBase {
	
	
	
	 @Test
	    public void ClickOn_JavaScript_For_Beginners (){
	        {
	        	
	        	driver.get("https://courses.letskodeit.com/practice");
	    		driver.manage().window().maximize();
	            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	            
	            driver.switchTo().frame("courses-iframe");

	            
	            Courses_LetsKodeIt JS = new Courses_LetsKodeIt(driver);
	            JS.Click_On_JS_Button(driver);


	            JS.Checking_Enroll_Button(driver);

	        }
	    }

}

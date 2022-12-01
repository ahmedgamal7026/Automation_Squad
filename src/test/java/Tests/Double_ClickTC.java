package Tests;

import java.time.Duration;

import org.testng.annotations.Test;

import Pages.Double_Click_Page;

public class Double_ClickTC extends TestBase{
	
	
	
	 @Test
	    public void ClickOn_JavaScript_For_Beginners (){
	        {
	        	
	        	driver.get("https://api.jquery.com/dblclick/");
	    		driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	            
	          

	            
	            Double_Click_Page DC = new Double_Click_Page(driver);
	            DC.Click_On_Coloured_Block(driver);



	        }
	    }

}

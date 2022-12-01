package Tests;

import org.testng.annotations.Test;

import Pages.Herokuapp_Page;

public class Infinite_Scroll extends TestBase{
	
	 @Test (priority = 3)
     public void infiniteSc() throws InterruptedException
     {
         
         Herokuapp_Page HP = new Herokuapp_Page(driver);
         HP.infiniteScroll();
     }

}

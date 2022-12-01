package Tests;

import org.testng.annotations.Test;

import Pages.RightClickPage;

public class Right_Click_TC extends TestBase{
	
	@Test
	public void RightClickOnBtn() {
		
		
		RightClickPage RC = new RightClickPage(driver);
		RC.Right_Click_On_Button_Function(driver);
		
	}

}

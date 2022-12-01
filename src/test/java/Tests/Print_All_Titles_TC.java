package Tests;

import org.testng.annotations.Test;

import Pages.Print_All_Windows_Titles;

public class Print_All_Titles_TC extends TestBase{



	@Test
	public void Print_all_Titles() throws InterruptedException  {



		Print_All_Windows_Titles TP = new Print_All_Windows_Titles(driver);
		TP.Print_All_Titles(driver);




	}

}

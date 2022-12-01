package Tests;

import org.testng.annotations.Test;

import Pages.Calendar_ThirdChallenge_Site;




public class Calendar_Third_ChallengeTC extends TestBase{
	
	
//	@DataProvider(name = "data")
//    public Object[][] UserData() throws IOException {
//
//        ExcelReader ER = new ExcelReader();
//        return ER.getExcelData(2);
//
//    }
//	
	
	Calendar_ThirdChallenge_Site CS;
	
	@Test
	public void Inserting_Date_In_Calendar2023() throws InterruptedException {	
		
		CS = new Calendar_ThirdChallenge_Site(driver);
		CS.Handling_Calendar("2023", "Dec", "25");
		Thread.sleep(3000);

	}
	
	
	
	@Test
	public void Inserting_Date_In_Calendar2020() {	
		
		CS = new Calendar_ThirdChallenge_Site(driver);
		CS.Handling_Calendar("2020", "Dec", "25");

	}
	
	
}

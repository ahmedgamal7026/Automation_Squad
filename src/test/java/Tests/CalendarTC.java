package Tests;

import org.testng.annotations.Test;

import Pages.CalendarSite_FirstCalendarChallenge;




public class CalendarTC extends TestBase{
	
	
	
	CalendarSite_FirstCalendarChallenge CS;
	
	@Test
	public void Inserting_Date_In_Calendar() {
		
		CS = new CalendarSite_FirstCalendarChallenge(driver);
		CS.Handling_Calendar();
	}

}

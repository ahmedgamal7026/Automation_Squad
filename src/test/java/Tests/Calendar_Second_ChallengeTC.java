package Tests;

import org.testng.annotations.Test;

import Pages.CalendarSite_SecondCalendarChallenge;




public class Calendar_Second_ChallengeTC extends TestBase{
	
	
	
	CalendarSite_SecondCalendarChallenge CS;
	
	@Test
	public void Inserting_Date_In_Calendar() {	
		
		CS = new CalendarSite_SecondCalendarChallenge(driver);
		CS.Handling_Calendar();
	}
	
}

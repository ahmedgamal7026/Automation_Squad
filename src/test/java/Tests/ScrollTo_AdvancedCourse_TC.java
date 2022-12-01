package Tests;

import org.testng.annotations.Test;

import Pages.Courses_LetsKodeIt;

public class ScrollTo_AdvancedCourse_TC extends TestBase{

	

	@Test
	public void ScrollingToEndOfThePage() throws InterruptedException {

		Courses_LetsKodeIt AC = new Courses_LetsKodeIt(driver);
		AC.ScrollToAdvancedCourse();

	}
}

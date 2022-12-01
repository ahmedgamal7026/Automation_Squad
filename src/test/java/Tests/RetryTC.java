package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTC {

	@Test
	public void Test1() {

		System.out.println("TEst1");
	}

	@Test
	public void Test2() {

//		int i=1/0;	
		}



	@Test(retryAnalyzer =Utilities.RetryAnalyzer.class )
	public void Test3() {

		Assert.assertTrue(false);
	}

}

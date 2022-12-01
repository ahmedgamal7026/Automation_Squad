package runner;

import Tests.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\aothman\\eclipse-workspace\\Challenges350\\src\\test\\java\\features",
glue= {"steps"},
plugin= {"pretty","html:target/cucmber-html-report"})
public class TestRunner extends TestBase{

	

				
}

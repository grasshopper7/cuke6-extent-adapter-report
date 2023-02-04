package stepdefs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/stepdefs/", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary",
		/* "html:target/cucumber-reports.html", */
		/* "rerun:target/rerun1.txt" */ } /* , tags = "@tabledoc or @skip" */ )
public class RunCukeIT extends AbstractTestNGCucumberTests {

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
}

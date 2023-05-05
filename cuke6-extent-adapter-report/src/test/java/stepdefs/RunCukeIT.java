package stepdefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/stepdefs/", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary",
/* "html:target/cucumber-reports.html", */
/* "rerun:target/rerun1.txt" */ } /* , tags = "@tabledoc or @skip" */ )
public class RunCukeIT /* extends AbstractTestNGCucumberTests */ {

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
}

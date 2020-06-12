package stepdefs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }/* , tags="@SOut" */ )
public class RunCukeIT extends AbstractTestNGCucumberTests {

}

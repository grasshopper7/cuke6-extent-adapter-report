package stepdefs;


import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*import cucumber.api.*;
import cucumber.api.java.*;
import cucumber.api.java.en.*;*/

import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefs {

	private Scenario scenario;

	@Before
	public void before() {
		
	}
	
	@After
	public void after() {
		
	}
	
	@Given("{string} background")
	public void background(String type) {
		System.out.format("%s type background. \n", type);
	}
	
	@Given("Write a {string} step with precondition in {string}")
	@When("Complete action in {string} step in {string}")
	@Then("Validate the outcome in {string} step in {string}")
	public void step(String step, String scenario) throws InterruptedException {
		System.out.format("%s step from %s.\n", step.toUpperCase(), scenario.toUpperCase());
		Thread.sleep(500);
	}

	@Then("Raise exception")
	public void raiseExcep() {

		Random r = new Random();
		boolean flag = r.nextBoolean();
		assertEquals(flag, true);
	}

	@Then("Do not raise exception")
	public void doNotRaiseExcep() {
		assertEquals(true, true);
	}

	@Given("Customer orders the dishes")
	public void dataTable(List<List<String>> table) {
		System.out.println(table);
	}

	@Given("the doc string is")
	public void docStr(String docStr) {
		System.out.println(docStr);
	}

	private WebDriver driver;
	private String site;

	@And("Go to {word}")
	public void visitweb(String site) throws Exception {
		driver.get(site);
		this.site = site;
		//scenario.write("scenario write");
		scenario.log("scenario website name - " + site);
		Thread.sleep(3000);
	}

	@BeforeStep(value = "@website")
	public void beforeSite(Scenario scenario) {
		this.scenario = scenario;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterStep(value = "@website")
	public void afterSite() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		//scenario.embed(screenshot, "image/png", this.site);
		// scenario.embed(screenshot, "image/png");
		scenario.attach(screenshot, "image/png", this.site);
		driver.quit();
	}
}
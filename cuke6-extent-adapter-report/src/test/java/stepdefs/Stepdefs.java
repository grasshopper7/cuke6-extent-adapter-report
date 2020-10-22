package stepdefs;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Files;
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

	@Before (value = "not @failure")
	public void before(Scenario scenario) {
		this.scenario = scenario;
		scenario.log("BEFORE HI");
		scenario.log("BEFORE HELLO");
	}
	
	@After (value = "not @failure")
	public void after(Scenario scenario) {
		
	}
	
	@Before (value = "@failure")
	public void beforeFailure(Scenario scenario) {
		//System.out.println("Before failure");
		this.scenario = scenario;
		scenario.log("FAILURE HI");
		scenario.log("FAILURE HELLO");
		throw new RuntimeException();
	}
	
	@After (value = "@failure")
	public void afterFailure() {
		//System.out.println("After failure");
		scenario.log("FAILURE HI");
		scenario.log("FAILURE HELLO");
		throw new RuntimeException();
	}
	
	@BeforeStep (value = "@failure")
	public void beforeStepFailure() {
		//System.out.println("Before Step failure");
	}
	
	@AfterStep (value = "@failure")
	public void afterStepFailure() {
		//System.out.println("After Step failure");
	}
	
	@Given("Hook failure step")
	public void hook_failure_step() throws InterruptedException {
		//System.out.println("Failure step");
		scenario.log("FAILURE STEP HI");
		scenario.log("FAILURE STEP HELLO");
	    Thread.sleep(500);
	}
	
	@Given("Skip hook failure step")
	public void skip_hook_failure_step() throws InterruptedException {
	    Thread.sleep(250);
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
		Thread.sleep(400);
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
		byte[] screenshot = Files.readAllBytes(new File("src/test/resources/logo.png").toPath());
		scenario.attach(screenshot, "image/png", this.site);
	}

	@BeforeStep(value = "@website")
	public void beforeSite(Scenario scenario) {
		this.scenario = scenario;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		scenario.log("HELLO THERE!!!");
	}

	@AfterStep(value = "@website")
	public void afterSite(Scenario scenario) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		//scenario.embed(screenshot, "image/png", this.site);
		// scenario.embed(screenshot, "image/png");
		scenario.attach(screenshot, "image/png", this.site);
		//scenario.log("HELLO THERE!!!");
		driver.quit();
	}
}
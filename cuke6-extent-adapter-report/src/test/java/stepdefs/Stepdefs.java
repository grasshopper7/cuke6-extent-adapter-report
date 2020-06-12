package stepdefs;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.cucumber.core.api.Scenario;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefs {
	
	private Scenario scenario;
	
	/*
	 * @BeforeStep public void beforeStep() throws InterruptedException {
	 * Thread.sleep(250); }
	 */

	@Given("Write a {string} step with precondition in {string}")
	@When("Complete action in {string} step in {string}")
	@Then("Validate the outcome in {string} step in {string}")
	public void step(String step, String scenario) {
		System.out.format("%s step from %s.\n", step.toUpperCase(), scenario.toUpperCase());
	}

	@Then("Raise exception")
	public void raiseExcep() {

		Random r = new Random();
		boolean flag = r.nextBoolean();
		System.out.println(flag);
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
	
	@Before(value = "@website")
	public void before(Scenario scenario) {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			
		}
		this.scenario = scenario;
	}
	
	@After(value = "@website")
	public void after() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			
		}
	}

	private WebDriver driver;
	private String site;

	@And("Go to {word}")
	public void visitweb(String site) throws Exception {
		System.out.println(site);
		driver.get(site);
		this.site = site;
		scenario.log("scenario write");
		Thread.sleep(5000);
	}

	/*
	 * @Before("not @foo") public void before(Scenario scenario) {
	 * scenario.write("Runs BEFORE scenarios *not* tagged with @foo"); }
	 * 
	 * @After("not @foo") public void after(Scenario scenario) {
	 * scenario.write("Runs AFTER scenarios *not* tagged with @foo"); }
	 */

	@BeforeStep(value = "@website")
	public void beforeSite() {
		System.out.println("BEFORE SITE");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterStep(value = "@website")
	public void afterSite() {
		System.out.println("AFTER SITE");

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		scenario.log("this is my failure message……….");
		scenario.attach(screenshot, "image/png", this.site);
		driver.quit();
	}
}
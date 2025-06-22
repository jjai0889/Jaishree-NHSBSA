package StepDefinition;

import Utility.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import java.util.List;



public class JobSearch extends BaseClass  {

	WebDriver driver;

	@Given("I am on the NHS Jobs search page")
	public void open_nhs_jobs_page() {
		WebDriverManager.chromedriver().setup();
		BaseClass.driver = new ChromeDriver(); // Use BaseClass.driver here
        BaseClass.driver.get("https://www.jobs.nhs.uk/candidate/search");
        BaseClass.driver.manage().window().maximize();
	}

	@When("I enter preferences like {string} in the keywords and {string} in location")
	public void i_enter_preferences_like_in_the_keywords_and_in_location(String keyword, String location) {
		System.out.println("Entering keyword: " + keyword);
		System.out.println("Entering location: " + location);

		    BaseClass.driver.findElement(By.id("keyword")).clear();
	        BaseClass.driver.findElement(By.id("keyword")).sendKeys(keyword);

	        BaseClass.driver.findElement(By.id("location")).clear();
	        BaseClass.driver.findElement(By.id("location")).sendKeys(location);
	    }

	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		WebElement searchBtn = BaseClass.driver.findElement(By.cssSelector("[data-test='search-button']")); // Adjust selector
		searchBtn.click();
		System.out.println("Clicked on search button");
	}

	@Then("I should see a list of job results")
	public void i_should_see_a_list_of_job_results() {
		System.out.println("Checking for job results");

	}

	@Then("the results should be sorted by {string}")
	public void the_results_should_be_sorted_by(String sortOption) {
		// Click the sort dropdown and select the desired option
		BaseClass.driver.findElement(By.cssSelector("[data-test='sort-input']")).click();
		BaseClass.driver.findElement(By.xpath("//option[text()='Date Posted (newest)']")).click();

		// Confirm the selected option
		WebElement selectedOption = BaseClass.driver.findElement(By.cssSelector("[data-test='sort-input'] > option:checked"));
		String selectedText = selectedOption.getText().trim();

		// Case-insensitive comparison
		Assert.assertTrue("Expected: " + sortOption + " but was: " + selectedText,
				selectedText.equalsIgnoreCase(sortOption.trim()));

		System.out.println("Verified sort order is: " + selectedText);
	}

	@Then("I print the top job posting date")
	public void i_print_the_top_job_posting_date() {
		// Locate the top job element
		WebElement firstJob = BaseClass.driver.findElement(By.cssSelector("li[data-test='search-result']"));

		// Extract the posted date
		String postedDate = firstJob.findElement(By.cssSelector("li[data-test='search-result-publicationDate'] strong"))
				.getText();

		// Print it
		System.out.println("Top job posting date: " + postedDate);
	}
	@After
	public void tearDown() {
	    if (BaseClass.driver != null) {
	    	BaseClass.driver.quit();
	    	System.out.println("Browser closed.");
	    }
	}
}

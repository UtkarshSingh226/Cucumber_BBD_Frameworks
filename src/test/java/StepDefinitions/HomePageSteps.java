package StepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import PageObject.HomePage;
import PageObject.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps{
	
	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	
	// Background Step is handled here
	@Given("browser is open")
	public void browser_is_open() {
		driver = Hooks.getDriver();
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        
    }

	
	// Defining Steps for Scenario: For Login Page
	@Given("User navigates to the Amazon homepage with the URL {string}")
	public void user_navigates_to_the_amazon_homepage_with_the_url(String url) {
		System.out.println("Amazon Home Page Opens for furthure actions");
		loginpage.navigateToHomePage(url);
	}
	
	
	@When("User clicks on SignIn")
	public void user_clicks_on_sign_in() {
		System.out.println("Login Page Opens for entering credentials");
	    loginpage.clickSignInButton();
	}

	
	@And("User enters email {string}")
	public void user_enters_email(String email) {
		System.out.println("Entering the Email address or Mobile Number");
	    loginpage.enterEmailAddress(email);
	}

	
	@And("User clicks on Continue")
	public void user_clicks_on_continue() {
		System.out.println("Clicking for Passowrd Entery");
	    loginpage.clickContinue();
	}

	
	@And("User enters password {string}")
	public void user_enters_password(String password) {
		System.out.println("Entering the Password");
	    loginpage.enterPassword(password);
	}

	
	@Then("User is navigated to Amazon Home Page")
	public void user_is_navigated_to_amazon_home_page() {
		System.out.println("Logged in Successfully.");
	    loginpage.clickSubmit();
	    try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
	
	
	// Defining Steps for Scenario: Amazon HomePage to search products
	@Given("User is on the Amazon home page")
	public void user_is_on_the_amazon_home_page() {
		System.out.println("And here the Amazon HomePage opens");
        driver.get("https://www.amazon.in/");
	}

	
	@And("User searches for (.*)$")
	public void user_searches_for(String productName) {
		System.out.println("Searching for some Products");
		homepage.searchForProduct(productName);
	}

	
	@Then("User should see search results for (.*)$")
	public void user_should_see_search_results_for(String productName) {
		System.out.println("Verifying search results for product: " + productName);
	    assertTrue(driver.getTitle().contains(productName), "Search results do not contain the expected product name: " + productName);
	    System.out.println("Search results for product " + productName + " are displayed.");
	}

}

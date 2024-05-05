package StepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import PageObject.AddToCartPage;
import PageObject.HomePage;
import PageObject.MiniTvPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonPOMSteps {

	WebDriver driver;
	MiniTvPage minitv;
	AddToCartPage addtocart;
	HomePage homepage;

	// Background Steps are handled here 
	@Given("now Chrome is Open")
	public void now_chrome_is_open() {
		driver = Hooks.getDriver();
		minitv = new MiniTvPage(driver);
		addtocart = new AddToCartPage(driver);
		homepage = new HomePage(driver);
	}
	

	@Given("user navigates to Amazon homepage with URL {string}")
	public void user_navigates_to_amazon_homepage_with_url(String url) {
		System.out.print("Amazon HomePage is opened for further task");
		minitv.navigateToHomePage(url);
	}
	

	// Defining Steps for Scenario: Clicking Amazon MiniTv Tab
	@When("user clicks on Amazon MiniTv tab")
	public void user_clicks_on_amazon_mini_tv_tab() {
		System.out.print("Clicking on Amazon MiniTv Button");
		minitv.amazonMiniTv();
	}
	

	@Then("user navigates to Amazon MiniTv")
	public void user_navigates_to_amazon_mini_tv() {
		System.out.print("Amazon MiniTv opens");
        assertTrue(minitv.isOnMiniTvPage(), "Failed to navigate to Amazon MiniTv page");
	}
	
	
	// Defining Steps for Scenario: Add to CartPage by adding a product
	@When("user search for the productName {string}")
	public void user_search_for_the_product_name(String productName) {
		System.out.print("Serach for product Iphone");
	    homepage.searchForProduct(productName);
	}

	
	@And("user click on add to cart")
	public void user_click_on_add_to_cart() {
	    System.out.print("Click add to cart to add product");
	    addtocart.addToCart();
	}
	
	
	@And("product is sucessfully added")
	public void product_is_sucessfully_added() {
		System.out.println("Verifying product in the cart");
        assertTrue(addtocart.isProductAddedToCart(), "Product not added to cart");
        System.out.println("Product added to cart successfully");
	}

	
	@Then("user navigated to amazon cart")
	public void user_navigated_to_amazon_cart() {
	    System.out.print("User is navigated to Amamzon Cart Page");
	    addtocart.visitCartPage();
	}

}

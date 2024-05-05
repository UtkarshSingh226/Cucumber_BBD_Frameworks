package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {

	private WebDriver driver;

	// Adding Locators for the AddToCart Page
	private By click_AddToCart = By.id("a-autoid-1-announce");
	private By click_Cart_Button = By.id("nav-cart");
	private By cart_Item_Count = By.xpath("//*[@id=\"nav-cart-count\"]");

	// Constructor for the page
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;

	}

	// Method to Add Item to Amazon Cart
	public void addToCart() {
		WebElement addToCart = driver.findElement(click_AddToCart);
		addToCart.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(click_Cart_Button));
	}

	// Method to navigate to Cart Page to see the added item
	public void visitCartPage() {
		WebElement cartPage = driver.findElement(click_Cart_Button);
		// Scroll to the element to ensure it's in the viewable area for further process
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartPage);
		// Waiting for a brief moment to allow the page to settle to click the Cart
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cartPage.click();
	}

	// Method to verify that item is added to cart
	public boolean isProductAddedToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(cart_Item_Count, "1"));
		int itemCount = getCartItemCount();
		return itemCount > 0;
	}

	// Method to get the count of items in the cart
	public int getCartItemCount() {
		WebElement itemCountElement = driver.findElement(cart_Item_Count);
		String itemCountText = itemCountElement.getText();
		return Integer.parseInt(itemCountText);
	}
	
}

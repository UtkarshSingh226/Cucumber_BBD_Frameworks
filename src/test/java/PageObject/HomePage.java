package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.WaitUtils;

public class HomePage{
	
	private WebDriverWait wait;
	
	// Adding Locators for the Home Page
	private By search_BoxTab = By.id("twotabsearchtextbox");
	private By click_Search_Button = By.id("nav-search-submit-button");
	
	
	// Creating Constructor 
	public HomePage(WebDriver driver) {
		this.wait = WaitUtils.getWebDriverWait(driver); // Using WaitUtils to get WebDriverWait
	}
	
	// Method to search the specific product on Amazon WebSite
	public void searchForProduct(String productName) {
		
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(search_BoxTab));
        searchBox.sendKeys(productName);

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(click_Search_Button));
        searchButton.click();   
    }

}

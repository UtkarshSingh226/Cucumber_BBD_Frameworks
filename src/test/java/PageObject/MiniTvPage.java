package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.WaitUtils;

public class MiniTvPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Adding Locators for the MiniTv Page
	private By click_Amazon_MiniTV = By.xpath("//*[@id=\"nav-xshop\"]/a[2]");
	
	// Creating Constructor
	public MiniTvPage(WebDriver driver) {
		this.driver = driver;
		this.wait = WaitUtils.getWebDriverWait(driver); // Using WaitUtils to get WebDriverWait
	}
	
	// Method to navigate to Amazon HomePage
	public void navigateToHomePage(String url) {
		driver.get(url);
	}
	
	// Method to Navigate to Amazon MiniTv
	public void amazonMiniTv() {
		WebElement miniTvLink = wait.until(ExpectedConditions.elementToBeClickable(click_Amazon_MiniTV));
        miniTvLink.click();
	}

	// Method to check if the user is on the Amazon MiniTv page
	public boolean isOnMiniTvPage() {
        return driver.getCurrentUrl().contains("https://www.amazon.in/minitv?ref_=nav_avod_desktop_topnav");
    }

}

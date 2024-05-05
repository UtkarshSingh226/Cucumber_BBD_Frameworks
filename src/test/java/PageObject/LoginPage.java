package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.WaitUtils;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Adding Locators for the Amazon Login Process
	private By click_SignIn_Button = By.id("nav-link-accountList");
	private By enter_EmailAdress = By.id("ap_email");
	private By click_Continue_Button = By.id("continue");
	private By enter_Password = By.id("ap_password");
	private By click_submit_Button = By.id("signInSubmit");

	// Creating the constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = WaitUtils.getWebDriverWait(driver); // Using WaitUtils to get WebDriverWait
	}

	// Method to navigate to home page of Amazon WebSite
    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    // Method to click on Sign In option
    public void clickSignInButton() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(click_SignIn_Button));
        signInButton.click();
    }

    // Method to Enter Email or Mobile Number for SignIn
    public void enterEmailAddress(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enter_EmailAdress));
        emailInput.sendKeys(email);
    }

    // Method to click on Continue button
    public void clickContinue() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(click_Continue_Button));
        continueButton.click();
    }

    // Method to Enter the Password for login in
    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enter_Password));
        passwordInput.sendKeys(password);
    }

    // Method to click on Submit button
    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(click_submit_Button));
        submitButton.click();
    }

}

package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	private static WebDriver driver;

	// Implementing @Before hook to open the Browser
	@Before
	public void setUp() {
		System.out.println("Browser will open");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// Implement the @After hook to close the Browser
	@After
	public void tearDown() {
		System.out.println("Browser will close");
		if (driver != null) {
			driver.quit();
		}
	}

	// Defining a static method to get the WebDriver instance
	public static WebDriver getDriver() {
		return driver;
	}

}

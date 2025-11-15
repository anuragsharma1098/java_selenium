package day25_Parameterization_Parallel_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	void setup(String br) throws InterruptedException {
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please provide a valid browser name");
			return;// Exit the method if the browser name is invalid
		}

		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
	}

	@Test(priority = 1)
	void testLogo() {
		boolean isLogoDisplayed = driver.findElement(org.openqa.selenium.By.xpath("//img[@alt='company-branding']"))
				.isDisplayed();
		Assert.assertTrue(isLogoDisplayed, "Logo is displayed on the login page");

	}

	@Test(priority = 2)
	void testTitle() {
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title matches the expected title");

	}

	@Test(priority = 3)
	void testURL() {
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", "URL is correct");
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}
}

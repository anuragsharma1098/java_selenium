package day26_Listeners_ExtentReportGeneration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// @Listeners(day26_Listeners_ExtentReportGeneration.MyListener.class)
public class OrangeHRMTest {
	WebDriver driver;

	@BeforeClass
	void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}

	@Test(priority = 1)
	void testLogo() {
		boolean isLogoDisplayed = driver.findElement(org.openqa.selenium.By.xpath("//img[@alt='company-branding']"))
				.isDisplayed();
		Assert.assertTrue(isLogoDisplayed, "Logo is displayed on the login page");

	}

	@Test(priority = 2)
	void testURL() {
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/loginn", "URL is correct");
	}

	@Test(priority = 3, dependsOnMethods = { "testURL" })
	void testHomepageTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Page title matches the expected title");
	}

	@AfterClass
	void teardown() {
		driver.quit();
	}

}

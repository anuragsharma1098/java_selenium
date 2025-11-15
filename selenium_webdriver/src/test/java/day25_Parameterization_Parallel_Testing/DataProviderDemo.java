package day25_Parameterization_Parallel_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	WebDriver driver;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "loginDataProvider")
	void testLogin(String Username, String Password) throws InterruptedException {
		// go to link
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// login
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		boolean isLoggedIn = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
		if (isLoggedIn) {
			driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
			Assert.assertTrue(true, "Login successful and logged out");

		} else {
			Assert.fail("Login failed");
		}
	}

	@AfterClass
	void teardown() {
		driver.quit();
	}

	@DataProvider(name = "loginDataProvider", indices = { 0, 1 })
	Object loginData() {
		Object data[][] = { { "Admin", "admin123" }, { "Admin1", "admin123" }, { "Admin", "Admin1234" },
				{ "Admin1", "Admin1234" } };

		return data;
	}

}

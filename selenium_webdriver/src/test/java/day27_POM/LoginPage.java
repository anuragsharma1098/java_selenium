package day27_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	// constructor
	LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	By usernameInput = By.xpath("//input[@placeholder='Username']");
	By passwordInput = By.xpath("//input[@placeholder='Password']");
	By loginButton = By.xpath("//button[@type='submit']");

	// action methods
	public void setUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}
	public void setPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
}

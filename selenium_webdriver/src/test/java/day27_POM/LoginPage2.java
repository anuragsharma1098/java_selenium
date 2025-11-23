package day27_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

	WebDriver driver;

	// constructor
	LoginPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locators
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameInput;

//	@FindBy(how=How.XPATH, using="//input[@placeholder='Username']")
//	WebElement usernameInput;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(tagName = "a")
	List<WebElement> links;

	// action methods
	public void setUsername(String username) {
		usernameInput.sendKeys(username);
	}

	public void setPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}
}

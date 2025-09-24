package day9_CheckBox_Alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopUp {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // driver.get("https://the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
        // Syntax
        // driver.get("https://username:password@the-internet.herokuapp.com/basic_auth");
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(5000);
        driver.quit();
    }
}
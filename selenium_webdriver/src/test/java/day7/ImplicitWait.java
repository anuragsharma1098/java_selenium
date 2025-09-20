package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {
    public static void main(String[] args) {
        System.out.println("ImplicitWait");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("iphone 16 pro");
        driver.findElement(By.id("nav-search-submit-button"))
                .click();
        driver.quit();

    }
}

package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
    public static void main(String[] args) {
        System.out.println("Explicit Wait");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By
        // .id("twotabsearchtextbox")))
        // .sendKeys("iphone 16 pro");
        WebElement myelmnt = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .id("twotabsearchtextbox")));
        myelmnt.sendKeys("iphone 15 pro max");
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By
        // .id("nav-search-submit-button"))).click();
        WebElement clk = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .id("nav-search-submit-button")));
        clk.click();
        driver.quit();

    }
}

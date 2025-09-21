package day7_Webdriver_Waiting_Methods;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.base.Function;
import org.openqa.selenium.support.ui.FluentWait;

public class Fluent_Wait {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Fluent Wait");
        WebDriver driver = new ChromeDriver();

        // fluent wait
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10)) // max wait time
                .pollingEvery(Duration.ofSeconds(2)) // frequency
                .ignoring(NoSuchElementException.class); // exception to ignore

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        // find element
        WebElement myelmnt = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("twotabsearchtextbox"));
            }
        });
        // send keys
        myelmnt.sendKeys("iphone 15 pro max");

        // click element
        WebElement clk = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("nav-search-submit-button"));
            }
        });
        // click
        clk.click();

        driver.quit();

    }
}

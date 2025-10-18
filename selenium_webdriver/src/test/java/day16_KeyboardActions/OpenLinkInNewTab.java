package day16_KeyboardActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        // go to webpage
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement link = driver.findElement(By
                .xpath("//a[normalize-space()='Udemy Courses']"));
        Actions act = new Actions(driver);
        // open link in new tab
        act.keyDown(Keys.CONTROL)
                .click(link)
                .keyUp(Keys.CONTROL)
                .perform();
        // get window handles
        List<String> ids = new ArrayList(driver.getWindowHandles());
        ids.get(0);
        ids.get(1);
        // switch to second tab
        driver.switchTo().window(ids.get(1));
        Thread.sleep(5000);
        // switch to first tab
        driver.switchTo().window(ids.get(0));
        Thread.sleep(5000);
        driver.quit();
    }
}

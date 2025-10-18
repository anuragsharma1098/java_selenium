package day16_KeyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://text-compare.com/");
        driver.findElement(By
                .xpath("//textarea[@id='inputText1']"))
                .sendKeys("Selenium Automation");
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL)
                .sendKeys("A")
                .sendKeys("C")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.TAB)
                .keyDown(Keys.CONTROL)
                .sendKeys("V")
                .keyUp(Keys.CONTROL)
                .perform();
        driver.quit();
    }
}

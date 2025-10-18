package day15_MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.switchTo().frame("iframeResult");
        WebElement button = driver.findElement(By
                .xpath("//button[normalize-space()='Copy Text']"));
        Actions act = new Actions(driver);
        // double click
        act.doubleClick(button).build().perform();
        // verify text
        WebElement box1 = driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));
        System.out.println(box1.getAttribute("value"));
        System.out.println(box2.getAttribute("value"));
        if (box1.getText().equals(box2.getText()))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
        box1.clear();
        box1.sendKeys("WELCOME");
        act.doubleClick(button).build().perform();
        System.out.println(box1.getAttribute("value"));
        System.out.println(box2.getAttribute("value"));
        if (box1.getText().equals(box2.getText()))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
        driver.switchTo().defaultContent();
        driver.quit();
    }
}

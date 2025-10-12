package day15_MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement point_me = driver.findElement(By
                .xpath("//button[@class='dropbtn']"));
        WebElement mobiles = driver.findElement(By
                .xpath("//a[normalize-space()='Mobiles']"));
        WebElement laptops = driver.findElement(By
                .xpath("//a[normalize-space()='Laptops']"));
        Actions act = new Actions(driver);
        // mouse hover action
        act.moveToElement(point_me)
                .moveToElement(mobiles)
                .moveToElement(laptops)
                .build().perform();
        // click on mobiles
        act.moveToElement(point_me)
                .moveToElement(mobiles)
                .click().perform();

        // diff in build and perform
        // build() --> used to compile all the actions into a single step
        // perform() --> used to execute the actions
        // perform also compiles and executes the actions
        // build is optional with perform
        driver.quit();
    }
}

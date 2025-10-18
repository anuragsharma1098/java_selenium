package day15_MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_Drop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
        Actions act = new Actions(driver);
        WebElement src_ele = driver.findElement(By
                .xpath("//img[@id='img1']"));
        WebElement trg_ele = driver.findElement(By
                .xpath("//div[@id='div2']"));
        // drap and drop
        act.dragAndDrop(src_ele, trg_ele).perform();
        driver.quit();
    }

}

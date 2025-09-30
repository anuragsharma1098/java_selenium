package day10_Frames_IFrames_NestedF_iF;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandsOn {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        WebElement frame5 = driver.findElement(By.xpath("/html/frameset/frame[2]"));// input[@name='mytext5']
        driver.switchTo().frame(frame5);
        driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Welcome_5");
        driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
        // driver.switchTo().frame(0);
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"logo\"]/img"));
        if (logo.isDisplayed()) {
            System.out.println("Logo is displayed");
        } else {
            System.out.println("Logo is not displayed");
        }
        driver.switchTo().defaultContent();
        driver.quit();

    }
}

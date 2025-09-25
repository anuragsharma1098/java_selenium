package day10_Frames_IFrames_NestedF_iF;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        // frame 1
        WebElement frame1 = driver.findElement(By.xpath("/html/frameset/frame[1]"));
        driver.switchTo().frame(frame1); // passing frame1 as webelemnet
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");
        driver.switchTo().defaultContent(); // go back to page

        // frame 2
        WebElement frame2 = driver.findElement(By.xpath("/html/frameset/frameset/frame[1]"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Welcome_2");
        driver.switchTo().defaultContent();

        // frame 3
        WebElement frame3 = driver.findElement(By.xpath("/html/frameset/frameset/frame[2]"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Welcome_3");

        // inner frame which is part of frame 3
        driver.switchTo().frame(0); // switching to frame as an index
        // driver.findElement(By.xpath("//div[@id='i6']//div[@class='rseUEfßnQOrEb']")).click();
        WebElement rdbtn = driver.findElement(By
                .xpath("//div[@id='i6']//div[@class='rseUEf nQOrEb']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", rdbtn);
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        
        driver.quit();
    }
}

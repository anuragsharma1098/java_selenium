package day17_Javascript_Executor_ScrollingPages_UploadFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // ChromeDriver driver = new ChromeDriver();
        // JavascriptExecutor js = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement input_name = driver.findElement(By
                .xpath("//input[@id='name']"));
        // passing the text into inputbox - alternate to sendKeys()
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','John')", input_name);

        // clicking on element = alternate to click()
        WebElement rd_btn = driver.findElement(By
                .xpath("//input[@id='male']"));
        js.executeScript("arguments[0].click()", rd_btn);

    }
}

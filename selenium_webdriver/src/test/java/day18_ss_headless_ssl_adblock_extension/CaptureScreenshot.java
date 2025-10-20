package day18_ss_headless_ssl_adblock_extension;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshot {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        // 1) full page ss
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source_file = ts.getScreenshotAs(OutputType.FILE);
        File target_file = new File(System
                .getProperty("user.dir") + "\\screenshots\\fullpage.png");
        source_file.renameTo(target_file);
        Thread.sleep(5000);
        driver.quit();
    }
}

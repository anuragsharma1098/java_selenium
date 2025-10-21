package day18_ss_headless_ssl_adblock_extension;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        File target_file = new File(
                "C:\\Users\\anura\\Desktop\\java_selenium\\selenium_webdriver\\screenshots\\fullpage.png");
        // File target_file = new File(System
        //      .getProperty("user.dir") + "\\screenshots\\fullpage.png");
        source_file.renameTo(target_file);

        // 2) capture ss of specific section of page
        WebElement ss_specific = driver.findElement(By
                .xpath("//body/div[@class='content']/div[@class='content-outer']/div[@class='fauxborder-left content-fauxborder-left']/div[@class='content-inner']/div[@class='main-outer']/div[@class='fauxborder-left main-fauxborder-left']/div[@class='region-inner main-inner']/div[@class='columns fauxcolumns']/div[@class='columns-inner']/div[@class='column-center-outer']/div[@class='column-center-inner']/div[@id='main']/div[@id='Blog1']/div[@class='blog-posts hfeed']/div[@class='date-outer']/div[@class='date-posts']/div[@class='post-outer']/div[@class='post hentry uncustomized-post-template']/div[@id='post-body-1307673142697428135']/div[1]"));
        File source_file2 = ss_specific.getScreenshotAs(OutputType.FILE);
        File target_file2 = new File(
                "C:\\Users\\anura\\Desktop\\java_selenium\\selenium_webdriver\\screenshots\\userinput.png");
        source_file2.renameTo(target_file2);

        // 3) capture ss of specific element
        WebElement ele = driver.findElement(By
                .xpath("//button[normalize-space()='START']"));
        File source_file3 = ele.getScreenshotAs(OutputType.FILE);
        File target_file3 = new File(
                "C:\\Users\\anura\\Desktop\\java_selenium\\selenium_webdriver\\screenshots\\webele.png");
        source_file3.renameTo(target_file3);

        driver.quit();
    }
}

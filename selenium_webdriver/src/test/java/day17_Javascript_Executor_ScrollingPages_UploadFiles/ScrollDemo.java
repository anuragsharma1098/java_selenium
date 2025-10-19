package day17_Javascript_Executor_ScrollingPages_UploadFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");

        // 1) scroll down page by pixel number
        js.executeScript("window.scrollBy(0,3000)", "");
        System.out.println(js.executeScript("return window.pageYOffset;"));

        // // 2) scroll the page till element is visible
        // WebElement ele = driver.findElement(By
        //         .xpath("//td[normalize-space()='India']"));
        // js.executeScript("arguments[0].scrollIntoView();", ele);
        // System.out.println(js.executeScript("return window.pageYOffset;"));

        // // 3) scroll down the page till the end
        // js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        // System.out.println(js.executeScript("return window.pageYOffset;"));

        // // scrolling up to initial position
        // js.executeScript("window.scrollBy(0, 3000)", "");
        // Thread.sleep(5000);
        // js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
        // System.out.println(js.executeScript("return window.pageYOffset;"));

        // use scrollWidth for horizontal scroll
    }
}

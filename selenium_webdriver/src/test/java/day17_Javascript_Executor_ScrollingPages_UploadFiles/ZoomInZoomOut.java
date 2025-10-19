package day17_Javascript_Executor_ScrollingPages_UploadFiles;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }
}

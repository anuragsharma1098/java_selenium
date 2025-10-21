package day18_ss_headless_ssl_adblock_extension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedMessage {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        String actualTitle = driver.getTitle();
        System.out.println("Title of page: " + actualTitle);
        Thread.sleep(5000);
        driver.quit();
    }
}

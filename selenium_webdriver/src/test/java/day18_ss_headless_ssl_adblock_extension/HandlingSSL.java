package day18_ss_headless_ssl_adblock_extension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingSSL {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        // accept ssl certificate
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        String actualTitle = driver.getTitle();
        System.out.println("Title of page: " + actualTitle);
        driver.quit();
    }
}

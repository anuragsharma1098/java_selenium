package day18_ss_headless_ssl_adblock_extension;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionsatRuntime {
    public static void main(String[] args) {
        // initialize ChromeOption object
        ChromeOptions options = new ChromeOptions();
        // file path of CRX file of plugin
        File file = new File("filepath");
        // adding extensions
        options.addExtensions(file);
        // passing options object in ChromeDriver
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
            System.out.println("Actual Title: " + actualTitle);
        }
        driver.quit();
    }
}

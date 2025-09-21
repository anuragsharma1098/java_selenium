package day8_Browser_Navigation_Cmds;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCmds {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Navigational Commands");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        URL url = new URL("https://www.flipkart.com/");
        System.out.println("GET COMMAND");
        driver.get("https://www.google.com");
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("NAVIGATIONAL COMMAND NAVIGATE TO");
        driver.navigate().to("https://www.amazon.com");
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        driver.navigate().to(url);
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("NAVIGATIONAL COMMAND BACK");
        driver.navigate().back();
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("NAVIGATIONAL COMMAND FORWARD");
        driver.navigate().forward();
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("NAVIGATIONAL COMMAND REFRESH");
        driver.navigate().refresh();
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        driver.quit();
    }
}

package day19_BrokenLinks_SVGElements_ShadowDOM;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        int noofbrokenlinks = 0;
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        // capture all links from the website
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links: " + links.size());

        for (WebElement linkElement : links) {
            String hrefValue = linkElement.getAttribute("href");
            if (hrefValue == null || hrefValue.isEmpty()) {
                System.out.println("href attribute value is null or empty, so not possible to check");
                continue;
            }
            try {
                // hit URL to the server
                // converted href value from string to URL format
                URL linkURL = new URL(hrefValue);
                // open connection to the server
                HttpURLConnection connlinkURL = (HttpURLConnection) linkURL.openConnection();
                // connect to server and sent request to the server
                connlinkURL.connect();

                if (connlinkURL.getResponseCode() >= 400) {
                    System.out.println(hrefValue + "====> Broken Link");
                    noofbrokenlinks++;
                } else
                    System.out.println(hrefValue + "====> Not a Broken Link");
            } catch (Exception e) {

            }
        }
        System.out.println("No of Brokenk Links: " + noofbrokenlinks);
        driver.quit();
    }
}

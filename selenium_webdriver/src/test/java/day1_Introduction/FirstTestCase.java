package day1_Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/*
 1. Open Chrome Browser
 2. Go to https://www.google.com/
 3. Validate the title is "Google"
 4. Close the browser
 */
public class FirstTestCase {
    public static void main(String[] args) {
        // Chrome Browser
        // ChromeDriver driver = new ChromeDriver();
        // driver.get("https://www.google.com/");
        // 1. open Chrome Browser
        WebDriver driver = new ChromeDriver();// upcasting
        // 2. Go to https://www.google.com/
        driver.get("https://www.google.com/");
        // 3. Validate the title is "Google"
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
            System.out.println("Actual Title: " + actualTitle);
        }
        // 4. Close the browser
        driver.quit();// driver.close();

        // Edge Browser
        WebDriver driverEdge = new EdgeDriver();// upcasting
        driverEdge.get("https://www.google.com/");
        String expectedTitleEdge = "Google";
        String actualTitleEdge = driverEdge.getTitle();
        if (actualTitleEdge.equals(expectedTitleEdge)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
            System.out.println("Actual Title: " + actualTitleEdge);
        }
        driverEdge.quit();
    }
}
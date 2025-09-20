package day2_Locators_Basics.PartialText__Class_Tag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestCase {
    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();
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

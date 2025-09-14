package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("WebDriverMethods");
        WebDriver driver = new ChromeDriver();

        // get methods - returns String value
        // get(url) - to launch the url
        driver.get("https://www.flipkart.com/");
        // getTitle - to get the title of the page
        System.out.println(driver.getTitle());
        // getCurrentUrl - to get the current url of the page
        System.out.println(driver.getCurrentUrl());
        // getPageSource - to get the page source of the page
        // System.out.println(driver.getPageSource());
        // getWindowHandle - to get the window handle of the page
        System.out.println(driver.getWindowHandle());
        driver.findElement(By.linkText("Myntra")).click();
        // getWindowHandles - to get the window handles of the page
        System.out.println(driver.getWindowHandles());
        Thread.sleep(5000);
        driver.quit();

        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.flipkart.com/");
        // condition methods - returns boolean value
        // isDisplayed - to check if the element is displayed or not
        System.out.println(driver1.findElement(By.name("q"))
                .isDisplayed());
        // isEnabled - to check if the element is enabled or not
        System.out.println(driver1.findElement(By.name("q"))
                .isEnabled());
        // isSelected - to check if the element is selected or not
        System.out.println(driver1.findElement(By.name("q"))
                .isSelected());
        Thread.sleep(5000);
        driver1.quit();

        // browser methods - void methods
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://www.flipkart.com/");
        Thread.sleep(5000);
        driver2.findElement(By.linkText("Myntra")).click();
        Thread.sleep(5000);
        // close - to close the current browser
        driver2.close();
        // quit - to close all the browsers opened by selenium
        driver2.quit();

    }
}
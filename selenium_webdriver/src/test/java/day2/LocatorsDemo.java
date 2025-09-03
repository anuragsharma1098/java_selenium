package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        //name locator
        driver.findElement(By.name("q")).sendKeys("macbook pro");

        //id locator
        boolean containerdisp = driver.findElement(By.id("container")).isDisplayed();
        System.out.println("container is displayed: " + containerdisp);

        //linktext locator
    }
}

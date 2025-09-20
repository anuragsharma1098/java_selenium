package day6_WebDriver_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethodsHandsOn {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        // System.out.println("Page Source: " + driver.getPageSource());
        System.out.println("Window Handle: " + driver.getWindowHandle());
        System.out.println("Window Handles: " + driver.getWindowHandles());
        // System.out.println("Class of the driver: " + driver.getClass());

        boolean isdisplay = driver.findElement(By.xpath("//div[@id='PageList2']//a[normalize-space()='Home']"))
                .isDisplayed();
        System.out.println("Is Displayed: " + isdisplay);

        boolean isenable = driver.findElement(By.xpath("//div[@id='PageList2']//a[normalize-space()='Home']"))
                .isEnabled();
        System.out.println("Is Enabled: " + isenable);

        boolean isselect = driver.findElement(By.xpath("//input[@id='male']")).isSelected();
        System.out.println("Is Selected befor clicking: " + isselect);

        driver.findElement(By.xpath("//input[@id='male']")).click();

        Thread.sleep(5000);

        boolean isselect1 = driver.findElement(By.xpath("//input[@id='male']")).isSelected();
        System.out.println("Is Selected after clicking: " + isselect1);

        driver.quit();
    }

}

package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxesDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"))
                .sendKeys("MacBook M1 Pro");
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@name='q'][@placeholder='Search for Products, Brands and More']"))
                .sendKeys("MacBook M2 Pro");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/span")).click();
        Thread.sleep(5000);
        driver.quit();

    }
}

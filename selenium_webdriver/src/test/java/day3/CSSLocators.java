package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();// to maximize the window

        // tag and id
        // driver.findElement(By.cssSelector("input#inputValEnter")).sendKeys("MacBook
        // M4");

        // tag and class
        // driver.findElement(By.cssSelector("input.Pke_EE")).sendKeys("MacBook M4");
        driver.findElement(By.cssSelector(".Pke_EE")).sendKeys("MacBook M4");

        // tag and attribute
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input[placeholder=\"Search for Products, Brands and More\"]"))
                .sendKeys("MacBook M4");

        // tag, class and attribute
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input.Pke_EE[placeholder=\"Search for Products, Brands and More\"]"))
                .sendKeys("MacBook M4");

        driver.close();
    }
}

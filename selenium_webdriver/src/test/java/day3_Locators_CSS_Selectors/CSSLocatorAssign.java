package day3_Locators_CSS_Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocatorAssign {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");

        // tag and id
        driver.findElement(By.cssSelector("input#twotabsearchtextbox"))
                .sendKeys("MacBook");

        // tag and class
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input.nav-input"))
                .sendKeys("MacBook M1");

        // tag and attribute
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input[aria-label=\"Search Amazon.in\"]"))
                .sendKeys("MacBook M2");

        // tag, class and attribute
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input.nav-input[aria-label=\"Search Amazon.in\"]"))
                .sendKeys("MacBook M3");

        // tag, id and attribute
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input#twotabsearchtextbox[aria-label='Search Amazon.in']"))
                .sendKeys("MacBook M4");

        // tag, id, class and attribute
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input#twotabsearchtextbox.nav-input[aria-label='Search Amazon.in']"))
                .sendKeys("MacBook Air");

        driver.quit();
    }
}

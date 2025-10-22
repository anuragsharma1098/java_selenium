package day19_BrokenLinks_SVGElements_ShadowDOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleSVGElements {
    public static void main(String[] args) {
        // Initialize WebDriver (Chrome)
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to the webpage containing the SVG
            driver.get("URL_OF_PAGE_WITH_SVG");

            // Wait until SVG element is loaded
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement svgElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//svg")));

            // Example: Locating a specific SVG element, like a <path> or <circle> element
            WebElement pathElement = driver.findElement(By.xpath("//svg//path[@d='M10 10 L50 50']"));
            pathElement.click(); // You can interact with it, like click

            // Example: Locating a <circle> element and printing its attribute
            WebElement circleElement = driver.findElement(By.xpath("//svg//circle[@cx='100' and @cy='100']"));
            String radius = circleElement.getAttribute("r");
            System.out.println("Radius of the circle: " + radius);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

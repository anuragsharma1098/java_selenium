package day19_BrokenLinks_SVGElements_ShadowDOM;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShadowDOMElements {
    public static void main(String[] args) {
        // shadom DOM cannot be handled by xpath
        // cssSelector can only handle shadow DOM
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            // Navigate to the page with shadow DOM
            driver.get("https://your-shadow-dom-example-page.com");

            // Find the shadow host element
            WebElement shadowHost = driver.findElement(By.cssSelector("your-shadow-host-selector"));

            // Get shadow root from the host using SearchContext
            SearchContext shadowRoot = shadowHost.getShadowRoot();
            Thread.sleep(2000);

            // Now find element inside shadow root
            WebElement shadowElement = shadowRoot.findElement(By.cssSelector("your-shadow-element-selector"));

            // Interact with the shadow DOM element
            shadowElement.click(); // or .getText(), .sendKeys(), etc.

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        // // nested shadow DOM
        // try {
        //     // Navigate to the page with Shadow DOM
        //     driver.get("https://your-shadowdom-example.com");

        //     // Step 1: Locate the outer shadow host
        //     WebElement outerHost = driver.findElement(By.cssSelector("outer-component"));

        //     // Step 2: Get the outer shadow root using getShadowRoot()
        //     SearchContext outerShadowRoot = outerHost.getShadowRoot();
        //     Thread.sleep(2000);

        //     // Step 3: Locate the inner shadow host inside the outer shadow root
        //     WebElement innerHost = outerShadowRoot.findElement(By.cssSelector("inner-component"));

        //     // Step 4: Get the inner shadow root
        //     SearchContext innerShadowRoot = innerHost.getShadowRoot();
        //     Thread.sleep(2000);

        //     // Step 5: Finally locate the button inside inner shadow root
        //     WebElement nestedButton = innerShadowRoot.findElement(By.cssSelector("#nestedBtn"));

        //     // Perform actions
        //     nestedButton.click();

        // } catch (Exception e) {
        //     e.printStackTrace();
        // } finally {
        //     // Clean up
        //     driver.quit();
        // }
    }
}

package day8_Browser_Navigation_Cmds;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavCmndsHandsOn {
    public static void main(String[] args) {
        System.out.println("Browser Navigation Commands Hands-On");
        // Implementation goes here
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("(//input[@id='Wikipedia1_wikipedia-search-input'])[1]"))
                .sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        // count total links
        int linkcount = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a")).size();
        System.out.println("Total links found: " + (linkcount + 1));
        // print all links
        List<WebElement> links = driver.findElements(By.xpath("//*[@id=\"wikipedia-search-result-link\"]//a[@href]"));
        for (WebElement link : links) {
            System.out.println(link.getText() + " : " + link.getAttribute("href"));
        }
        // navigate to all links in new tabs
        for (WebElement link : links) {
            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            link.sendKeys(clickOnLink);
        }
        driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-more\"]/a")).click();
        // switch to each window and print title and URL
        Set<String> windowIDs = driver.getWindowHandles();
        System.out.println("Total windows opened: " + windowIDs.size());
        for (String windowID : windowIDs) {
            driver.switchTo().window(windowID);
            System.out.println("************************");
            System.out.println("Window ID: " + windowID);
            System.out.println(driver.getTitle() + " : " + driver.getCurrentUrl());
            System.out.println("************************");
        }
        // close a specific window by title
        List<String> handleList = new ArrayList<>(windowIDs);
        driver.switchTo().window(handleList.get(6));
        String pageTitle = driver.getTitle();

        for (String windowID : windowIDs) {
            String title = driver.switchTo().window(windowID).getTitle();
            if (title.equals(pageTitle)) {
                driver.close();
                break;
            }
        }
        // verify the window is closed
        List<String> windowIDsAfterClosing = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Total windows opened after closing one: " + windowIDsAfterClosing.size());

        driver.quit();
    }
}

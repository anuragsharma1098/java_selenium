package day2_Locators_Basics.PartialText__Class_Tag;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        // name locator
        driver.findElement(By.name("q")).sendKeys("macbook pro");

        // id locator
        boolean containerdisp = driver.findElement(By.id("container")).isDisplayed();
        System.out.println("container is displayed: " + containerdisp);

        // linktext locator
        driver.findElement(By.linkText("Mobiles & Tablets")).click();
        System.out.println("title after clicking on link: " + driver.getTitle());

        // partial linktext locator
        driver.navigate().back();
        driver.findElement(By.partialLinkText("Tablets")).click();
        System.out.println("title after clicking on partial link: " + driver.getTitle());

        // diff. in linktext and partial linktext
        // linktext - it will match the entire text of the link
        // partial linktext - it will match the partial text of the link
        // if there are two links with same text - linktext will throw an exception
        // but partial linktext will click on the first matching link

        // class name locator
        driver.navigate().back();
        List<WebElement> headerLinks = driver.findElements(By.className("_2-LWwB"));
        System.out.println("number of header links: " + headerLinks.size());
        for (WebElement link : headerLinks) {
            System.out.println(link.getText());
        }

        // tagname locator
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("number of links on the page: " + allLinks.size());
        for (WebElement link : allLinks) {
            System.out.println(link.getText());
        }

        List<WebElement> allImages = driver.findElements(By.tagName("img"));
        System.out.println("number of images on the page: " + allImages.size());
        for (WebElement img : allImages) {
            System.out.println(img.getAttribute("src"));
        }

        driver.quit();

    }
}

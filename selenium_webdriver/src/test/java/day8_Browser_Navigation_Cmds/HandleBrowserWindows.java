package day8_Browser_Navigation_Cmds;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {
    public static void main(String[] args) {
        System.out.println("Handle Browser Windows");
        System.out.println("************************");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(
                "//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[2]/footer/div/div[3]/div[1]/div[2]/a[1]"))
                .click();
        // driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[2]/footer/div/div[3]/div[1]/div[2]/a[2]")).click();
        driver.findElement(By.xpath(
                "//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[2]/footer/div/div[3]/div[1]/div[2]/a[3]"))
                .click();
        // Get the window handles
        Set<String> windowIDs = driver.getWindowHandles();

        // Approach 1
        // Convert the Set to a List to access by index
        List<String> windowIDsList = new ArrayList<>(windowIDs);

        // Assuming there are three windows, get their IDs
        String parentWindowID = windowIDsList.get(0);
        String childWindowID = windowIDsList.get(1);
        String thirdWindowID = windowIDsList.get(2);

        // Switch to parent window and print its title
        driver.switchTo().window(parentWindowID);
        System.out.println("************************");
        System.out.println("Parent Window ID: " + parentWindowID);
        System.out.println(driver.getCurrentUrl());
        System.out.println("Parent Window Title: " + driver.getTitle());
        System.out.println("************************");

        // Switch to child window and print its title
        driver.switchTo().window(childWindowID);
        System.out.println("************************");
        System.out.println("Child Window ID: " + childWindowID);
        System.out.println(driver.getCurrentUrl());
        System.out.println("Child Window Title: " + driver.getTitle());
        System.out.println("************************");

        // Switch to third window and print its title
        driver.switchTo().window(thirdWindowID);
        System.out.println("************************");
        System.out.println("Third Window ID: " + thirdWindowID);
        System.out.println(driver.getCurrentUrl());
        System.out.println("Third Window Title: " + driver.getTitle());
        System.out.println("************************");

        // Approach 2
        for (String windowID : windowIDs) {
            // Switch to each window
            // driver.switchTo().window(windowID);
            driver.switchTo().window(windowID).getTitle();
            // Print the window ID and title
            System.out.println("Window ID: " + windowID);
            System.out.println("Window Title: " + driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            System.out.println("************************");
        }

        for (String windowID : windowIDs) {
            String title = driver.switchTo().window(windowID).getTitle();
            String url = driver.getCurrentUrl();
            if (driver.getTitle().equals("Shop Online for Mens & Womens Fashion, Beauty, Home, & More | Shopsy")) {
                System.out.println("Found the desired window with title: " + title);
                System.out.println("URL: " + url);
                break;
            }
        }

        driver.quit();

    }
}

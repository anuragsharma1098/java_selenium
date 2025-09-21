package day8_Browser_Navigation_Cmds;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindow {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open multiple tabs
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.TAB)
                .get("https://www.facebook.com/");
        driver.switchTo().newWindow(WindowType.TAB)
                .get("https://www.amazon.com/");

        // Get the window handles of all the open tabs
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Iterate through the window handles and print the titles
        for (String handle : allWindowHandles) {
            System.out.println("---------------");
            String title = driver.switchTo()
                    .window(handle).getTitle();
            System.out.println(handle);
            System.out.println(driver.getCurrentUrl());
            System.out.println(title);
            System.out.println("---------------");
        }

        // Close the tab with title "Facebook – log in or sign up"
        for (String handle : allWindowHandles) {
            String title = driver.switchTo().window(handle).getTitle();
            if (title.equals("Facebook – log in or sign up")) {
                driver.close();
                break;
            }
        }

        // Verify the tab is closed by printing the titles of remaining tabs
        Set<String> allWindowHandlesAfterClosing = driver
                .getWindowHandles();
        for (String handle : allWindowHandlesAfterClosing) {
            System.out.println("---------------");
            String title = driver.switchTo().window(handle)
                    .getTitle();
            System.out.println(handle);
            System.out.println(driver.getCurrentUrl());
            System.out.println(title);
            System.out.println("---------------");
        }
        driver.quit();
    }
}

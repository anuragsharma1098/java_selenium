package day11_HandleDropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch_AutoSuggestDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        Thread.sleep(5000);
        List<WebElement> suggList = driver.findElements(By
                .xpath("//ul[@role='listbox']//li//div[@role='option']"));
        System.out.println("Total Suggestion: " + suggList.size());
        for (WebElement e : suggList) {
            System.out.println(e.getText());
        }
        for (WebElement e : suggList) {
            System.out.println(e.getText());
            if (e.getText().equals("selenium")) {
                e.click();
                break;
            }
        }
        Thread.sleep(5000);
        driver.quit();

    }
}

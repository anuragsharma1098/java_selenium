package day8_Browser_Navigation_Cmds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavCmndsHandsOn {
    public static void main(String[] args) {
        System.out.println("Browser Navigation Commands Hands-On");
        // Implementation goes here
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("(//input[@id='Wikipedia1_wikipedia-search-input'])[1]"))
                .sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}

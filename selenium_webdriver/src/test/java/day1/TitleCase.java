package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WindowType;

public class TitleCase {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        String title = driver.getTitle();
        System.out.println(title);
        driver.switchTo().newWindow(WindowType.TAB);//new tab
        driver.get("https://www.amazon.com/");
        String title1 = driver.getTitle();
        System.out.println(title1);
        driver.quit();
    }
}

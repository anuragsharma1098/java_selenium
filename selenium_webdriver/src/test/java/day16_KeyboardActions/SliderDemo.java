package day16_KeyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.get("https://jqueryui.com/slider/");
        WebElement ifrm = driver.findElement(By
                .xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(ifrm);
        // min slider
        WebElement init_sli = driver.findElement(By
                .xpath("//*[@id=\"slider\"]/span"));
        System.out.println("Initial position of slider: "
                + init_sli.getLocation());
        Actions act = new Actions(driver);
        act.dragAndDropBy(init_sli, 50, 4).perform();
        System.out.println("Position of slider after movement: "
                + init_sli.getLocation());
    }
}

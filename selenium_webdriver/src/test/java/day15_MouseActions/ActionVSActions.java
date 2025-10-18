package day15_MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionVSActions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement button = driver.findElement(By
                .xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions act = new Actions(driver);
        // creating and storing action in a variable
        Action myaction = act.contextClick(button).build();
        // performing action
        myaction.perform();
    }
}

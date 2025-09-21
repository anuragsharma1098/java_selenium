package day9_CheckBox_Alerts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBoxes {
    public static void main(String[] args) {
        System.out.println("Handle Check Boxes");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // select specific check boxes
        driver.findElement(By.xpath("//*[@id=\"sunday\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"monday\"]")).click();

        // select all check boxes
        List<WebElement> chkbox = driver
                .findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        System.out.println("Total check boxes: " + chkbox.size());
        
        // // 1st way
        // for (WebElement e : chkbox) {
        //     e.click();
        // }
        // // 2nd way
        // for(int i=0; i<chkbox.size(); i++) {
        // chkbox.get(i).click();
        // }
        // // 3rd way
        // chkbox.forEach(e -> e.click());
        
        //select all check boxes which are not selected
        // 1st way
        // for (int i = 0; i < chkbox.size(); i++) {
        //     if (!chkbox.get(i).isSelected()) {
        //         chkbox.get(i).click();
        //     }
        // }

        // // select only those check boxes which are not selected
        // // 2nd way
        // for (WebElement e : chkbox) {
        //     if (!e.isSelected()) {
        //         e.click();
        //     }
        // }

    }
}

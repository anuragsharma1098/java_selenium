package day13_DynamicPaginationWebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/TlbeVW/");
        driver.findElement(By
                .xpath("//*[@id=\"input-username\"]")).sendKeys("demo");
        driver.findElement(By
                .xpath("//*[@id=\"input-password\"]")).sendKeys("demo");
        driver.findElement(By
                .xpath("//*[@id=\"form-login\"]/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-customer\"]/a")).click();

    }
}

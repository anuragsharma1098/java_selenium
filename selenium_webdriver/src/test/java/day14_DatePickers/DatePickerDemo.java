package day14_DatePickers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");

        // switch to frame
        driver.switchTo().frame(0);

        // Method 1: using sendKeys()
        driver.findElement(By
                .xpath("//*[@id=\"datepicker\"]"))
                .sendKeys("10/05/2025"); // MM/DD/YYYY

        // Method 2: using date picker
        String year = "2025";
        String month = "December";
        String day = "05";
        driver.findElement(By
                .xpath("//*[@id=\"datepicker\"]")).click();
        while (true) {
            String curr_month = driver.findElement(By
                    .xpath("//span[@class='ui-datepicker-month']"))
                    .getText();
            String curr_year = driver.findElement(By
                    .xpath("//span[@class='ui-datepicker-year']"))
                    .getText();
            if (curr_month.equals(month) && curr_year.equals(year)) {
                break;
            } else
            // click on next button
                driver.findElement(By
                        .xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span"))
                        .click();

        }
    }
}

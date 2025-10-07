package day14_DatePickers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // input date
        String year = "1990";
        String month = "January";
        String date = "1";
        driver.findElement(By.xpath("//*[@id=\"txtDate\"]")).click();
        // select year
        WebElement yeardrpdwn = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select selectyear = new Select(yeardrpdwn);
        selectyear.selectByValue(year);
    }
}

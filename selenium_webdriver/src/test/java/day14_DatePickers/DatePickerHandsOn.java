package day14_DatePickers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerHandsOn {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.get("https://dummy-tickets.com/buyticket");

    }
}

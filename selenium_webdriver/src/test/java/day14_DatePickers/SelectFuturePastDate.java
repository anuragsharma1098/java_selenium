package day14_DatePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectFuturePastDate {
    // Method to select future date
    static void select_future_date(WebDriver driver, String month, String year, String date) {
        while (true) {
            String curr_month = driver.findElement(By
                    .xpath("//span[@class='ui-datepicker-month']"))
                    .getText();
            String curr_year = driver.findElement(By
                    .xpath("//span[@class='ui-datepicker-year']"))
                    .getText();
            if (curr_month.equals(month) && curr_year.equals(year)) {
                break;
            }
            // click on next button
            driver.findElement(By
                    .xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span"))
                    .click();

        }
        List<WebElement> dates = driver.findElements(By
                .xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement ele : dates) {
            String dt = ele.getText();
            if (dt.equals(date)) {
                ele.click();
                break;
            }
        }
    }
    // Method to selct past date
    static void select_past_date(WebDriver driver, String month, String year, String date) {
        while (true) {
            String curr_month = driver.findElement(By
                    .xpath("//span[@class='ui-datepicker-month']"))
                    .getText();
            String curr_year = driver.findElement(By
                    .xpath("//span[@class='ui-datepicker-year']"))
                    .getText();
            if (curr_month.equals(month) && curr_year.equals(year)) {
                break;
            }
            // click on previous button
            driver.findElement(By
                    .xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span"))
                    .click();

        }
        List<WebElement> dates = driver.findElements(By
                .xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement ele : dates) {
            String dt = ele.getText();
            if (dt.equals(date)) {
                ele.click();
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");
        // switch to frame
        driver.switchTo().frame(0);
        driver.findElement(By
                .xpath("//*[@id=\"datepicker\"]"))
                .click();
        select_future_date(driver, "December", "2035", "14");
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://jqueryui.com/datepicker/");
        // switch to frame
        driver.switchTo().frame(0);
        driver.findElement(By
                .xpath("//*[@id=\"datepicker\"]"))
                .click();
        select_past_date(driver, "October", "2022", "10");
        Thread.sleep(5000);
        driver.quit();
    }
}

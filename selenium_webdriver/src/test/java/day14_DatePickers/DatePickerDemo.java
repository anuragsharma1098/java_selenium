package day14_DatePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {

        static void select_month_year(WebDriver driver, String month, String year) {
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

        static void select_date(WebDriver driver, String date) {
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
                                .sendKeys("12/15/2026"); // MM/DD/YYYY

                // Method 2: using date picker;
                driver.switchTo().newWindow(WindowType.TAB);
                driver.get("https://jqueryui.com/datepicker/");
                // switch to frame
                driver.switchTo().frame(0);

                String year = "2026";
                String month = "December";
                String date = "16";
                driver.findElement(By
                                .xpath("//*[@id=\"datepicker\"]")).click();
                select_month_year(driver, month, year);
                select_date(driver, date);

        }
}

package day14_DatePickers;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {
    static Month converMonth(String month) {
        HashMap<String, Month> monthMap = new HashMap<String, Month>();
        monthMap.put("Jan", Month.JANUARY);
        monthMap.put("Feb", Month.FEBRUARY);
        monthMap.put("Mar", Month.MARCH);
        monthMap.put("Apr", Month.APRIL);
        monthMap.put("May", Month.MAY);
        monthMap.put("Jun", Month.JUNE);
        monthMap.put("Jul", Month.JULY);
        monthMap.put("Aug", Month.AUGUST);
        monthMap.put("Sep", Month.SEPTEMBER);
        monthMap.put("Oct", Month.OCTOBER);
        monthMap.put("Nov", Month.NOVEMBER);
        monthMap.put("Dec", Month.DECEMBER);
        Month vmonth = monthMap.get(month);
        if (vmonth == null) {
            System.out.println("Invalid month...");
        }
        return vmonth;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        // input date
        String req_year = "2015";
        String req_month = "Mar";
        String rq_date = "1";
        driver.findElement(By.xpath("//*[@id=\"txtDate\"]")).click();

        // select year
        WebElement yeardrpdwn = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select selectyear = new Select(yeardrpdwn);
        selectyear.selectByValue(req_year);

        // // select month
        // WebElement monthdrpdwn = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        // Select selectmonth = new Select(monthdrpdwn);
        // selectmonth.selectByVisibleText(req_month);

        String curr_month = driver.findElement(By.xpath("//select[@aria-label='Select month']")).getText();
        System.out.println("Current month: " + curr_month);

        driver.quit();
    }
}

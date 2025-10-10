package day14_DatePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerHandsOn {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration
                .ofSeconds(10));
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        driver.findElement(By.xpath("//input[@id='product_549']")).click();
        driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("Firstname");
        driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("Lastname");
        driver.findElement(By.xpath("//textarea[@id='order_comments']")).sendKeys("Other Notes Optional");
        driver.findElement(By.xpath("//input[@id='dob']")).click();
        String req_date = "1";
        // select year
        WebElement yeardrpdwn = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        Select selectyear = new Select(yeardrpdwn);
        selectyear.selectByValue("1990");
        // selct month
        WebElement monthdrpdwn = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select selectmonth = new Select(monthdrpdwn);
        selectmonth.selectByVisibleText("Jan");
        //select date
        List<WebElement> dates = driver.findElements(By
                                .xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody//td/a"));
                for (WebElement ele : dates) {
                        String dt = ele.getText();
                        if (dt.equals(req_date)) {
                                ele.click();
                                break;
                        }
                }


    }
}

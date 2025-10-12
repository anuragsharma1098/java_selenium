package day14_DatePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CummulativeHandsOn {

        public static void DatePicker(WebDriver driver, String dd, String mm, String yy) {
                // select year
                WebElement yeardrpdwn = driver.findElement(By
                                .xpath("//select[@aria-label='Select year']"));
                Select selectyear = new Select(yeardrpdwn);
                selectyear.selectByValue(yy);
                // selct month
                WebElement monthdrpdwn = driver.findElement(By
                                .xpath("//select[@aria-label='Select month']"));
                Select selectmonth = new Select(monthdrpdwn);
                selectmonth.selectByVisibleText(mm);
                // select date
                List<WebElement> dates = driver.findElements(By
                                .xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody//td/a"));
                for (WebElement ele : dates) {
                        String dt = ele.getText();
                        if (dt.equals(dd)) {
                                ele.click();
                                break;
                        }
                }
        }

        public static void main(String[] args) {
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration
                                .ofSeconds(10));
                driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
                driver.findElement(By.xpath("//input[@id='product_549']"))
                                .click();
                driver.findElement(By.xpath("//input[@id='travname']"))
                                .sendKeys("Firstname");
                driver.findElement(By.xpath("//input[@id='travlastname']"))
                                .sendKeys("Lastname");
                driver.findElement(By.xpath("//textarea[@id='order_comments']"))
                                .sendKeys("Other Notes Optional");
                driver.findElement(By.xpath("//input[@id='dob']")).click();
                // select dob
                String dd = "1";
                String mm = "Jan";
                String yy = "1990";
                DatePicker(driver, dd, mm, yy);

                // select sex
                driver.findElement(By
                                .xpath("//*[@id=\"sex_2\"]"))
                                .click();
                // add more traveller
                driver.findElement(By
                                .xpath("//input[@id='addmorepax']"))
                                .click();
                // open hidden dropdown
                driver.findElement(By
                                .xpath("//span[@id='select2-addpaxno-container']"))
                                .click();
                // select second option using debugger xpath
                driver.findElement(By
                                .xpath("/html/body/span/span/span[2]/ul/li[2]"))
                                .click();
                // enter details of traveller
                driver.findElement(By.xpath("//input[@id='travname2']"))
                                .sendKeys("Firstname");
                driver.findElement(By.xpath("//input[@id='travlastname2']"))
                                .sendKeys("Lastname");
                // select dob of second traveller
                driver.findElement(By.xpath("//*[@id=\"dob2\"]"))
                                .click();
                String dd1 = "14";
                String mm1 = "Feb";
                String yy1 = "1995";
                DatePicker(driver, dd1, mm1, yy1);
                // select sex of traveller 2
                driver.findElement(By.xpath("//input[@id='sex2_2']"))
                                .click();
                // select passenger type
                driver.findElement(By.xpath("//span[@id='select2-paxtype2-container']"))
                                .click();
                driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]"))
                                .click();
                // select trip type
                driver.findElement(By.xpath("//input[@id='traveltype_2']"))
                                .click();
                // select from city
                driver.findElement(By.xpath("//input[@id='fromcity']"))
                                .sendKeys("DEL");
                // select to city
                driver.findElement(By.xpath("//input[@id='tocity']"))
                                .sendKeys("LKO");
                // select departure date
                driver.findElement(By.xpath("//input[@id='departon']"))
                                .click();
                String depart_date = "21";
                String depart_month = "Apr";
                String depart_year = "2026";
                DatePicker(driver, depart_date, depart_month, depart_year);
                // select return date
                driver.findElement(By.xpath("//input[@id='returndate']"))
                                .click();
                String rt_date = "29";
                String rt_month = "Apr";
                String rt_year = "2026";
                DatePicker(driver, rt_date, rt_month, rt_year);
                // add aditional information
                driver.findElement(By.xpath("//textarea[@id='notes']"))
                                .sendKeys("Additional Information");
                // purpose of dummy ticket
                driver.findElement(By.xpath("//*[@id=\"select2-reasondummy-container\"]"))
                                .click();
                driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]"))
                                .click();
                // Appointment / Submission date
                driver.findElement(By.xpath("//input[@id='appoinmentdate']"))
                                .click();
                String app_dd = "15";
                String app_mm = "Jan";
                String app_yy = "2026";
                DatePicker(driver, app_dd, app_mm, app_yy);
                // how will you receive the dummy tkt
                driver.findElement(By.xpath("//input[@id='deliverymethod_3']"))
                                .click();
                // billing details
                // billing name
                driver.findElement(By.xpath("//input[@id='billname']"))
                                .sendKeys("Billing name");
                // phone
                driver.findElement(By.xpath("//input[@id='billing_phone']"))
                                .sendKeys("9876543210");
                // email
                driver.findElement(By.xpath("//input[@id='billing_email']"))
                                .sendKeys("email@mail.com");
                // country
                driver.findElement(By.xpath("//*[@id=\"select2-billing_country-container\"]"))
                                .click();
                driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[103]"))
                                .click();
                // street address
                driver.findElement(By.xpath("//input[@id='billing_address_1']"))
                                .sendKeys("House No Street name");
                driver.findElement(By.xpath("//input[@id='billing_address_2']"))
                                .sendKeys("Apartment suite unit");
                // town city
                driver.findElement(By.xpath("//input[@id='billing_city']"))
                                .sendKeys("Cityname");
                // state
                driver.findElement(By.xpath("//*[@id=\"select2-billing_state-container\"]"))
                                .click();
                driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[29]")).click();
                // pin code
                driver.findElement(By.xpath("//input[@id='billing_postcode']"))
                                .sendKeys("111111");
                // additional information
                driver.findElement(By.xpath("//textarea[@id='order_comments']"))
                                .sendKeys("Notes about order");
                // place order
                driver.findElement(By.xpath("//button[@id='place_order']"))
                                .submit();;

                driver.quit();

        }
}
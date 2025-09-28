package day11_HandleDropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // go to link
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // login
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // cick on PIM
        driver.findElement((By.xpath("//span[normalize-space()='PIM']"))).click();
        // some may not work
        // click on dropdown
        driver.findElement(By.xpath(
                "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div/div[2]/i"))
                .click();
        Thread.sleep(5000);

        // select single option
        driver.findElement(By.xpath("//span[normalize-space()='Accountant assistant']")).click();

        // count no of options
        List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
        System.out.println("No of options: " + options.size());

        // print all options
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        driver.quit();

    }
}

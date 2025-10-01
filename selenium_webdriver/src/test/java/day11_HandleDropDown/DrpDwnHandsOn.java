package day11_HandleDropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DrpDwnHandsOn {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        
        
        // HAndling Country DropDown
        // go to link
        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
        WebElement country_option = driver.findElement(By.xpath("//*[@id=\"country-list\"]"));
        Select dropdown_country = new Select(country_option);
        // count of options
        System.out.println("Total no. of options: " +
                dropdown_country.getOptions().size());
        // printing options
        for (WebElement option : dropdown_country.getOptions()) {
            System.out.println(option.getText());
        }
        // select country
        dropdown_country.selectByVisibleText("India");

        
        
        // Hidden DropDown HandsOn
        // go to link
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // login
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // cick on PIM
        driver.findElement((By.xpath("//span[normalize-space()='PIM']"))).click();
        // click on EmployeStatus dropdown
        driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div"))
                .click();
        // select any one option
        driver.findElement(By.xpath("//span[normalize-space()='Full-Time Permanent']")).click();
        Thread.sleep(5000);

        
        
        // MultiSelect DropDown
        // go to link
        driver.get("https://testautomationpractice.blogspot.com/");
        // WebElement multi_select = driver.findElement(By.xpath("//select[@id='colors']"));
        Actions actions = new Actions(driver);
        // actions.keyDown(Keys.CONTROL); // for windows
        actions.keyDown(Keys.COMMAND)
                .click(driver.findElement(By.xpath("//*[@id=\"colors\"]/option[1]")))
                .click(driver.findElement(By.xpath("//*[@id=\"colors\"]/option[2]")))
                .click(driver.findElement(By.xpath("//option[@value='yellow']")))
                .click(driver.findElement(By.xpath("//option[@value='green']")))
                .click(driver.findElement(By.xpath("//*[@id=\"colors\"]/option[7]")))
                .keyUp(Keys.COMMAND)
                .build()
                .perform();
        Thread.sleep(5000);
        driver.quit();

    }

}

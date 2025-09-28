package day11_HandleDropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement drpcntry = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        Select drpctry = new Select(drpcntry);
        // select option from dropdown
        drpctry.selectByVisibleText("France");
        drpctry.selectByValue("usa");
        drpctry.selectByIndex(2);

        // capture options from drop down
        List<WebElement> options = drpctry.getOptions();
        System.out.println("Total no. of options: " + options.size());

        // printing options
        // 1st way
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        // // 2nd way
        // for (int i = 0; i < options.size(); i++) {
        //     System.out.println(options.get(i).getText());
        // }

        driver.quit();

    }
}

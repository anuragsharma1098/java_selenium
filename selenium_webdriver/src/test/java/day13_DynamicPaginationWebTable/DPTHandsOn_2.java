package day13_DynamicPaginationWebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DPTHandsOn_2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // go to link
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // login
        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();
        String tot_rec = driver
                .findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText();
        System.out.println(tot_rec);
        int total_records = Integer.parseInt(tot_rec.substring(tot_rec.indexOf("(") + 1, tot_rec.indexOf(")")));
        System.out.println(total_records);
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
        System.out.println(driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]"))
                .getText() + "\t\t || " +
                driver.findElement(By
                        .xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[3]"))
                        .getText());
        for (int i = 1; i <= total_records; i++)
            System.out.println(driver
                    .findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[" + i
                            + "]/div/div[2]"))
                    .getText() +
                    "\t\t || " +
                    driver.findElement(
                            By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[" + i
                                    + "]/div/div[3]"))
                            .getText());

        driver.quit();
    }
}

package day13_DynamicPaginationWebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {
        public static void main(String[] args) {
                WebDriver driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                // driver.get("https://www.opencart.com/index.php?route=cms/demo");
                // driver.findElement(By.xpath("//*[@id=\"cms-demo\"]/div[2]/div/div[2]/div/a")).click();
                driver.get("https://demo.opencart.com/TlbeVW/");
                WebElement username = driver.findElement(By
                                .xpath("//*[@id=\"input-username\"]"));
                username.clear();
                username.sendKeys("demo");
                WebElement password = driver.findElement(By
                                .xpath("//*[@id=\"input-password\"]"));
                password.clear();
                password.sendKeys("demo");
                // driver.findElement(By
                // .xpath("//*[@id=\"input-username\"]"))
                // .sendKeys("demo");
                // driver.findElement(By
                // .xpath("//*[@id=\"input-password\"]"))
                // .sendKeys("demo");
                driver.findElement(By
                                .xpath("//*[@id=\"form-login\"]/div[3]/button"))
                                .click();
                if (driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
                        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
                }
                driver.findElement(By.xpath("//*[@id=\"menu-customer\"]/a"))
                                .click();
                driver.findElement(By.xpath("//*[@id=\"collapse-5\"]/li[1]/a")).click();
                String text = driver.findElement(By.xpath("div[contains(text(),'Showing')]")).getText();
                int total_pages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));

                // repeating pages
                for (int p = 1; p <= total_pages; p++) {
                        if (p > 1) {
                                WebElement active_page = driver.findElement(
                                                By.xpath("//ul[@class='pagination']//*[test()=" + p + "]"));
                                active_page.click();
                        }
                        // reading data from the page
                        int rows = driver.findElements(
                                        By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"))
                                        .size();
                        for (int r = 1; r <= rows; r++) {
                                String customer_name = driver.findElement(By
                                                .xpath("//table[@class='table table-bordered table-hover']//tbody//tr["
                                                                + r + "]/td[2]"))
                                                .getText();
                                String customer_email = driver.findElement(By
                                                .xpath("//table[@class='table table-bordered table-hover']//tbody//tr["
                                                                + r + "]/td[3]"))
                                                .getText();
                                String customer_status = driver.findElement(By
                                                .xpath("//table[@class='table table-bordered table-hover']//tbody//tr["
                                                                + r + "]/td[5]"))
                                                .getText();
                                System.out.println(customer_name + " \t || \t " + customer_email + " \t || \t "
                                                + customer_status);
                        }
                }

                driver.quit();

        }
}

package day13_DynamicPaginationWebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DPTHandsOn {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        List<WebElement> t_p = driver.findElements(By.xpath("//*[@id=\"pagination\"]//li"));
        System.out.println(t_p.size());
        for (int p = 1; p <= t_p.size(); p++) {
            WebElement c_p = driver.findElement(By.xpath("//*[@id=\"pagination\"]/li[" + p + "]"));
            c_p.click();
            List<WebElement> r = driver.findElements(By.xpath("//*[@id=\"productTable\"]/tbody/tr"));
            System.out.println("Page " + p + " has " + r.size() + " rows");
            List<WebElement> c = driver.findElements(By.xpath("//*[@id=\"productTable\"]/thead/tr/th"));
            System.out.println("Page " + p + " has " + c.size() + " columns");
            if (p == 1) {
                for (int h = 1; h <= c.size(); h++) {
                    String head = driver.findElement(By.xpath("//*[@id=\"productTable\"]/thead/tr/th[" + h + "]"))
                            .getText();
                    System.out.print(head + "\t\t\t || ");
                }

            }
            System.out.println();

            for (int ro = 1; ro <= r.size(); ro++) {
                for (int co = 1; co <= c.size(); co++) {
                    if (co < c.size()) {
                        String value = driver
                                .findElement(By.xpath("//*[@id=\"productTable\"]/tbody/tr[" + ro + "]/td[" + co + "]"))
                                .getText();
                        System.out.print(value + "\t\t\t || ");
                    } else {
                        WebElement chkbx = driver.findElement(
                                By.xpath(
                                        "/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[5]/div[1]/div/table/tbody/tr["
                                                + ro + "]/td[" + co + "]/input"));
                        if (!chkbx.isSelected()) {
                            chkbx.click();
                            Boolean status = chkbx.isSelected();
                            System.out.print(status + "\t\t\t || ");
                        }

                    }
                }
                System.out.println();
            }
        }

        driver.quit();

    }
}

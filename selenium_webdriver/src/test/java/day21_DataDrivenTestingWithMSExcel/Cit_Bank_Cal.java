package day21_DataDrivenTestingWithMSExcel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cit_Bank_Cal {
        public static void main(String[] args) throws IOException, InterruptedException {
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
                driver.get(
                                "https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
                driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")).click();
                String filePath = "C:\\Users\\anura\\Desktop\\java_selenium\\selenium_webdriver\\testdata\\cit_bankcal.xlsx";
                int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
                for (int r = 1; r <= rows; r++) {
                        // read data from excel
                        String depositAmount = ExcelUtils.getCellData(filePath, "Sheet1", r, 0);
                        String term = ExcelUtils.getCellData(filePath, "Sheet1", r, 1);
                        String interest = ExcelUtils.getCellData(filePath, "Sheet1", r, 2);
                        String compounding = ExcelUtils.getCellData(filePath, "Sheet1", r, 3);
                        String expectedMaturityValue = ExcelUtils.getCellData(filePath, "Sheet1", r, 4);

                        // Code to interact with the web page and perform calculations would go here
                        WebElement deposit_amt = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
                        deposit_amt.clear();
                        deposit_amt.sendKeys(depositAmount);
                        WebElement termm = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
                        termm.clear();
                        termm.sendKeys(term);
                        // interest not going correct on webpage(need to fix)
                        WebElement interestt = driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]"));
                        interestt.clear();
                        interestt.sendKeys(interest);
                        driver.findElement(By.xpath("//*[@id=\"mat-select-value-1\"]")).click();
                        driver.findElement(By.xpath("//*[@id=\"mat-option-1\"]/span")).click();
                        Thread.sleep(4000);
                        driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();
                        String actualMaturityValue = driver.findElement(By.xpath("//span[@id='displayTotalValue']"))
                                        .getText();
                        ExcelUtils.setCellData(filePath, "Sheet1", r, 5, actualMaturityValue);
                        if (actualMaturityValue.equals(expectedMaturityValue)) {
                                ExcelUtils.setCellData(filePath, "Sheet1", r, 7, "Pass");
                                ExcelUtils.fillGreenColor(filePath, "Sheet1", r, 7);
                        } else {
                                ExcelUtils.setCellData(filePath, "Sheet1", r, 7, "Fail");
                                ExcelUtils.fillRedColor(filePath, "Sheet1", r, 7);
                        }

                }
                driver.quit();
        }
}
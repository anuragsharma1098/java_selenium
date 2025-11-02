package day21_DataDrivenTestingWithMSExcel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.get(
                "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
        driver.findElement(By.xpath("//*[@id=\"wzrk-cancel\"]")).click(); // to close the popup 
        String filePath = "C:\\Users\\anura\\Desktop\\java_selenium\\selenium_webdriver\\testdata\\fd_data.xlsx";
        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
        for (int r = 1; r <= rows; r++) {
            // read data from excel
            String principal = ExcelUtils.getCellData(filePath, "Sheet1", r, 0);
            String rateOfInterest = ExcelUtils.getCellData(filePath, "Sheet1", r, 1);
            String period = ExcelUtils.getCellData(filePath, "Sheet1", r, 2);
            String periodType = ExcelUtils.getCellData(filePath, "Sheet1", r, 3);
            String frequency = ExcelUtils.getCellData(filePath, "Sheet1", r, 4);
            String expectedMaturityValue = ExcelUtils.getCellData(filePath, "Sheet1", r, 5);

            // Code to interact with the web page and perform calculations would go here
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principal);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period);
            Select periodTypdrp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            periodTypdrp.selectByContainsVisibleText(periodType);
            Select frequencydrp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            frequencydrp.selectByContainsVisibleText(frequency);
            driver.findElement(
                    By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"))
                    .click();
            String actualMaturityValue = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]//strong")).getText();
            ExcelUtils.setCellData(filePath, "Sheet1", r, 8, actualMaturityValue);
            // After getting the actual maturity value from the web page validate with
            if (Double.parseDouble(actualMaturityValue) == Double.parseDouble(expectedMaturityValue)) {
                ExcelUtils.setCellData(filePath, "Sheet1", r, 7, "Pass");
                ExcelUtils.fillGreenColor(filePath, "Sheet1", r, 7);
            } else {
                ExcelUtils.setCellData(filePath, "Sheet1", r, 7, "Fail");
                ExcelUtils.fillRedColor(filePath, "Sheet1", r, 7);
            }
            Thread.sleep(5000);
            driver.findElement(By.xpath("//img[@class='PL5']")).click(); // Click on Reset button
        }
        driver.quit();
    }
}

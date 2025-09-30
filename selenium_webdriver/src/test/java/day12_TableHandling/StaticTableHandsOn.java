package day12_TableHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticTableHandsOn {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");
        WebElement departure_country = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departure = new Select(departure_country);
        departure.selectByVisibleText("Boston");

        WebElement destination_country = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select destination = new Select(destination_country);
        destination.selectByVisibleText("Berlin");

        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
        List<WebElement> roList = driver.findElements(By.xpath("/html/body/div[2]/table//tr"));
        System.out.println("Total no of rows: " + roList.size());
        List<WebElement> coList = driver.findElements(By.xpath("/html/body/div[2]/table//th"));
        System.out.println("Total no of columns: " + coList.size());
        double priceList[] = new double[roList.size()];

        for (int r = 1; r < roList.size(); r++) {
            String value = driver.findElement(By
                    .xpath("/html/body/div[2]/table//tr[" + r + "]//td[6]")).getText();
            System.out.println(value);
            double price = Double.parseDouble(value.replace("$", ""));
            priceList[r] = price;
        }
        int index = 1;
        for (int i = 1; i < roList.size(); i++) {
            if (priceList[i] < priceList[index]) {
                index = i;
            }
        }
        System.out.println("The lowest price is: " + priceList[index] + "\n Index: " + index);
        driver.findElement(By.xpath("//tbody/tr[" + index + "]/td[1]/input[1]")).click();
        driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("123 Main St");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("NY");
        driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("10001");
        WebElement cardType = driver.findElement(By.xpath("//select[@id='cardType']"));
        Select card = new Select(cardType);
        card.selectByVisibleText("Visa");
        driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("4111111111111111");
        driver.findElement(By.xpath("//input[@id='creditCardMonth']")).clear();
        driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@id='creditCardYear']")).clear();
        driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2025");
        driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        String confirmation = driver
                .findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']"))
                .getText();
        if (confirmation.equals("Thank you for your purchase today!")) {
            System.out.println("Test case passed");
        } else {
            System.out.println("Test case failed");
        }
        driver.quit();
    }
}

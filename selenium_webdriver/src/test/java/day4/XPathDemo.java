package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        // Asolute XPath of flipkart search box
        // /html/body/div[1]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input
        // Relative XPath of flipkart search box
        // //*[@id="container"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input
        // Diff between absolute and relative xpath
        // Absolute xpath starts with single slash(/) and relative xpath starts with double slash(//
        // Absolute xpath is not recommended to use because if there is any change in the web page then it will not work
        // Relative xpath is recommended to use because it is more flexible and if there is any change
        //  in the web page then it will still work  

        // Relative xpath with single attribute
        driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("MacBook M1 Pro");
        Thread.sleep(2000);

        // Relative xpath with multiple attributes
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='q'][@placeholder='Search for Products, Brands and More']")).sendKeys("MacBook M2 Pro");
        Thread.sleep(2000);

        // and and or operator in xpath
        // and operator - both conditions should be true
        // or operator - at least one condition should be true
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='q' and @placeholder='Search for Products, Brands and More']")).sendKeys("MacBook M3 Pro");
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='qergs' or @placeholder='Search for Products, Brands and More']")).sendKeys("MacBook M4 Pro");
        Thread.sleep(2000);

        // xpath with text() function
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Mobiles & Tablets']")).click();
        Thread.sleep(2000);

        // xpath with contains() function
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[contains(@placeholder,'Search for Products')]")).sendKeys("MacBook M4");
        Thread.sleep(2000);

        // xpath with starts-with() function
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search for')]")).sendKeys("MacBook M3");
        Thread.sleep(2000);

        // xpath with ends-with() function - not available in selenium

        // diff contains() vs starts-with()
        // contains() - can be used to find a substring in a string
        // starts-with() - can be used to find a prefix in a string

        // chained xpath
        driver.navigate().refresh();
        Thread.sleep(2000);
        boolean status = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[1]/a/picture/img")).isDisplayed();
        System.out.println(status);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[1]/a/picture/img")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}

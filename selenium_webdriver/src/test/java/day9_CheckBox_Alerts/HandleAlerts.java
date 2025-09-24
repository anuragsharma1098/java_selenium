package day9_CheckBox_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // 1-> normal alert with OK button
        driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

        // storing alert in variable
        driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
        Alert myalert = driver.switchTo().alert();
        System.out.println(myalert.getText());
        String al = myalert.getText();
        myalert.accept();
        if (al.equals("I am an alert box!"))
            System.out.println("Correct");

        // 2-> confirmation alert OK & Cancel
        driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept(); // close alert using OK button
        driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss(); // close alert using cancel button

        // 3-> Prompt Alert having input box
        driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
        Alert prmptalert = driver.switchTo().alert();
        prmptalert.sendKeys("Hello Selenium");
        Thread.sleep(5000);
        prmptalert.accept();

        driver.quit();
    }

}

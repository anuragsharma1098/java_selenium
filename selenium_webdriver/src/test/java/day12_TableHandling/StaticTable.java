package day12_TableHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        // find total no of rows in a table
        List<WebElement> list = driver.findElements(By
                .xpath("//table[@name='BookTable']//tr"));
        System.out.println("Total no of rows: " + list.size());
        int rows = list.size();

        // print the table data
        for (WebElement e : list) {
            System.out.println(e.getText());
        }

        // // use only if one table is there in a webpage
        // int rows = driver.findElements(By.tagName("tr")).size();
        // System.out.println("Total no of rows: " + rows);

        // find total no of columns
        List<WebElement> col = driver.findElements(By
                .xpath("//table[@name='BookTable']//th"));
        System.out.println("Total no of columns: " + col.size());
        int cols = col.size();

        // read data from specific row and column
        WebElement data = driver.findElement(By
                .xpath("//table[@name='BookTable']//tr[5]//td[1]"));
        System.out.println("Data from specific row and column: " + data.getText());

        WebElement data1 = driver.findElement(By
                .xpath("//table[@name='BookTable']//tr[7]//td[3]"));
        System.out.println("Data from specific row and column: " + data1.getText());

        // read the data of each row and column
        for (int r = 2; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                String value = driver.findElement((By
                        .xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]")))
                        .getText();
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        // retreive data based on condition
        // print book name whose autor is mukesh
        System.out.println("Book name whose author is Mukesh:");
        for (int r = 2; r <= rows; r++) {
            String bookname = driver.findElement((By
                    .xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]")))
                    .getText();

            String author = driver.findElement((By
                    .xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]")))
                    .getText();
            if (author.equals("Mukesh")) {
                System.out.println(bookname);
            }
        }

        // find total price of all books
        int total = 0;
        for (int r = 2; r <= rows; r++) {
            String price = driver.findElement((By
                    .xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]")))
                    .getText();
            total = total + Integer.parseInt(price);

        }
        System.out.println("Total price of all books: " + total);

        driver.quit();

    }
}

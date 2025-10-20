package day17_Javascript_Executor_ScrollingPages_UploadFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

        // single file upload
        driver.findElement(By.xpath("//input[@id='filesToUpload']"))
                .sendKeys("File.path");
        // verify file
        if (driver.findElement(By.xpath("//ul[@id='fileList']//li"))
                .getText().equals("filename"))
            System.out.println("File uploaded successfully");
        else
            System.out.println("File upload failed");
        Thread.sleep(5000);

        // multiple files upload
        String file1 = "filepath";
        String file2 = "filepath";
        driver.findElement(By.xpath("//input[@id='filesToUpload']"))
                .sendKeys(file1 + "\n" + file2);
        // verify file
        // validation 1 - no of files
        int nooffilesuploaded = driver.findElements(By
                .xpath("//ul[@id='fileList']//li")).size();
        if (nooffilesuploaded == 2)
            System.out.println("Files uploaded successfully");
        else
            System.out.println("Files upload failed");
        // validation 2 - file names
        if (driver.findElement(By.xpath("//ul[@id='fileList']//li[1]"))
                .getText().equals("file1name")
                && driver.findElement(By.xpath("//ul[@id='fileList']//li[2]"))
                        .getText().equals("file2name"))
            System.out.println("Files uploaded successfully");
        else
            System.out.println("Files upload failed");
        driver.quit();
    }
}

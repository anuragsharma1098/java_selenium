package day20_DataDrivenTestingWithMSExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(
                "C:\\Users\\anura\\Desktop\\java_selenium\\selenium_webdriver\\testdata\\myfile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Welcome");
        row1.createCell(1).setCellValue("to");
        row1.createCell(2).setCellValue("Java");
        row1.createCell(3).setCellValue("Automation");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Welcome");
        row2.createCell(1).setCellValue("to");
        row2.createCell(2).setCellValue("Selenium");

        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("File is created");
    }
}

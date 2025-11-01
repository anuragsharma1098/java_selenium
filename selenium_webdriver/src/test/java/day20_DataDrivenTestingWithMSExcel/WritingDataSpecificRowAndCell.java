package day20_DataDrivenTestingWithMSExcel;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataSpecificRowAndCell {
    public static void main(String[] args) throws Exception {
        FileOutputStream file = new FileOutputStream(
                "C:\\Users\\anura\\Desktop\\java_selenium\\selenium_webdriver\\testdata\\myfile_specific.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        XSSFRow row = sheet.createRow(3);
        XSSFCell cell = row.createCell(4);
        cell.setCellValue("Java Selenium Automation");
        workbook.write(file);
        workbook.close();
        file.close();
    }
}
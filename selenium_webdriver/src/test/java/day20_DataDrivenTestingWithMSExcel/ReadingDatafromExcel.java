package day20_DataDrivenTestingWithMSExcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDatafromExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(
                "C:\\Users\\anura\\Desktop\\java_selenium\\selenium_webdriver\\testdata\\data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        // XSSFSheet sheet = workbook.getSheetAt(0);
        int total_row = sheet.getLastRowNum();
        int total_cell = sheet.getRow(1).getLastCellNum();
        System.out.println("==============================");
        System.out.println("No of rows: " + total_row);
        System.out.println("No of cells: " + total_cell);
        System.out.println("==============================");
        for (int r = 0; r <= total_row; r++) {
            XSSFRow current_row = sheet.getRow(r);
            for (int c = 0; c < total_cell; c++) {
                XSSFCell cell = current_row.getCell(c);
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();
        }
        workbook.close();
        file.close();
    }
}

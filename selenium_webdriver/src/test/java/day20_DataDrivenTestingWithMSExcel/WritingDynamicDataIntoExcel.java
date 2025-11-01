package day20_DataDrivenTestingWithMSExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(
                "C:\\Users\\anura\\Desktop\\java_selenium\\selenium_webdriver\\testdata\\myfile_dynamic.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DynamicData");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter no of cells: ");
        int cells = sc.nextInt();

        for (int r = 1; r <= rows; r++) {
            XSSFRow current_row = sheet.createRow(r);
            for (int c = 0; c < cells; c++) {
                XSSFCell cell = current_row.createCell(c);
                cell.setCellValue(sc.next());
            }
        }
        sc.close();
        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("File is created");
    }
}

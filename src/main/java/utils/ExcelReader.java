package utils;


import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;

public class ExcelReader {
    public static void main(String[] args) {
        String excelFileName = "TestData.xlsx";
        File excelFile = new File(System.getProperty("user.dir") + "/data/" + excelFileName);

        try {
            FileInputStream fis = new FileInputStream(excelFile);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet("Sheet1");
            for (Row row : sheet){
                for (Cell cell : row){
                    System.out.println(cell);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

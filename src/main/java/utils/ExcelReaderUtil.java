package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ExcelReaderUtil {
    private Sheet sheet;
    private int totalRow;
    private int totalColum;


    public ExcelReaderUtil(File excelFileLocation, String sheetName){
        try {
            FileInputStream fis = new FileInputStream(excelFileLocation);
            Workbook workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
            totalRow = sheet.getPhysicalNumberOfRows();
            totalColum = sheet.getRow(0).getPhysicalNumberOfCells();
            fis.close();


        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getCellValue(int rowNo, int columnNo){
        Row row = sheet.getRow(rowNo);
        Cell cell = row.getCell(columnNo);
        String cellValue = "";
        CellType cellType = cell.getCellType();

        if (cellType.equals(CellType.STRING)){
            cellValue = cell.getStringCellValue();
        }

        if (cellType.equals(CellType.NUMERIC)){
            NumberFormat nf = new DecimalFormat("#.####");
            cellValue = String.valueOf(nf.format(cell.getNumericCellValue()));
        }

        return cellValue;
    }

    public int getTotalRow(){
        return this.totalRow;
    }

    public int getTotalColum(){
        return this.totalColum;
    }

    public static void main(String[] args) {
        String excelFileName = "TestData.xlsx";
        File excelFile = new File(System.getProperty("user.dir") + "/data/" + excelFileName);

        ExcelReaderUtil util = new ExcelReaderUtil(excelFile, "Login");
        System.out.println(util.getCellValue(1, 0));
    }

}

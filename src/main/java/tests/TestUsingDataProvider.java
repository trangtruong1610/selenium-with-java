package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Driver.DriverBase;
import utils.ExcelReaderUtil;

import java.io.File;

public class TestUsingDataProvider extends DriverBase {

    @Test(dataProvider = "logindata")
    public void login (String username, String password){
        System.out.println(username);
        System.out.println(password);
       WebDriver driver = getChromedriver();
       LoginPage loginPage = new LoginPage(driver);
       loginPage.Login(username, password);
    }

    @DataProvider
    public Object[][] logindata(){
        //Array with 2rows and 2column
        /*
            tomsmith SuperSecretPassword!
            tomsmith 123
         */

        String excelFileName = "TestData.xlsx";
        File excelFile = new File(System.getProperty("user.dir") + "/data/" + excelFileName);
        String sheetName = "Login";
        int startRowIndex = 1; // read data from row 1 (row 0 is header)
        int startColIndex = 0;
        ExcelReaderUtil util = new ExcelReaderUtil(excelFile, sheetName);
        int totalRow = util.getTotalRow();
        int totalCol = util.getTotalColum();

        // total row included header, so we need create Object with totalRow - startRowIndex(header)
        Object[][] logindata = new Object[totalRow - startRowIndex][totalCol];

        // for from startRow = 1 (row 0 is header)
        for (int startRow = startRowIndex; startRow < totalRow; startRow++){
            for (int startCol = startColIndex; startCol < totalCol; startCol++){
                // startRow - startRowIndex : because startRow = 1 so we need to [startRow - startRowIndex = 0], write data into Object from 0
                logindata[startRow - startRowIndex][startCol] = util.getCellValue(startRow, startCol);
            }

        }
//        logindata[0][0] = "tomsmith";
//        logindata[0][1] = "SuperSecretPassword!";
//
//        logindata[1][0] = "tomsmith";
//        logindata[1][1] = "123";

        return logindata;
    }
}

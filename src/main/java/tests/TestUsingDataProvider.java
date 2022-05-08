package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Driver.DriverBase;

public class TestUsingDataProvider extends DriverBase {

    @Test(dataProvider = "logindata")
    public void login (String username, String password){
        WebDriver driver = getWebdriver();
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
        Object[][] logindata = new Object[2][2];
        logindata[0][0] = "tomsmith";
        logindata[0][1] = "SuperSecretPassword!";

        logindata[1][0] = "tomsmith";
        logindata[1][1] = "123";

        return logindata;
    }
}

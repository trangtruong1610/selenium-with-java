package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Driver.DriverBase;

public class TestTakeScreenshotWhenFailed extends DriverBase {

    @Test
    public void testLoginPass(){
        WebDriver driver = getChromedriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("tomsmith", "SuperSecretPassword!");
    }

    @Test
    public void testLoginFail(){
        WebDriver driver = getChromedriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("tomsmith", "SuperSecretPassword!");
        Assert.fail("test failed");
    }

}

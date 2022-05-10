package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Driver.DriverBase;

public class TestSeleniumGrid extends DriverBase {

    @Parameters({"browserName"})
    @Test
    public void testLogin(String browserName){
        WebDriver driver = getWebdriver(browserName);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("tomsmith", "SuperSecretPassword!");
        Boolean successMsg = driver.findElement(By.xpath("//*[text()=' Logout']")).isDisplayed();
        Assert.assertEquals(successMsg, true);
    }

}

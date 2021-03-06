package tests;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Driver.DriverBase;
import utils.Utils;


public class TestWebdriverThreadPool extends DriverBase {
    Utils util = new Utils();

    @Description("test login success")
    @Test(description = "test login success")
    public void testLoginHerokuApp(){
        WebDriver driver = getChromedriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("tomsmith", "SuperSecretPassword!");
        Boolean successMsg = driver.findElement(By.xpath("//*[text()=' Logout']")).isDisplayed();
        Assert.assertEquals(successMsg, true);
    }

    @Description("test login failed 2")
    @Test(description = "test login failed 2")
    public void testLoginHerokuApp1(){
        WebDriver driver = getChromedriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("tomsmith", "wrong-pwd");
        String errorMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(errorMsg, "ABC");

    }

    @Description("test login failed 3")
    @Test(description = "test login failed 3")
    public void testLoginHerokuApp2(){
        WebDriver driver = getChromedriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("tomsmith", "wrong-pwd");
        String errorMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(errorMsg, "ABC");

    }

    @Description("test login failed 4")
    @Test(description = "test login failed 4")
    public void testLoginHerokuApp3(){
        WebDriver driver = getChromedriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("tomsmith", "wrong-pwd");
        String errorMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(errorMsg, "ABC");

    }
}

package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver.DriverBase;
import utils.SeleniumUtils;

public class TestTakeScreenshotWhenFailed extends DriverBase {

    @Test
    public void testLoginPass(){
        WebDriver driver = getWebdriver();
        SeleniumUtils utils = new SeleniumUtils();
        driver.get("https://the-internet.herokuapp.com/login");
        utils.waitId(driver, "username").sendKeys("tomsmith");
        utils.waitId(driver, "password").sendKeys("SuperSecretPassword!");
        utils.waitXpath(driver,"//*[@type='submit']").click();
    }

    @Test
    public void testLoginFail(){
        WebDriver driver = getWebdriver();
        SeleniumUtils utils = new SeleniumUtils();
        driver.get("https://the-internet.herokuapp.com/login");
        utils.waitId(driver, "username").sendKeys("username");
        utils.waitId(driver, "password").sendKeys("password");
        utils.waitXpath(driver,"//*[@type='submit']").click();

        Assert.fail("test failed");
    }

}

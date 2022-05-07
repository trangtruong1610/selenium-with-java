package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GgPage;
import utils.Driver.DriverBase;

public class TestWebdriverThreadPool extends DriverBase {

    @Test
    public void testLogin(){
        WebDriver driver = getWebdriver();
        GgPage ggPage = new GgPage(driver);
        ggPage.searchGG(driver,"demo testng");
    }
    @Test
    public void testLogin2(){
        WebDriver driver = getWebdriver();
        Assert.fail();
    }
    @Test
    public void testLogin3(){
        WebDriver driver = getWebdriver();
        Assert.fail();
    }
    @Test
    public void testLogin4(){
        WebDriver driver = getWebdriver();
        Assert.fail();
    }
}

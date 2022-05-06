package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.GgPage;
import utils.SeleniumWebDriver;


public class GgTest {
    GgPage ggPage;
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = SeleniumWebDriver.chromeDriver();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void searchWithChrome() {
        ggPage = new GgPage(driver);
        ggPage.searchGG(driver,"demo testng");
    }

    @Test
    public void testSuite() {
        System.out.println("hello world");
    }
}

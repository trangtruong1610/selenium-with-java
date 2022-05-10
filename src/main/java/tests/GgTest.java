package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.GgPage;
import utils.Driver.DriverBase;


public class GgTest extends DriverBase {
    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUp(){
        driver = getChromedriver();

    }

    @Test
    public void searchWithChrome() {
        GgPage ggPage = new GgPage(driver);
        ggPage.searchGG("demo testng");
    }

    @Test
    public void testCase() {
        System.out.println("hello world");
    }
}

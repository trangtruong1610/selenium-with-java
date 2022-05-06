package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;
import utils.SeleniumWebDriver;

public class Test1 {
    public void searchGG (){
        WebDriver wd = SeleniumWebDriver.chromeDriver();
        SeleniumUtils util = new SeleniumUtils();

        wd.get("http://google.com");
        WebElement searchInput = util.waitName(wd, "q");
        searchInput.sendKeys("try selenium");
        WebElement searchBtn = util.waitName(wd, "btnK");
        searchBtn.click();

        wd.quit();
    }
    public void searchGgUsingFF (){
        WebDriver wd = SeleniumWebDriver.firefoxDriver();
        SeleniumUtils util = new SeleniumUtils();

        wd.get("http://google.com");
        WebElement searchInput = util.waitName(wd, "q");
        searchInput.sendKeys("try selenium");
        WebElement searchBtn = util.waitName(wd, "btnK");
        searchBtn.click();

        wd.quit();
    }
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.searchGgUsingFF();
        test1.searchGG();
    }
}

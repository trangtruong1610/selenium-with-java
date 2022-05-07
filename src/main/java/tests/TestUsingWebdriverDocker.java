package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;
import utils.SeleniumWebDriver;

public class TestUsingWebdriverDocker {
    public void searchGG (){
        WebDriver wd = SeleniumWebDriver.dockerWebdriver();
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
        TestUsingWebdriverDocker test1 = new TestUsingWebdriverDocker();
        test1.searchGG();
    }
}

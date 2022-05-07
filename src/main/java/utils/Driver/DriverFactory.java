package utils.Driver;

import org.openqa.selenium.WebDriver;
import utils.SeleniumWebDriver;

public class DriverFactory {
    private WebDriver webdriver;

    WebDriver getDriver(){
        if (webdriver == null){
            webdriver = SeleniumWebDriver.chromeDriver();
        }
        return webdriver;
    }

    void quitDriver(){
        if (webdriver != null){
            webdriver.quit();
            webdriver = null;
        }
    }

}

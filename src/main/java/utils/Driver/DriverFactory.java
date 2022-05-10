package utils.Driver;

import org.openqa.selenium.WebDriver;
import utils.SeleniumWebDriver;

public class DriverFactory {
    private WebDriver webdriver;

    WebDriver getChromeDriver(){
        if (webdriver == null){
            webdriver = SeleniumWebDriver.chromeDriver();
        }
        return webdriver;
    }

    WebDriver getWebdriver(String browserName){
        if (webdriver == null){
            webdriver = SeleniumWebDriver.getWebdriver(browserName);
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

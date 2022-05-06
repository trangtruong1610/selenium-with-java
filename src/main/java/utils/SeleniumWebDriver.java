package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class SeleniumWebDriver {

    public static WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();

        WebDriver wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return wd;
    }


    public static WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();

        WebDriver wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return wd;
    }
    
    public static WebDriver dockerWebdriver(){
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        catch (Exception e){
            try {
                throw e;
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }
        }
        return webDriver;
    }
}

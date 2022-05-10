package utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
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
            webDriver = new RemoteWebDriver(new URL ("http://localhost:4444/wd/hub"), options);
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webDriver;
    }

    public static WebDriver getWebdriver(String browserName){
        RemoteWebDriver remoteWebDriver;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANY);

        if(browserName.equalsIgnoreCase("chrome"))
            desiredCapabilities.setBrowserName("chrome");
        else if (browserName.equalsIgnoreCase("firefox"))
            desiredCapabilities.setBrowserName("firefox");
        else
            desiredCapabilities.setBrowserName("safari");

        try {
            remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
            remoteWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
        return remoteWebDriver;
    }


}

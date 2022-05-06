package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

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
}

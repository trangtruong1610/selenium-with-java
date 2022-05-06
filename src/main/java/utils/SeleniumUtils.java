package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {
    public WebElement waitXpath(WebDriver wd, String xpath){
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement waitName(WebDriver wd, String name){
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
    }

    public WebElement waitId(WebDriver wd, String Id){
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Id)));
    }

}

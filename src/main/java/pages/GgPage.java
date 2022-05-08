package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class GgPage {
    @FindBy (name = "q")
    @CacheLookup
    WebElement search_input;

    @FindBy (name = "btnK")
    @CacheLookup
    WebElement submitBtn;

    String URL_login = "http://google.com";
    WebDriver driver;

    public GgPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchGG (String search_key){
        driver.get(URL_login);
        search_input.sendKeys(search_key);
        submitBtn.click();
    }
}

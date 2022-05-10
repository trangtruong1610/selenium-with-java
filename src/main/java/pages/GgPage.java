package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class GgPage {
    @FindBy (name = "q")
    @CacheLookup
    WebElement search_input;

    @FindBy (name = "btnK")
    @CacheLookup
    WebElement submitBtn;

    Utils util = new Utils();
    String URL_login = util.getValueFromConfigFileByKey("GG_URL");
    WebDriver driver;

    public GgPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("open browser and input {search_key}")
    public void searchGG (String search_key){
        driver.get(URL_login);
        search_input.sendKeys(search_key);
        submitBtn.click();
    }
}

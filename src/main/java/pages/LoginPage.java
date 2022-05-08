package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class LoginPage {

    @FindBy(id = "username")
    @CacheLookup
    WebElement login_username;

    @FindBy (id = "password")
    @CacheLookup
    WebElement login_password;

    @FindBy (xpath = "//*[@type='submit']")
    @CacheLookup
    WebElement submitBtn;

    Utils utils = new Utils();
    String URL_login = utils.getValueFromConfigFileByKey("HEROKUAPP_URL");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void Login(String username, String password){
        driver.get(URL_login);
        login_username.sendKeys(username);
        login_password.sendKeys(password);
        submitBtn.click();
    }
}

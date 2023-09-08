package pages;

import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.logs.Log;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement validUsername;

    @FindBy(id = "password")
    private WebElement validPassword;

    @FindBy(id = "login-button")
    private WebElement buttonLogin;

    @FindBy(css = ".error-message-container.error")
    private WebElement errorMessageLogin;

    @FindBy(xpath = "//h3[.='Epic sadface: Username is required']")
    private WebElement errorMessageUsernameLogin;

    @FindBy(xpath = "//h3[.='Epic sadface: Password is required']")
    private WebElement errorMessagePasswordLogin;


    public void enterUsername(String user) {
        validUsername.sendKeys(user);
    }

    public void enterPassword(String password) {
        validPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        buttonLogin.click();
    }

    public String getErrorMessageLogin() {
        return errorMessageLogin.getText();
    }

    public boolean isAtLoginPage() {
        return driver.getCurrentUrl().equals(Urls.BASE_UI_URL);
    }

    public ProductsPage loginTo(String user, String password) {
        writeText(validUsername, user);
        writeText(validPassword, password);
        click(buttonLogin);
        Log.info("Open Products page " + driver.getCurrentUrl());
        return new ProductsPage(driver);
    }
}
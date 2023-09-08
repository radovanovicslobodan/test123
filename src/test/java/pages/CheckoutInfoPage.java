package pages;

import constants.Urls;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.logs.Log;

public class CheckoutInfoPage extends BasePage {

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    Faker faker = new Faker();

    @FindBy(id = "first-name")
    private WebElement inputFirstName;

    @FindBy(id = "last-name")
    private WebElement inputLastName;

    @FindBy(id = "postal-code")
    private WebElement inputPostalCode;

    @FindBy(xpath = "//h3[.='Error: First Name is required']")
    private WebElement errorMessageFirstName;

    @FindBy(xpath = "//h3[.='Error: Last Name is required']")
    private WebElement errorMessageLastName;

    @FindBy(xpath = "//h3[.='Error: Postal Code is required']")
    private WebElement errorMessagePostalCode;

    @FindBy(className = "title")
    private WebElement pageTitleInfo;

    @FindBy(id = "continue")
    private WebElement buttonContinue;


    public String getPageTitleInfo() {
        return pageTitleInfo.getText();
    }

    public boolean isAtCheckoutInfoPage() {
        return driver.getCurrentUrl().equals(Urls.CHECKOUT_PERSONAL_INFO_PAGE);
    }

    public void clickContinueButton() {
        buttonContinue.click();
    }

    public CheckoutOverviewPage submitUserInfo(String first, String last, String email) {
        writeText(inputFirstName, first);
        writeText(inputLastName, last);
        writeText(inputPostalCode, email);
        click(buttonContinue);
        Log.info("Open Checkout Overview Page " + driver.getCurrentUrl());
        return new CheckoutOverviewPage(driver);
    }


}
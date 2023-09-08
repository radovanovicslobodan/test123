package pages;

import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.logs.Log;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-test='checkout']")
    private WebElement buttonCheckout;

    @FindBy(className = "title")
    private WebElement pageTitleCart;

    public String getPageTitleCart() {
        return pageTitleCart.getText();
    }

    public boolean isAtCartPage() {
        return driver.getCurrentUrl().equals(Urls.CART_PAGE);
    }


    public CheckoutInfoPage clickCheckoutButton() {
        click(buttonCheckout);
        Log.info("Open Checkout Info Page " + driver.getCurrentUrl());
        return new CheckoutInfoPage(driver);
    }
}
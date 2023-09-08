package pages;

import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.logs.Log;

public class CheckoutOverviewPage extends BasePage{

    public CheckoutOverviewPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "finish")
    private WebElement buttonFinish;

    @FindBy(className = "title")
    private WebElement pageTitleOverview;

    public String getPageTitleOverview() {
        return pageTitleOverview.getText();
    }

    public boolean isAtCheckoutOverviewPage() {
        return driver.getCurrentUrl().equals(Urls.CHECKOUT_OVERVIEW_PAGE);
    }


    public CheckoutCompletionPage clickFinishButton() {
        click(buttonFinish);
        Log.info("Open Checkout Completion Page " + driver.getCurrentUrl());
        return new CheckoutCompletionPage(driver);
    }

}

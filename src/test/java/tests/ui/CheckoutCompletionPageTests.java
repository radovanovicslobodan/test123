package tests.ui;

import constants.OtherConstants;
import constants.UiMessages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.CheckoutCompletionPage;

import static constants.OtherConstants.POSTAL_CODE;
import static constants.UiMessages.CHECKOUT_COMPLETE_MESSAGE;

public class CheckoutCompletionPageTests extends BaseUiTest {

    @Test()
    @DisplayName("Successfully completed order with the message")
    public void verifySuccessfulOrder() {
        boolean successfulOrder = openLoginPage()
                .loginTo(OtherConstants.VALID_USER, OtherConstants.VALID_PASSWORD)
                .addItemToCart(0)
                .clickShoppingCartLink()
                .clickCheckoutButton()
                .submitUserInfo(OtherConstants.FIRST_NAME, OtherConstants.LAST_NAME, POSTAL_CODE)
                .clickFinishButton()
                .isAtCheckoutCompletionPage();

        Assertions.assertTrue(successfulOrder);

        CheckoutCompletionPage checkoutCompletionPage = new CheckoutCompletionPage(driver);
        String actualThankYouMessage = checkoutCompletionPage.getThankYouMessage();
        Assertions.assertEquals(CHECKOUT_COMPLETE_MESSAGE, actualThankYouMessage);
    }
}
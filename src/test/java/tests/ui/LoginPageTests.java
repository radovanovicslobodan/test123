package tests.ui;

import constants.OtherConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginPageTests extends BaseUiTest {
    @Test()
    @DisplayName("Successful log in")
    public void verifySuccessfulLogin() {
        boolean successfulLogin = openLoginPage()
                .loginTo(OtherConstants.VALID_USER, OtherConstants.VALID_PASSWORD)
                .isAtProductsPage();

        Assertions.assertTrue(successfulLogin);
    }

    @Test()
    @DisplayName("Unsuccessful log in using invalid user")
    public void verifyUnsuccessfulLoginInvalidUser() {
        boolean successfulLogin = openLoginPage()
                .loginTo(OtherConstants.INVALID_USER, OtherConstants.VALID_PASSWORD)
                .isAtProductsPage();

        Assertions.assertFalse(successfulLogin);
    }

    @Test()
    @DisplayName("Unsuccessful log in using empty credentials")
    public void verifyUnsuccessfulLoginEmptyCredentials() {
        boolean successfulLogin = openLoginPage()
                .loginTo(OtherConstants.EMPTY_USER, OtherConstants.EMPTY_PASSWORD)
                .isAtProductsPage();

        Assertions.assertFalse(successfulLogin);
    }

    @Test()
    @DisplayName("Successfully log out")
    public void verifySuccessfulLogOut() {
        boolean successfulLogOut = openLoginPage()
                .loginTo(OtherConstants.VALID_USER, OtherConstants.VALID_PASSWORD)
                .addItemToCart(0)
                .clickShoppingCartLink()
                .clickCheckoutButton()
                .submitUserInfo(OtherConstants.FIRST_NAME, OtherConstants.LAST_NAME, OtherConstants.POSTAL_CODE)
                .clickFinishButton()
                .clickHomeButton()
                .clickLogout()
                .isAtLoginPage();

        Assertions.assertTrue(successfulLogOut);
    }
}
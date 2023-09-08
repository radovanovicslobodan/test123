package tests.ui;

import constants.OtherConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductsPageTests extends BaseUiTest {
    @Test()
    @DisplayName("Adding two different items to cart")
    public void verifyAddingItemToCart() {
        int itemsInCart = openLoginPage()
                .loginTo(OtherConstants.VALID_USER, OtherConstants.VALID_PASSWORD)
                .addItemToCart(0)
                .addItemToCart(1)
                .getItemsCount();

        Assertions.assertEquals(2, itemsInCart);
    }

    @Test()
    @DisplayName("Removing one item from the cart")
    public void verifyRemovingItemFromCart() {
        int itemsInCart = openLoginPage()
                .loginTo(OtherConstants.VALID_USER, OtherConstants.VALID_PASSWORD)
                .addItemToCart(0)
                .addItemToCart(1)
                .removeItemFromCart(0)
                .getItemsCount();

        Assertions.assertEquals(1, itemsInCart);
    }
}
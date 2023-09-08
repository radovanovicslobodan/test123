package pages;

import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.logs.Log;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(className = "title")
    private WebElement pageTitleProducts;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNameList;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPriceList;

    @FindBy(css = ".btn_inventory")
    private List<WebElement> itemBtnList;

    @FindBy(css = "[data-test='product_sort_container']")
    private WebElement dropdownProductSort;

    @FindBy(className = "inventory_item")
    private List<WebElement> itemList;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenuButton;


    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitleProducts.getText();
    }

    public boolean isAtProductsPage() {
        return driver.getCurrentUrl().equals(Urls.PRODUCTS_PAGE_URL);
    }

    public ProductsPage addItemToCart(int itemIndex) {
        click(itemBtnList.get(itemIndex));
        Log.info("Product is added to cart");
        return this;
    }

    public ProductsPage removeItemFromCart(int itemIndex) {
        click(itemBtnList.get(itemIndex));
        Log.info("Product is removed from cart");
        return this;
    }

    public int getItemsCount() {
        String count = cartBadge.getText();
        return Integer.parseInt(count);
    }

    public CartPage clickShoppingCartLink() {
        click(cartLink);
        Log.info("Open Cart page " + driver.getCurrentUrl());
        return new CartPage(driver);
    }

    public LoginPage clickLogout() {
        click(burgerMenuButton);
        click(logoutButton);
        Log.info("Open Login page " + driver.getCurrentUrl());
        return new LoginPage(driver);
    }
}
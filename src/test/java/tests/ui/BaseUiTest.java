package tests.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.driver.DriverManager;

import static constants.Urls.BASE_UI_URL;

public abstract class BaseUiTest {
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    public void setUp() {
        String browserType = System.getProperty("browser") == null ? "firefox" : System.getProperty("browser");
        driver = new DriverManager().setDriver(browserType);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public LoginPage openLoginPage() {
        getDriver().get(BASE_UI_URL);
        return new LoginPage(driver);
    }
}
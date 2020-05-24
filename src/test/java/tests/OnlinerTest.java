package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.OnlinerMainPage;
import webdriver.Driver;

public class OnlinerTest {

    static WebDriver driver;
    private static final String ONLINER_URL = "http://www.onliner.by/";
    OnlinerMainPage onlinerMainPage;

    @BeforeClass
    public static void startBrowser() {
        driver = Driver.getWebDriver();
        Driver.setTimeout();
    }

    @Before
    public void initializePages() {
        onlinerMainPage = new OnlinerMainPage(driver);
    }

    @Test
    public void priceApple() throws Exception {
        onlinerMainPage.OpenMainPage(ONLINER_URL);
        Driver.removeTimeout();
        onlinerMainPage.goToSearchResults("Iphone XR", 1550);
    }

    @AfterClass
    public static void stopBrowser() {
        Driver.quitDriver();
    }
}



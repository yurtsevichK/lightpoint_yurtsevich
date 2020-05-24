package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OnlinerMainPage extends OnlinerAbstractPage {

    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

    protected Actions builder;

    @FindBy(xpath = "//*[@class='project-navigation__text'][contains(.,\"Смартфоны\")]")
    private WebElement smartphone;

    @FindBy(xpath = "/(//*[@class='schema-filter__checkbox-text'][contains(text(),\"Samsung\")])[1]")
    private WebElement samsung;

    @FindBy(xpath = "/(//*[@class='schema-filter__checkbox-text'][contains(text(),\"Apple\")])[1]")
    private WebElement apple;

    @FindBy (xpath = "//*[@data-bind='html: product.extended_name || product.full_name'][contains(.,\"Смартфон Apple iPhone XR 64GB (черный)\")]")
    private WebElement iphone11;
    // @FindBy (xpath = "(//*[@class=\'schema-products schema-products_processing\'])[1]")
    //private String overloadXpath = "(//*[@class='schema-products schema-products_processing'])[1]";

    @FindBy(xpath = "(//*[@data-bind='html: $root.format.minPrice($data.prices, 'BYN')'])[1]")
    private WebElement priceApple;

    public OnlinerMainPage(WebDriver driver) {
        super(driver);
        this.builder = new Actions(driver);
    }

    public void OpenMainPage(String baseUrl) {
        driver.get(baseUrl);
    }

    void scrollPageDown(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();" +
                "window.scrollBy(0,-100);", element);
    }

    public void goToSearchResults(String applephone, int price) throws Exception {
 //       WebDriverWait wait = new WebDriverWait(driver, 50);
        smartphone.click();
        Thread.sleep(10000);
        scrollPageDown(samsung);
        samsung.click();
        TimeUnit time = TimeUnit.SECONDS;

        long timeToSleep = 10L;

        time.sleep(timeToSleep);
        scrollPageDown(apple);
        apple.click();
        iphone11.click();
      //  wait.until(ExpectedConditions.elementToBeClickable(apple)).click();

        time.sleep(timeToSleep);
        System.out.println("Price:");
        System.out.println(priceApple.getText());
    }

}

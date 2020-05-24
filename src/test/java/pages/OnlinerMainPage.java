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

    @FindBy(xpath = "//*[@class='project-navigation__text'][contains(.,'Смартфоны')]")
    private WebElement smartphone;

    @FindBy(xpath = "(//*[@class='schema-filter__checkbox-text'][contains(text(),'Samsung')])[1]")
    private WebElement samsung;

    @FindBy(xpath = "(//*[@class='schema-filter__checkbox-text'][contains(text(),'Apple')])[1]")
    private WebElement apple;


    private String overloadXpath = "(//*[@class='schema-products schema-products_processing'])[1]";

    @FindBy(xpath = "//*[@id='schema-products']/div[1]/div/div[3]/div[1]/div/div[1]/div[1]/a")
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

    public double goToSearchResults() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        smartphone.click();
        Thread.sleep(10000);
        scrollPageDown(samsung);
        samsung.click();
        Thread.sleep(1000);
        scrollPageDown(apple);
        wait.until(ExpectedConditions.elementToBeClickable(apple)).click();
        Thread.sleep(5000);
        return Double.parseDouble(priceApple.getText().replaceAll("[^\\d.]", "")) / 100;
    }

}

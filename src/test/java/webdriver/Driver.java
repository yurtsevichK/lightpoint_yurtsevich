package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver webDriver;
    private static FluentWait<WebDriver> fluentWait;

    private Driver() throws IllegalAccessError {
        throw new IllegalAccessError("Cannot create Instance of utility class");
    }

    public static void initDriver() {

    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getChromeDriver();
        }
        return webDriver;
    }

    public static void quitDriver() {
        webDriver.close();
        webDriver.quit();
    }

    public static void setTimeout() {
        webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
    }

    public static void removeTimeout() {
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500));
        removeTimeout();
        try {
            fluentWait.until(ExpectedConditions.invisibilityOf(element));
        } catch (org.openqa.selenium.TimeoutException ignored) {
        }
        setTimeout();
    }

}

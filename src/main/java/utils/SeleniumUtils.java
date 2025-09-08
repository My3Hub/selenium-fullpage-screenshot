package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class that provides commonly used Selenium helper methods.
 */
public class SeleniumUtils {

    /**
     * Waits until the element located by the given locator becomes visible on the page.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param by     The locator (By object) used to find the element on the page.
     *
     * Usage example:
     *   SeleniumUtils.waitForTheElementToBeVisible(driver, By.id("username"));
     */
    public static void waitForTheElementToBeVisible(WebDriver driver, By by) {
        // Create WebDriverWait with a timeout of 5 seconds
        new WebDriverWait(driver, Duration.ofSeconds(5))
                // Wait until the element located by the given locator is visible in the DOM and on screen
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

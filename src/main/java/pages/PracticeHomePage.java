package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object class representing the Home Page of the
 * "Practice Software Testing" website.
 *
 * This class contains locators and actions related to the Home Page.
 */
public class PracticeHomePage {
    private WebDriver driver;

    /**
     * Constructor to initialize the WebDriver instance.
     *
     * @param driver WebDriver instance used to interact with the browser.
     */
    public PracticeHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ---------------- Locators ----------------

    /**
     * Locator for the last product name displayed on the home page.
     * Uses XPath with 'last()' function to always capture the last product element.
     */
    public By LastProductName = By.xpath("(//h5[@data-test='product-name'])[last()]");

    // ---------------- Actions ----------------

    /**
     * Navigates to the Home Page of the application.
     */
    public void navigateToHomePage() {
        driver.get("https://practicesoftwaretesting.com");
    }

    /**
     * Getter method for the last product name locator.
     *
     * @return By locator of the last product name.
     */
    public By getLastProductName() {
        return LastProductName;
    }
}

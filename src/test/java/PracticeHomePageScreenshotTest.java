import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.PracticeHomePage;
import utils.ScreenshotUtil;

import static utils.SeleniumUtils.waitForTheElementToBeVisible;

/**
 * Test class to demonstrate capturing a full-page screenshot of the
 * Practice Software Testing site using Selenium, AShot, and Extent Reports.
 */
public class PracticeHomePageScreenshotTest {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    // ------------------- Setup & Teardown -------------------

    /**
     * Initializes the Extent Report before any tests run.
     * Uses Spark reporter to generate an HTML report.
     */
    @BeforeClass
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-reports/spark/index.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    /**
     * Creates a new WebDriver instance before each test.
     * Maximizes the browser window for consistency.
     */
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // ------------------- Test Case -------------------

    /**
     * Test case to navigate to Practice Software Testing site
     * and capture a full-page screenshot using AShot,
     * which is then attached to Extent Report in Base64 format.
     */
    @Test
    public void capturePracticeSiteHomePageScreenshot() {
        // Create a test node in Extent Report
        test = extent.createTest("Capture Full Page Screenshot - Practice Software Testing");

        // Initialize the Home Page object and navigate to the site
        PracticeHomePage homePage = new PracticeHomePage(driver);
        homePage.navigateToHomePage();
        test.info("Navigate to Practice Software Testing Homepage");

        // Wait until the last product name is visible before capturing screenshot
        waitForTheElementToBeVisible(driver, homePage.getLastProductName());

        // Capture and log screenshot in Extent Report
        ScreenshotUtil.logInfoWithScreenshot(driver, test, "Home page screenshot is captured", Status.PASS);
    }

    // ------------------- Cleanup -------------------

    /**
     * Quits the WebDriver instance after each test.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Flushes the Extent Report after all tests have run.
     * Ensures that the report is properly written to disk.
     */
    @AfterClass
    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
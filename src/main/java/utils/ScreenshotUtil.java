package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * Utility class to capture full-page screenshots using AShot
 * and attach them as Base64 images in Extent Reports.
 */
public class ScreenshotUtil {

    /**
     * Captures a full-page screenshot of the current browser window.
     *
     * @param driver The WebDriver instance used for capturing the screenshot.
     * @return A Base64-encoded string representation of the full-page screenshot.
     * @throws IOException If an error occurs during image processing or conversion.
     */
    public static String captureFullPageScreenshot(WebDriver driver) throws IOException {
        // Use AShot library to capture full-page screenshot by stitching multiple viewports
        Screenshot fullScreenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(600)) // 300ms scroll delay between screenshots
                .takeScreenshot(driver);

        // Get the buffered image from the screenshot
        BufferedImage image = fullScreenshot.getImage();

        // Convert the image into byte array output stream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);

        // Convert the byte array into Base64 string so it can be embedded directly in the HTML report
        byte[] imageBytes = baos.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    /**
     * Logs a message along with a screenshot into Extent Report.
     *
     * @param driver  The WebDriver instance used for capturing the screenshot.
     * @param test    The ExtentTest instance where the log should be added.
     * @param message The message to log alongside the screenshot.
     * @param status  The log status (INFO, PASS, FAIL, etc.) to be used in the report.
     */
    public static void logInfoWithScreenshot(WebDriver driver, ExtentTest test, String message, Status status) {
        if (driver != null && test != null) {
            try {

                // Capture screenshot as Base64 string
                String Base64Screenshot = captureFullPageScreenshot(driver);


                // Log the message and attach the screenshot into the Extent report
                test.log(status, message, MediaEntityBuilder
                        .createScreenCaptureFromBase64String(Base64Screenshot).build());
            } catch (IOException e) {
                // Handle exceptions gracefully and log failure info instead of screenshot
                e.printStackTrace();
                test.log(status, message + " (Screenshot capture failed: " + e.getMessage() + ")");
            }
        }
    }
}

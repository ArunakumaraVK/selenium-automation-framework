package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        try {

            // Create timestamp
            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            // Screenshot folder
            String screenshotDirectory =
                    System.getProperty("user.dir")
                            + "/test-output/screenshots/";

            // Create folder if it doesn't exist
            File directory =
                    new File(screenshotDirectory);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Screenshot file path
            String screenshotPath =
                    screenshotDirectory
                            + testName
                            + "_"
                            + timestamp
                            + ".png";

            // Take screenshot
            TakesScreenshot takesScreenshot =
                    (TakesScreenshot) driver;

            File sourceFile =
                    takesScreenshot.getScreenshotAs(
                            OutputType.FILE);

            File destinationFile =
                    new File(screenshotPath);

            // Copy screenshot
            sourceFile.renameTo(destinationFile);

            System.out.println(
                    "Screenshot saved at: "
                            + screenshotPath);

            // Return path for Extent Report
            return screenshotPath;

        } catch (Exception e) {

            System.out.println(
                    "Failed to capture screenshot: "
                            + e.getMessage());

            return null;
        }
    }
}
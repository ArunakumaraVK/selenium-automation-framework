package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constants.FrameworkConstants;
import exceptions.FrameworkException;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        try {

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            Path destination =
                    Path.of(
                            FrameworkConstants.SCREENSHOT_PATH
                                    + testName
                                    + "_"
                                    + System.currentTimeMillis()
                                    + ".png");

            Files.createDirectories(
                    destination.getParent());

            Files.copy(
                    source.toPath(),
                    destination);

            return destination.toString();

        } catch (IOException e) {

            throw new FrameworkException(
                    "Unable to capture screenshot", e);
        }
    }
}
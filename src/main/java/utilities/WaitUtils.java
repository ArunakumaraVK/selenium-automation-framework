package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;

public final class WaitUtils {

    private WaitUtils() {
    }

    public static WebElement waitForElementVisible(
            WebDriver driver,
            WebElement element) {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(
                                FrameworkConstants.EXPLICIT_WAIT));

        return wait.until(
                ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementClickable(
            WebDriver driver,
            WebElement element) {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(
                                FrameworkConstants.EXPLICIT_WAIT));

        return wait.until(
                ExpectedConditions.elementToBeClickable(element));
    }
}
package drivers_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import exceptions.FrameworkException;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void initializeDriver(String browser) {

        if (browser == null) {
            throw new FrameworkException(
                    "Browser value cannot be null");
        }

        switch (browser.toLowerCase()) {

            case "chrome":
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                throw new FrameworkException(
                        "Unsupported browser: " + browser);
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {

        if (driver.get() == null) {
            throw new FrameworkException(
                    "WebDriver is not initialized");
        }

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}
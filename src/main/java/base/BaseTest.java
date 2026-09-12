package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import drivers_factory.DriverFactory;
import utilities.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setup() {

        String browser =
                ConfigReader.getProperty("browser");

        String url =
                ConfigReader.getProperty("url");

        DriverFactory.initializeDriver(browser);

        DriverFactory
                .getDriver()
                .get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverFactory.quitDriver();
    }

    public WebDriver getDriver() {

        return DriverFactory.getDriver();
    }
}
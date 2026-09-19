package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import drivers_factory.DriverFactory;
import utilities.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setup() {

        String browser = ConfigReader.getProperty("browser");	//To read (Get) the browser from config.properties through ConfigReader

        String url = ConfigReader.getProperty("url");		//To read (Get) the application url from config.properties through ConfigReader

        DriverFactory.initializeDriver(browser);		//	To open required browser(chrome or Firefox or Edge).

        DriverFactory.getDriver().get(url);			//	To open the Application
    }

    @AfterMethod(alwaysRun = true)					
    public void tearDown() {					// This code is used for test cleanup/ Teardown. It runs after each TestNG test method and closes the browser.

        DriverFactory.quitDriver();				
    }

    public WebDriver getDriver() {				//This method is used to get the current WebDriver instance from DriverFactory.

        return DriverFactory.getDriver();
    }
}
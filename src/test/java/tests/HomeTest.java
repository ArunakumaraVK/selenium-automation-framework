package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages_POM.HomePage;
import pages_POM.LoginPage;
import utilities.ConfigReader;

public class HomeTest extends BaseTest {

    HomePage homePage;

    @Test
    public void verifyHomePageTitle() {
    	
    	LoginPage loginPage = new LoginPage(getDriver());

    	String username = ConfigReader.getProperty("username");
    	String password = ConfigReader.getProperty("password");

    	homePage = loginPage.loginWithValidCredentials(username, password);
    	
        Assert.assertEquals(
                homePage.getPageTitle(),
                "Products",
                "Home page title is incorrect"
        );
    }
    
    @Test
    public void verifyHomePageDisplayed() {

        LoginPage loginPage = new LoginPage(getDriver());

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        homePage = loginPage.loginWithValidCredentials(username, password);

        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Home Page is not displayed"
        );
    }
}
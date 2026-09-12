package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataproviders.TestDataProvider;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        LoginPage loginPage =
                new LoginPage(getDriver());

        String username =
                ConfigReader.getProperty(
                        "username");

        String password =
                ConfigReader.getProperty(
                        "password");

        HomePage homePage =
                loginPage
                        .loginWithValidCredentials(
                                username,
                                password);

        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Home page is not displayed");

//        Assert.assertEquals(
//                homePage.getPageTitle(),
//                "Products",
//                "Page title is incorrect");
        Assert.assertEquals(homePage.getPageTitle(), "WrongTitle");
    }


    @Test(
        dataProvider = "invalidLoginData",
        dataProviderClass =
                TestDataProvider.class
    )
    public void verifyInvalidLogin(
            String username,
            String password) {

        LoginPage loginPage =
                new LoginPage(getDriver());

        loginPage
                .loginWithInvalidCredentials(
                        username,
                        password);

        String actualError =
                loginPage.getErrorMessage();

        Assert.assertTrue(
                actualError.contains(
                        "Username and password do not match"),
                "Expected login error is not displayed");
    }
}
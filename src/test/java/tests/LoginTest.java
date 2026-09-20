package tests;

import listeners.RetryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataproviders.TestDataProvider;
import pages_POM.HomePage;
import pages_POM.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest {		  //LoginTest extends BaseTest, This gives the test access to your common setup and teardown.

    @Test(retryAnalyzer = RetryAnalyzer.class)	  //This tells TestNG that verifyValidLogin() is a test case. RetryAnalyzer is used to rerun the test when it fails, typically for transient/ flaky failures.
    public void verifyValidLogin() {

        LoginPage loginPage = new LoginPage(getDriver());		//This creates the Login Page Object and passes the current WebDriver to it.

        String username = ConfigReader.getProperty("username");	 //Instead of hardcoding credentials in the test, you read them from your configuration file. This improves maintainability and keeps test data separate from test logic.

        String password = ConfigReader.getProperty("password");		//Instead of hardcoding credentials in the test, you read them from your configuration file. This improves maintainability and keeps test data separate from test logic.
                        

        HomePage homePage = loginPage.loginWithValidCredentials(username,password);	  //This calls the method from LoginPage.

        Assert.assertTrue(homePage.isHomePageDisplayed(),"Home page is not displayed");  //Validating the Home Page. This is your actual test validation/assertion.

        Assert.assertEquals(homePage.getPageTitle(),"Products","Page title is incorrect");	//Yes, this is the correct assertion if the expected page title is "Products"

//        Assert.assertEquals(homePage.getPageTitle(),"WrongTitle");	//Want to Make the test failed, add this line instead of above line just for practice.
    }

    @Test(dataProvider = "invalidLoginData",dataProviderClass = TestDataProvider.class, retryAnalyzer = RetryAnalyzer.class)	//Instead of writing multiple tests for different invalid credentials, the same test method can execute with multiple username/password combinations.
    public void verifyInvalidLogin(String username,String password) 	//
    {				

        LoginPage loginPage = new LoginPage(getDriver());				

        loginPage.loginWithInvalidCredentials(username,password);

        String actualError = loginPage.getErrorMessage();			//This gets the error message from LoginPage and verifies that it contains the expected text.

        Assert.assertTrue(actualError.contains("Username and password do not match"),"Expected login error is not displayed");
    }
}
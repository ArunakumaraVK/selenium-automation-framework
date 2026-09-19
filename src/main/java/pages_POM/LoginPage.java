package pages_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {					

    @FindBy(id = "user-name")					//Used to locate the username field on the login page.
    private WebElement usernameField;

    @FindBy(id = "password")					//Used to locate the password field on the login page.
    private WebElement passwordField;

    @FindBy(id = "login-button")				//Used to locate the login-button field on the login page.
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")		//Used to get error message..
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {		//Constructor, Used to pass the WebDriver to BasePage
        super(driver);
    }

    public LoginPage enterUsername(				//Used to enter the username. 
            String username) {

        type(usernameField, username);			
        return this;							//return this means it returns the same LoginPage object, which allows method chaining:
    }

    public LoginPage enterPassword(				//Used to enter the password.
            String password) {

        type(passwordField, password);

        return this;							//Again, return this supports method chaining.
    }

    public void clickLogin() {					//Used to click the login button.

        click(loginButton);
    }

    public HomePage loginWithValidCredentials(			//This is a business-level reusable method.
            String username,
            String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();

        return new HomePage(driver);
    }

    public LoginPage loginWithInvalidCredentials(			//Used for negative login scenarios.
            String username,
            String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();

        return this;
    }

    public String getErrorMessage() {						//Used to retrieve the error message displayed on the page.

        return getText(errorMessage);
    }
}
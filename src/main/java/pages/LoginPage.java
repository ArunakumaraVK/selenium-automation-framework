package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(
            String username) {

        type(usernameField, username);

        return this;
    }

    public LoginPage enterPassword(
            String password) {

        type(passwordField, password);

        return this;
    }

    public void clickLogin() {

        click(loginButton);
    }

    public HomePage loginWithValidCredentials(
            String username,
            String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();

        return new HomePage(driver);
    }

    public LoginPage loginWithInvalidCredentials(
            String username,
            String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();

        return this;
    }

    public String getErrorMessage() {

        return getText(errorMessage);
    }
}
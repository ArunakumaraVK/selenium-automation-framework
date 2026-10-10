package pages_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

    @FindBy(css = "[data-test='title']") // This identifies the title element on the Home Page.
    private WebElement pageTitle;

    @FindBy(id = "react-burger-menu-btn") // This identifies the Menu button.
    private WebElement menuButton;

    public HomePage(WebDriver driver) { // Constructor, passes WebDriver to BasePage.
        super(driver);
    }

    public boolean isHomePageDisplayed() { // Checks whether the Home Page title is displayed.
        return isDisplayed(pageTitle);
    }

    public String getPageTitle() { // Retrieves the text of the page title.
        return getText(pageTitle);
    }

    public void clickMenuButton() { // Clicks the Menu button.
        click(menuButton);
    }
}


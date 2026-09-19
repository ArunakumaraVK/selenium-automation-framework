package pages_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

    @FindBy(css = "[data-test='title']")		//This identifies the title element on the Home Page.
    private WebElement pageTitle;

    public HomePage(WebDriver driver) {				//Constructor, This passes the WebDriver to BasePage.
        super(driver);								
    }

    public boolean isHomePageDisplayed() {				//This checks whether the Home Page title is displayed.

        return isDisplayed(pageTitle);
    }

    public String getPageTitle() {						//This retrieves the text of the page title.

        return getText(pageTitle);
    }
}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

    @FindBy(css = "[data-test='title']")
    private WebElement pageTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageDisplayed() {

        return isDisplayed(pageTitle);
    }

    public String getPageTitle() {

        return getText(pageTitle);
    }
}
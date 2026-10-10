package pages_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class MenuPage extends BasePage {

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsLink;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppStateLink;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickAllItems() {
        click(allItemsLink);
    }

    public void clickAbout() {
        click(aboutLink);
    }

    public void clickLogout() {
        click(logoutLink);
    }

    public void clickResetAppState() {
        click(resetAppStateLink);
    }
}


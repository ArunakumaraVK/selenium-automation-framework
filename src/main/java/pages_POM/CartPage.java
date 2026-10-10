package pages_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CartPage extends BasePage {

    @FindBy(css = "[data-test='title']")
    private WebElement pageTitle;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageDisplayed() {
        return isDisplayed(pageTitle);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public void clickCheckout() {
        click(checkoutButton);
    }

    public void clickContinueShopping() {
        click(continueShoppingButton);
    }
}


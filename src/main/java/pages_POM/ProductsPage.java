package pages_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class ProductsPage extends BasePage {

    @FindBy(css = "[data-test='title']")
    private WebElement pageTitle;

    @FindBy(css = "[data-test='product-sort-container']")
    private WebElement sortDropdown;

    @FindBy(css = "[data-test^='add-to-cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(css = "[data-test^='remove']")
    private List<WebElement> removeButtons;

    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement cartIcon;

    @FindBy(css = "[data-test='shopping-cart-badge']")
    private WebElement cartBadge;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageDisplayed() {
        return isDisplayed(pageTitle);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public void selectSortOption(String option) {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(option);
    }

    public void addProductToCart(String productName) {
        WebElement addButton = driver.findElement(
                org.openqa.selenium.By.xpath(
                        "//div[@data-test='inventory-item']//div[@data-test='inventory-item-name' and text()='"
                                + productName
                                + "']/ancestor::div[@data-test='inventory-item']//button"));
        click(addButton);
    }

    public void removeProductFromCart(String productName) {
        WebElement removeButton = driver.findElement(
                org.openqa.selenium.By.xpath(
                        "//div[@data-test='inventory-item']//div[@data-test='inventory-item-name' and text()='"
                                + productName
                                + "']/ancestor::div[@data-test='inventory-item']//button"));
        click(removeButton);
    }

    public int getNumberOfProductsInCart() {
        if (isDisplayed(cartBadge)) {
            return Integer.parseInt(getText(cartBadge));
        }
        return 0;
    }

    public void clickCart() {
        click(cartIcon);
    }
}

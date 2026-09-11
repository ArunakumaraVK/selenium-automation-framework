package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(
                driver,
                this);
    }

    protected void click(WebElement element) {

        WaitUtils
                .waitForElementClickable(
                        driver,
                        element)
                .click();
    }

    protected void type(
            WebElement element,
            String text) {

        WebElement webElement =
                WaitUtils.waitForElementVisible(
                        driver,
                        element);

        webElement.clear();
        webElement.sendKeys(text);
    }

    protected String getText(
            WebElement element) {

        return WaitUtils
                .waitForElementVisible(
                        driver,
                        element)
                .getText();
    }

    protected boolean isDisplayed(
            WebElement element) {

        try {

            return WaitUtils
                    .waitForElementVisible(
                            driver,
                            element)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}
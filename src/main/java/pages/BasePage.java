package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public abstract class BasePage {

    public WebDriver driver;
    public Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void clickElement(By element) {
        driver.findElement(element).click();
    }


    public String getTextFromElement(By element) {
        return driver.findElement(element).getText();
    }

    public String getFontFamilyFromElement(By element) {
        return driver.findElement(element).getCssValue("font-family");
    }

    public String getFontStyleFromElement(By element) {
        return driver.findElement(element).getCssValue("font-style");
    }

    public String getColorFromElement(By element) {
        String colorValue = driver.findElement(element).getCssValue("background-color");
        return Color.fromString(colorValue).asHex();
    }

    public String getValueFromPhoto(By element) {
        return driver.findElement(element).getAttribute("src");
    }

    public String getValidationMessage(By element) {
        return driver.findElement(element).getAttribute("validationMessage");
    }


    public void hoverOverElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public String getPaddingFromElement(By element) {
        return driver.findElement(element).getCssValue("padding-bottom");
    }

    public void sendKeysToTextField(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public void clearTextFromTextField(By element) {
        driver.findElement(element).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }

    public boolean isElementDisplayed(By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public String getBeforePseudoStyle(By locator, String cssProperty) {
        WebElement element = driver.findElement(locator);
        WebElement parentDiv = element.findElement(By.xpath("./ancestor::div[contains(@class,'MuiInputBase-root')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], '::before').getPropertyValue(arguments[1]);",
                parentDiv, cssProperty
        );
    }

    public String getAfterPseudoStyle(By locator, String cssProperty) {
        WebElement element = driver.findElement(locator);
        WebElement parentDiv = element.findElement(By.xpath("./ancestor::div[contains(@class,'MuiInputBase-root')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], '::after').getPropertyValue(arguments[1]);",
                parentDiv, cssProperty
        );
    }
}
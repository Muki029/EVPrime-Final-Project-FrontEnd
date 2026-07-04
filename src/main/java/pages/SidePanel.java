package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidePanel extends BasePage {

    private By menuIcon = By.xpath("//*[@id=\"root\"]/div/div/header/div/button");
    private By homeButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[1]/div/div[2]/span");
    private By eventsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[2]/div/div[2]/span");
    private By contactButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[3]/div/div[2]/span");
    private By loginButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[4]/div/div[2]/span");
    private By closeMenuButton = By.xpath("//*[@data-testid='ChevronLeftIcon']");


    public SidePanel(WebDriver driver) {
        super(driver);
    }

    public void clickMenuIcon() {
        clickElement(menuIcon);
    }

    public void clickCloseMenuButton() {
        clickElement(closeMenuButton);
    }

    public String getTextFromMenuHomeButton() {
        return getTextFromElement(homeButton);
    }

    public String getTextFromEventsButton() {
        return getTextFromElement(eventsButton);
    }

    public String getTextFromContactButton() {
        return getTextFromElement(contactButton);
    }

    public String getTextFromLoginButton() {
        return getTextFromElement(loginButton);
    }

    public String getFontFromHomeButton() {
        return getFontFamilyFromElement(homeButton);
    }

    public String getFontFromEventsButton() {
        return getFontFamilyFromElement(eventsButton);
    }

    public String getFontFromContactButton() {
        return getFontFamilyFromElement(contactButton);
    }

    public String getFontFromLoginButton() {
        return getFontFamilyFromElement(loginButton);
    }

    public String getFontStyleFromHomeButton() {
        return getFontStyleFromElement(homeButton);
    }

    public String getFontStyleFromEventsButton() {
        return getFontStyleFromElement(eventsButton);
    }

    public String getFontStyleFromContactButton() {
        return getFontStyleFromElement(contactButton);
    }

    public String getFontStyleFromLoginButton() {
        return getFontStyleFromElement(loginButton);
    }

    public boolean isMenuClosed() {
        if (driver.findElement(menuIcon).isDisplayed()) {
            return true;
        } else return false;
    }


}

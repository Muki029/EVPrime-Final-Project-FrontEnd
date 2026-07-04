package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import java.util.List;

public class ContactsPage extends BasePage {

    private By contactButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[3]/div/div[2]/span");
    private By contactsPageTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/h2");
    private By userNameField = By.id(":r0:");
    private By emailField = By.id(":r1:");
    private By messageField = By.id(":r2:");
    private By sendButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/button");
    private By adress = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[2]/div[2]/p[1]");
    private By email = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[2]/div[2]/p[2]");
    private By phoneNumber = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[2]/div[2]/p[3]");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverUserName() throws InterruptedException {
        hoverOverElement(userNameField);
        Thread.sleep(1000);
    }
    public String getUserNameTitleBorderWidth() {
        return getBeforePseudoStyle(userNameField, "border-bottom-width");
    }

    public String getTitleFromContactsPage() {
        return getTextFromElement(contactsPageTitle);

    }

    public void clickContactButton() {
        clickElement(contactButton);
    }


    public void clickSendButton() {
        clickElement(sendButton);
    }
    public void clickUserNameField(){
        clickElement(userNameField);
    }

    public String getTextFromAdressFooter() {
        return getTextFromElement(adress);
    }

    public String getTextFromEmailFooter() {
        return getTextFromElement(email);
    }

    public String getTextFromPhoneNumberFooter() {
        return getTextFromElement(phoneNumber);
    }

    public String getErrorMessageUserName() {
        return getValidationMessage(userNameField);
    }

    public String getErrorMessageEmail() {
        return getValidationMessage(emailField);
    }

    public String getErrorMessageMessage() {
        return getValidationMessage(messageField);
    }

    public void enterUserName(String username) {
        sendKeysToTextField(userNameField, username);
    }

    public void enterEmail(String email) {
        sendKeysToTextField(emailField, email);
    }

    public void enterMessage(String message) {
        sendKeysToTextField(messageField, message);
    }

    public void clearTextFromEmailField() throws InterruptedException {
        Thread.sleep(1000);
        clearTextFromTextField(emailField);
    }

    public void clearTextFromNameField() throws InterruptedException {
        Thread.sleep(1000);
        clearTextFromTextField(userNameField);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(userNameField);
    }

    public String getSendButtonColor() {
        return getColorFromElement(sendButton);
    }

    public String getNameFieldBorderColorAfterClick() {
        return Color.fromString(getAfterPseudoStyle(userNameField, "border-bottom-color")).asHex();
    }
    public String getNameFieldBorderColorBeforeClick(){
        return (getBeforePseudoStyle(userNameField,"border-bottom-color"));
    }

}
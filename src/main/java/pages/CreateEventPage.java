package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateEventPage extends BasePage {

    private By eventTitleField = By.name("title");
    private By eventImageField = By.name("image");
    private By eventDateField = By.name("date");
    private By eventLocationField = By.name("location");
    private By eventDescriptionField = By.xpath("//form//textarea[@name='description']");
    private By createEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");

    private By eventTitleLabel = By.xpath("//input[@name='title']/ancestor::div[contains(@class, 'MuiFormControl-root')]//label");
    private By eventImageLabel = By.xpath("//input[@name='image']/ancestor::div[contains(@class, 'MuiFormControl-root')]//label");
    private By eventDateLabel = By.xpath("//input[@name='date']/ancestor::div[contains(@class, 'MuiFormControl-root')]//label");
    private By eventLocationLabel = By.xpath("//input[@name='location']/ancestor::div[contains(@class, 'MuiFormControl-root')]//label");
    private By eventDescriptionLabel = By.xpath("//textarea[@name='description']/ancestor::div[contains(@class, 'MuiFormControl-root')]//label");

    public CreateEventPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverEventTitle() throws InterruptedException {
        hoverOverElement(eventTitleField);
        Thread.sleep(1000);
    }

    public void enterEventTitle(String text) throws InterruptedException {
        sendKeysToTextField(eventTitleField, text);
        Thread.sleep(500);
    }

    public void enterEventImage(String text) throws InterruptedException {
        sendKeysToTextField(eventImageField, text);
        Thread.sleep(500);
    }

    public void enterEventDate(String text) throws InterruptedException {
        sendKeysToTextField(eventDateField, text);
        Thread.sleep(500);
    }

    public void enterEventLocation(String text) throws InterruptedException {
        sendKeysToTextField(eventLocationField, text);
        Thread.sleep(500);
    }

    public void enterEventDescription(String text) throws InterruptedException {
        sendKeysToTextField(eventDescriptionField, text);
        Thread.sleep(500);
    }

    public void clickCreateEventButton() throws InterruptedException {
        clickElement(createEventButton);
        Thread.sleep(1000);
    }

    public String getTextFromEvenTitleInput() {
        return getTextFromElement(eventTitleLabel);
    }

    public String getTextFromEventImageInput() {
        return getTextFromElement(eventImageLabel);
    }

    public String getTextFromEventDateInput() {
        return getTextFromElement(eventDateLabel);
    }

    public String getTextFromEventLocationInput() {
        return getTextFromElement(eventLocationLabel);
    }

    public String getTextFromEventDescriptionInput() {
        return getTextFromElement(eventDescriptionLabel);
    }

    public String getColorFromCreateEventButton() {
        return getColorFromElement(createEventButton);
    }

    public String getFontFamilyFromCreateEventButton() {
        return getFontFamilyFromElement(createEventButton);
    }

    public String getFontStyleFromCreateEventButton() {
        return getFontStyleFromElement(createEventButton);
    }

    public String getTextFromCreateEventButton() {
        return getTextFromElement(createEventButton);
    }

    public String getEventTitleBorderWidth() {
        return getBeforePseudoStyle(eventTitleField, "border-bottom-width");
    }
}
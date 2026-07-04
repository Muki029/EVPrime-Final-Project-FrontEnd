package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EventsPage extends BasePage {


    private By eventsCards = By.xpath("//*[@id='root']/div/div/main/div[2]/ul/li");
    private By eventsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[2]/div/div[2]/span");
    private By eventTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[1]/h2");
    private By eventDate = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[2]/h6");
    private By eventLocation = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[3]/h6");
    private By eventDescritpion = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/span");
    private By eventImage = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[2]/div/img");

    private By eventTitleField = By.name("title");
    private By eventImageField = By.name("image");
    private By eventDateField = By.name("date");
    private By eventLocationField = By.name("location");
    private By eventDescriptionField = By.xpath("//form//textarea[@name='description']");

    private By backToEventsButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[2]/button");
    private By editButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[1]");
    private By deleteEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/button");
    private By deleteButtonFinal = By.xpath("/html/body/div[2]/div[3]/div/div/button[1]");
    private By noButtonFinal = By.xpath("/html/body/div[2]/div[3]/div/div/button[2]");
    private By updateEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");


    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBackToEventsButton() {
        clickElement(backToEventsButton);
    }

    public void clickOnEvent(int event) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> cards = driver.findElements(eventsCards);
        cards.get(event).click();
    }

    public void clickOnEventByTitle(String eventTitle) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> cards = driver.findElements(eventsCards);

        for (WebElement card : cards) {
            if (card.getText().contains(eventTitle)) {
                card.click();
                break;
            }
        }
    }

    public void clickEventsButton() {
        clickElement(eventsButton);
    }

    public String getEventTitle() {
        return getTextFromElement(eventTitle);
    }

    public String getEventImageTxt() {
        return getValueFromPhoto(eventImage);
    }

    public String getEventDate() {
        return getTextFromElement(eventDate);
    }

    public String getEventLocation() {
        return getTextFromElement(eventLocation);
    }

    public String getEventDescription() {
        return getTextFromElement(eventDescritpion);
    }

    public String getColorFromBackButton() {
        return getColorFromElement(backToEventsButton);
    }

    public void clickEditButton() {
        clickElement(editButton);
    }

    public void clickDeleteEventButton() {
        clickElement(deleteEventButton);
    }

    public String getDeleteButtonColor() {
        return getColorFromElement(deleteEventButton);
    }

    public String getEditButtonColor() {
        return getColorFromElement(editButton);
    }

    public String getNoButtonFinalColor() {
        return getColorFromElement(noButtonFinal);
    }

    public void clickNoButton() {
        clickElement(noButtonFinal);
    }

    public void clickDeleteFinal() throws InterruptedException {
        Thread.sleep(1000);
        clickElement(deleteButtonFinal);
    }

    public boolean isEventDeleted() {
        if (driver.getCurrentUrl().equals("http://localhost:3000/events")) {
            return true;
        } else return false;
    }

    public void clickUpdateEventButton() throws InterruptedException {
        clickElement(updateEventButton);
        Thread.sleep(4000);
    }

    public String getUpdateEventButtonColor() {
        return getColorFromElement(updateEventButton);
    }

    public void clearEventTitle() throws InterruptedException {
        clearTextFromTextField(eventTitleField);
        Thread.sleep(500);
    }

    public void clearImageText() throws InterruptedException {
        clearTextFromTextField(eventImageField);
        Thread.sleep(500);
    }
    public void clearEventDate() throws InterruptedException {
        clearTextFromTextField(eventDateField);
        Thread.sleep(500);
    }
    public void clearEventLocation() throws InterruptedException {
        clearTextFromTextField(eventLocationField);
        Thread.sleep(500);
    }
    public void clearEventDescription() throws InterruptedException {
        clearTextFromTextField(eventDescriptionField);
        Thread.sleep(500);
    }
}

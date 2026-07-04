package evprimetests.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateEventPage;
import pages.EventsPage;
import pages.LoginSignupPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateEventPageTests {
    private WebDriver driver;
    private LoginSignupPage loginSignupPage;
    private CreateEventPage createEventPage;
    private EventsPage eventsPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //we log in so that we can create,edit or delete an event

        loginSignupPage = new LoginSignupPage(driver);
        createEventPage = new CreateEventPage(driver);
        eventsPage = new EventsPage(driver);

        loginSignupPage.navigateTo("http://localhost:3000/");
        loginSignupPage.clickLoginMenubutton();
        loginSignupPage.enterEmail("final.project@creativehub.mk");
        loginSignupPage.enterPassword("creativeHub123!");
        loginSignupPage.clickGoButton();
        loginSignupPage.hoverOnAddEventButton();
        loginSignupPage.clickCreateEventButton();
    }

    @Test
    public void validateTextFields() {
        assertEquals("Event Title", createEventPage.getTextFromEvenTitleInput());
        assertEquals("Event Image", createEventPage.getTextFromEventImageInput());
        assertEquals("Event Date", createEventPage.getTextFromEventDateInput());
        assertEquals("Event Location", createEventPage.getTextFromEventLocationInput());
        assertEquals("Event Description", createEventPage.getTextFromEventDescriptionInput());
    }

    @Test
    public void validateColorAndTextFromCreateEventButton() {
        assertEquals("#304ffe", createEventPage.getColorFromCreateEventButton());
        assertEquals("CREATE EVENT", createEventPage.getTextFromCreateEventButton());
    }

    @Test
    public void validateFontFromCreateEventButton() {
        assertEquals("\"Josefin Sans\"", createEventPage.getFontFamilyFromCreateEventButton());
        assertEquals("normal", createEventPage.getFontStyleFromCreateEventButton());
    }


    @Test
    public void borderThickensOnHoverTest() throws InterruptedException {
        String borderBefore = createEventPage.getEventTitleBorderWidth();
        createEventPage.hoverOverEventTitle();
        String borderAfter = createEventPage.getEventTitleBorderWidth();

        assertEquals("0.8px", borderBefore);
        assertEquals("1.6px", borderAfter);
    }

    @Test
    public void successfulyCreateNewEventTest() throws InterruptedException {

        createEventPage.enterEventTitle("New Automated Title");
        createEventPage.enterEventImage("https://www.shutterstock.com/image-vector/vector-rubber-stamp-german-word-260nw-2653845409.jpg");
        createEventPage.enterEventDate("03.07.2026");
        createEventPage.enterEventLocation("Automated Location");
        createEventPage.enterEventDescription("Automated Description");
        createEventPage.clickCreateEventButton();


        eventsPage.clickOnEventByTitle("New Automated Title");
        assertEquals("New Automated Title", eventsPage.getEventTitle());
        assertEquals("https://www.shutterstock.com/image-vector/vector-rubber-stamp-german-word-260nw-2653845409.jpg", eventsPage.getEventImageTxt());
        assertEquals("03.07.2026", eventsPage.getEventDate());
        assertEquals("Automated Location", eventsPage.getEventLocation());
        assertEquals("Automated Description", eventsPage.getEventDescription());

        eventsPage.navigateTo("http://localhost:3000/events");
        eventsPage.clickOnEventByTitle("New Automated Title");
        eventsPage.clickDeleteEventButton();
        eventsPage.clickDeleteFinal();
        assertTrue(eventsPage.isEventDeleted());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}

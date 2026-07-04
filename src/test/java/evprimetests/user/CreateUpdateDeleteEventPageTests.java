package evprimetests.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateEventPage;
import pages.EventsPage;
import pages.LoginSignupPage;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUpdateDeleteEventPageTests {
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

        //we post a new event and then later with @AfterEach method we delete it so we don't pump our DB out :)
        createEventPage.enterEventTitle("New Automated Title");
        createEventPage.enterEventImage("https://www.shutterstock.com/image-vector/vector-rubber-stamp-german-word-260nw-2653845409.jpg");
        createEventPage.enterEventDate("03.07.2026");
        createEventPage.enterEventLocation("Automated Location");
        createEventPage.enterEventDescription("Automated Description");
        createEventPage.clickCreateEventButton();
    }

    @Test
    public void validateNewCreatedTest() throws InterruptedException {
        eventsPage.clickOnEventByTitle("New Automated Title");
        assertEquals("New Automated Title", eventsPage.getEventTitle());
        assertEquals("https://www.shutterstock.com/image-vector/vector-rubber-stamp-german-word-260nw-2653845409.jpg", eventsPage.getEventImageTxt());
        assertEquals("03.07.2026", eventsPage.getEventDate());
        assertEquals("Automated Location", eventsPage.getEventLocation());
        assertEquals("Automated Description", eventsPage.getEventDescription());
    }

    @Test
    public void validateColorsFromButtonsTest() throws InterruptedException {
        eventsPage.clickOnEventByTitle("New Automated Title");

        assertEquals("#304ffe", eventsPage.getEditButtonColor());
        assertEquals("#d32f2f", eventsPage.getDeleteButtonColor());

        //now we validate the colors after clicking delete button and new buttons appears so validate their color too :)
        eventsPage.clickDeleteEventButton();
        assertEquals("#d32f2f", eventsPage.getDeleteButtonColor());
        assertEquals("#9c27b0", eventsPage.getNoButtonFinalColor());
        eventsPage.clickNoButton();
    }

    @Test
    public void cancelDeletingEventTest() throws InterruptedException {
        eventsPage.clickOnEventByTitle("New Automated Title");
        eventsPage.clickDeleteEventButton();
        eventsPage.clickNoButton();

        assertFalse(eventsPage.isEventDeleted());
    }

    @Test
    public void editAndValidateEventTest() throws InterruptedException {
        eventsPage.clickOnEventByTitle("New Automated Title");
        eventsPage.clickEditButton();

        eventsPage.clearEventTitle();
        eventsPage.clearImageText();
        eventsPage.clearEventDate();
        eventsPage.clearEventLocation();
        eventsPage.clearEventDescription();

        createEventPage.enterEventTitle("new test automation");
        createEventPage.enterEventImage("https://img.magnific.com/premium-vector/icon-design-test-paper_362714-11527.jpg?semt=ais_hybrid&w=740&q=80");
        createEventPage.enterEventDate("07.04.2026");
        createEventPage.enterEventLocation("test location");
        createEventPage.enterEventDescription("test description");

        eventsPage.clickUpdateEventButton();

        assertEquals("new test automation", eventsPage.getEventTitle());
        assertEquals("https://img.magnific.com/premium-vector/icon-design-test-paper_362714-11527.jpg?semt=ais_hybrid&w=740&q=80", eventsPage.getEventImageTxt());
        assertEquals("07.04.2026", eventsPage.getEventDate());
        assertEquals("test location", eventsPage.getEventLocation());
        assertEquals("test description", eventsPage.getEventDescription());

    }

    @AfterEach
    //at the end we delete the created post so our database stays healthy and clear
    public void tearDownAndDeletePostTest() throws InterruptedException {
        eventsPage.navigateTo("http://localhost:3000/events");
        eventsPage.clickOnEventByTitle("New Automated Title");
        eventsPage.clickDeleteEventButton();
        eventsPage.clickDeleteFinal();
        assertTrue(eventsPage.isEventDeleted());
        driver.quit();
    }


}
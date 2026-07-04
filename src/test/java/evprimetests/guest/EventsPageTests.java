package evprimetests.guest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EventsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventsPageTests {

    private WebDriver driver;
    private EventsPage eventsPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        eventsPage = new EventsPage(driver);
        eventsPage.navigateTo("http://localhost:3000/");
        eventsPage.clickEventsButton();
        assertEquals("http://localhost:3000/events", driver.getCurrentUrl());
    }

    @Test
    public void validateEventTest() throws InterruptedException {
        eventsPage.clickOnEventByTitle("test title");
        assertEquals("http://localhost:3000/events/e8b1cd55-22c5-41c5-a339-dc819fe25a26", driver.getCurrentUrl());
        assertEquals("https://cdn.pixabay.com/photo/2014/06/03/19/38/road-sign-361514_640.png", eventsPage.getEventImageTxt());
        assertEquals("test title", eventsPage.getEventTitle());
        assertEquals("2025-12-07", eventsPage.getEventDate());
        assertEquals("test location 100", eventsPage.getEventLocation());
        assertEquals("test description 100", eventsPage.getEventDescription());
    }

    @Test
    public void validateBackToEventsButton() throws InterruptedException {
        eventsPage.clickOnEvent(0);
        eventsPage.clickBackToEventsButton();
        assertEquals("http://localhost:3000/events", driver.getCurrentUrl());
    }

    @Test
    public void validateColorFromBackButton() throws InterruptedException {
        eventsPage.clickOnEvent(0);
        assertEquals("#9c27b0", eventsPage.getColorFromBackButton());
    }

    @Test
    public void validateAnotherEventTest() throws InterruptedException {
        eventsPage.clickOnEventByTitle("Car Meet");
        assertEquals("http://localhost:3000/events/d1e13a92-9964-4fe5-b064-5e5c97138882", driver.getCurrentUrl());
        assertEquals("https://dealerimages.dealereprocess.com/image/upload/3870158",eventsPage.getEventImageTxt());
        assertEquals("Car Meet", eventsPage.getEventTitle());
        assertEquals("2026-02-04", eventsPage.getEventDate());
        assertEquals("Vienna Airport", eventsPage.getEventLocation());
        assertEquals("We are inviting you to the biggest car meet in Austria ,Want to come with you car and be seen ? Sign up for free", eventsPage.getEventDescription());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

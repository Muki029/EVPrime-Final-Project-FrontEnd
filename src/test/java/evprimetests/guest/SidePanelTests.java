package evprimetests.guest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SidePanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SidePanelTests {

    private WebDriver driver;
    private SidePanel sidePanel;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        sidePanel.navigateTo("http://localhost:3000/");
    }

    @Test
    public void sidePanelTextValidation() {
        sidePanel.clickMenuIcon();

        assertEquals("Home", sidePanel.getTextFromMenuHomeButton());
        assertEquals("Events", sidePanel.getTextFromEventsButton());
        assertEquals("Contact", sidePanel.getTextFromContactButton());
        assertEquals("Login", sidePanel.getTextFromLoginButton());
    }

    @Test
    public void sidePanelFontValidation() {
        sidePanel.clickMenuIcon();

        assertEquals("\"Josefin Sans\"", sidePanel.getFontFromHomeButton());
        assertEquals("\"Josefin Sans\"", sidePanel.getFontFromEventsButton());
        assertEquals("\"Josefin Sans\"", sidePanel.getFontFromContactButton());
        assertEquals("\"Josefin Sans\"", sidePanel.getFontFromLoginButton());

        assertEquals("normal", sidePanel.getFontStyleFromHomeButton());
        assertEquals("normal", sidePanel.getFontStyleFromEventsButton());
        assertEquals("normal", sidePanel.getFontStyleFromContactButton());
        assertEquals("normal", sidePanel.getFontStyleFromLoginButton());
    }

    @Test
    public void closeSidePanel() throws InterruptedException {
        sidePanel.clickMenuIcon();

        Thread.sleep(1000);

        sidePanel.clickCloseMenuButton();

        assertTrue(sidePanel.isMenuClosed());
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

package evprimetests.guest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.ContactsPage;

import static org.junit.jupiter.api.Assertions.*;

public class ContactsPageTests {

    private WebDriver driver;
    private ContactsPage contactsPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        contactsPage = new ContactsPage(driver);
        contactsPage.navigateTo("http://localhost:3000/");
        contactsPage.clickContactButton();

    }

    @Test
    public void validatePageTitleandUrlTest() {
        assertEquals("http://localhost:3000/contact", driver.getCurrentUrl());
        assertEquals("Want to reach out?", contactsPage.getTitleFromContactsPage());
    }

    @Test
    public void validateBoldingWhileHoveringTest() throws InterruptedException {
        assertEquals("0.8px", contactsPage.getUserNameTitleBorderWidth()); //before
        contactsPage.hoverOverUserName();
        assertEquals("1.6px", contactsPage.getUserNameTitleBorderWidth()); //after
    }

    @Test
    public void validateErrorMessage() {
        //validate errormessage without entering data into fields
        contactsPage.clickSendButton();
        assertEquals("Please fill out this field.", contactsPage.getErrorMessageUserName());
    }


    @Test

    public void validateErrorMessageWithoutEmail() {

        //validate errorMessage without entering email
        contactsPage.enterUserName("newuser");
        contactsPage.clickSendButton();
        assertEquals("Please fill out this field.", contactsPage.getErrorMessageEmail());
    }

    @Test
    public void validateErrorMessageWithInvalidEmail() throws InterruptedException {
        //validate errorMessage with entering invalid email
        contactsPage.enterEmail("email.com");

        assertEquals("Please include an '@' in the email address. 'email.com' is missing an '@'.", contactsPage.getErrorMessageEmail());

        //now we add @ at the wrong place

        contactsPage.clearTextFromEmailField();
        contactsPage.enterEmail("email@.com");

        assertEquals("'.' is used at a wrong position in '.com'.", contactsPage.getErrorMessageEmail());

        //now we remove .com to validate another error message
        contactsPage.clearTextFromEmailField();
        contactsPage.enterEmail("email@");

        assertEquals("Please enter a part following '@'. 'email@' is incomplete.", contactsPage.getErrorMessageEmail());

        //now we add two '@' in email to validate the error message

        contactsPage.clearTextFromEmailField();
        contactsPage.enterEmail("email@@");

        assertEquals("A part following '@' should not contain the symbol '@'.", contactsPage.getErrorMessageEmail());

    }

    @Test
    public void validateErrorMessagesAtMessageFieldTest() {
        //we enter valid username and email, but we leave message field blank

        contactsPage.enterUserName("username");
        contactsPage.enterEmail("email@email.com");
        contactsPage.clickSendButton();


        assertEquals("Please fill out this field.", contactsPage.getErrorMessageMessage());

    }

    @Test
    public void successfulySendReachOutMessageTest() {
        contactsPage.enterUserName("username");
        contactsPage.enterEmail("email@email.com");
        contactsPage.enterMessage("we are done testing this field");
        contactsPage.clickSendButton();

        assertFalse(contactsPage.isErrorMessageDisplayed());
    }

    @Test
    public void validateSendButtonColor() {
        assertEquals("#304ffe", contactsPage.getSendButtonColor());
    }

    @Test
    public void validateFooterData() {
        assertEquals("Rampo Lefkata 1", contactsPage.getTextFromAdressFooter());
        assertEquals("ev@rampo.com", contactsPage.getTextFromEmailFooter());
        assertEquals("+389 75 500 000", contactsPage.getTextFromPhoneNumberFooter());

    }
    @Test
    public void borderColorChangesAfterClickingTest() {
        assertEquals("rgba(0, 0, 0, 0.42)",contactsPage.getNameFieldBorderColorBeforeClick());
        contactsPage.clickUserNameField();
        assertEquals("#304ffe",contactsPage.getNameFieldBorderColorAfterClick());
    }
    @Test
    public void borderColorTurnsRedAfterInvalidNameRemove() throws InterruptedException {
        assertEquals("rgba(0, 0, 0, 0.42)",contactsPage.getNameFieldBorderColorBeforeClick());
        contactsPage.enterUserName("aaa");
        contactsPage.clickSendButton();
        contactsPage.clearTextFromNameField();
        //now we expect that boder bottom color turns red
        assertEquals("#d32f2f",contactsPage.getNameFieldBorderColorAfterClick());
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}

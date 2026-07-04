package evprimetests.guest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginSignupPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSignupPageTests {
    private WebDriver driver;
    private LoginSignupPage loginSignupPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginSignupPage = new LoginSignupPage(driver);
        loginSignupPage.navigateTo("http://localhost:3000/");
        loginSignupPage.clickLoginMenubutton();
    }

    @Test
    public void validateTitleFromLoginButtonTest() {

        assertEquals("Log in", loginSignupPage.getTitleFromLoginRegisterPage());
    }

    @Test
    public void validateValuesFromEmailAndPasswordFieldsTest() {
        assertEquals("E-Mail", loginSignupPage.getTextFromEmailField());
        assertEquals("Password", loginSignupPage.getTextFromPasswordField());
    }

    @Test
    public void validateTextFromButtonsTest() {
        assertEquals("GO", loginSignupPage.getTextFromGoButton());
        assertEquals("CREATE USER", loginSignupPage.getTextFromCreateUserButton());
    }

    @Test
    public void validateFontFromEnterTextFieldTest() {
        assertEquals("\"Josefin Sans\"", loginSignupPage.getFontFamilyFromEmailField());
        assertEquals("normal", loginSignupPage.getFontStyleFromEmailField());
    }

    @Test
    public void validateColorsFromButtonsTest() {
        assertEquals("#304ffe", loginSignupPage.getGoButtonColor());

        assertEquals("#9c27b0", loginSignupPage.getCreateUserButtonColor());

    }

    @Test
    public void validateButtonChangingTextWhenClicked() throws InterruptedException {
        loginSignupPage.clickCreateUserButton();
        //after clicking CREATE USER button it changes its text into LOG IN
        assertEquals("LOG IN", loginSignupPage.getTextFromCreateUserButton());
    }

    @Test
    public void validateErrorMessageText() throws InterruptedException {
        //in this case we are leaving the email and password fields blank so we just click on GO button
        loginSignupPage.clickGoButton();
        assertEquals("Authentication failed.", loginSignupPage.get3ErrorMessageText());
    }

    @Test
    public void loginWithInvalidEmailAndPassword() throws InterruptedException {
        //whenever email exist or not the error message is always the same "Authentication failed."

        loginSignupPage.enterEmail("email.email@mail.com");
        loginSignupPage.enterPassword("password123");
        loginSignupPage.clickGoButton();

        assertEquals("Authentication failed.", loginSignupPage.get3ErrorMessageText());
    }

    @Test
    public void enterEmailWithoutPasswordTest() throws InterruptedException {
        //the error message remains same whenever we enter or not an email or password
        loginSignupPage.enterEmail("email.email@email.com");
        loginSignupPage.clickGoButton();

        assertEquals("Authentication failed.", loginSignupPage.get3ErrorMessageText());
    }


    //WE ARE GOING TO CLICK CREATE USER BUTTON - Create new user and continue with tests

    @Test
    public void validateUrlAfterClickingCreateuserButtonTest() throws InterruptedException {
        loginSignupPage.clickCreateUserButton();

        //we use boolean to validate url after clicking createuser button
        assertTrue(loginSignupPage.isCreateuserButtonClicked());
    }

    @Test
    public void validateErrormessageWithoutEnteringDataInTxtFieldsTest() throws InterruptedException {
        loginSignupPage.clickCreateUserButton();
        loginSignupPage.clickGoButton();


        assertEquals("Invalid email.", loginSignupPage.get1ErrorMessage());
        assertEquals("Invalid password. Must be at least 6 characters long.", loginSignupPage.get2ErrorMessage());
        assertEquals("User signup failed due to validation errors.", loginSignupPage.get3ErrorMessageText());
    }

    //BVA
    @Test
    public void validateErrorMessageWithEnteringInvalidEmailTest() throws InterruptedException {
        loginSignupPage.clickCreateUserButton();
        loginSignupPage.enterEmail("eeeee");
        loginSignupPage.enterPassword("password123!");
        loginSignupPage.clickGoButton();

        assertEquals("Invalid email.", loginSignupPage.get1ErrorMessage());
        assertEquals("User signup failed due to validation errors.", loginSignupPage.get3ErrorMessageText());
    }

    @Test
    public void validateErrorMessageWithEnteringInvalidPassowrdTest() throws InterruptedException {
        loginSignupPage.clickCreateUserButton();
        loginSignupPage.enterEmail("mail.mail@mail.com");
        loginSignupPage.enterPassword("1");
        loginSignupPage.clickGoButton();

        assertEquals("Invalid password. Must be at least 6 characters long.", loginSignupPage.get1ErrorMessage());
        assertEquals("User signup failed due to validation errors.", loginSignupPage.get3ErrorMessageText());
    }

    @Test
    //we are going to sign up and later use this account to log in and proceed to testing
    public void SucessfullySignup() throws InterruptedException {
        loginSignupPage.clickCreateUserButton();
        loginSignupPage.enterEmail("final.project@creativehub.mk");
        loginSignupPage.enterPassword("creativeHub123!");
        loginSignupPage.clickGoButton();
    }

    @Test
    //we try to signup with already existing email

    public void signUpWithAlreadyExistingEmail() throws InterruptedException {
        loginSignupPage.clickCreateUserButton();
        loginSignupPage.enterEmail("final.project@creativehub.mk");
        loginSignupPage.enterPassword("creativeHub123!");
        loginSignupPage.clickGoButton();

        assertEquals("Email exists already.", loginSignupPage.get1ErrorMessage());
        assertEquals("User signup failed due to validation errors.", loginSignupPage.get3ErrorMessageText());
    }

    @Test

    public void logOutTest() throws InterruptedException {
        loginSignupPage.enterEmail("final.project@creativehub.mk");
        loginSignupPage.enterPassword("creativeHub123!");
        loginSignupPage.clickGoButton();

        loginSignupPage.clickLogOutButton();
        assertFalse(loginSignupPage.isUserLogedIn());
    }

    @Test
    public void SucessfullyLogIn() throws InterruptedException {

        loginSignupPage.enterEmail("final.project@creativehub.mk");
        loginSignupPage.enterPassword("creativeHub123!");
        loginSignupPage.clickGoButton();

        assertTrue(loginSignupPage.isUserLogedIn());
    }

    //now the tests continues in "user" package where we test in functions of the page as user not guest :)

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

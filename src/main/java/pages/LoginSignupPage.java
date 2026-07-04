package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage extends BasePage {

    private By logInPageTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[1]");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By goButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[1]/button");
    private By createUserButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]/button");
    private By loginMenuButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[4]/div/div[2]/span");
    private By emailLabel = By.xpath("//label[text()='E-Mail']");
    private By passwordLabel = By.xpath("//label[text()='Password']");
    private By errorMessage = By.xpath("//span[contains(@class, 'MuiTypography-subject2')]");
    private By errorEmailMessage = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li[1]");
    private By errorPasswordMessage = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li[2]");
    private By addEventButton = By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    private By logOutButton = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/ul/li/div");
    private By createEventButton = By.xpath("//*[@id=\"SpeedDial-actions\"]/button");


    public LoginSignupPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogOutButton() throws InterruptedException {
        clickElement(logOutButton);
        Thread.sleep(1000);
    }

    public void hoverOnAddEventButton() throws InterruptedException {
        hoverOverElement(addEventButton);
        Thread.sleep(1000);
    }
    public void clickCreateEventButton() throws InterruptedException {
        clickElement(createEventButton);
        Thread.sleep(1000);
    }


    public String get1ErrorMessage() {
        return getTextFromElement(errorEmailMessage);
    }

    public String get2ErrorMessage() {
        return getTextFromElement(errorPasswordMessage);
    }

    public boolean isUserLogedIn() {
        return isElementDisplayed(addEventButton);

    }

    public void enterEmail(String email) {
        sendKeysToTextField(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeysToTextField(passwordField, password);
    }

    public String get3ErrorMessageText() {
        return getTextFromElement(errorMessage);
    }

    public String getTitleFromLoginRegisterPage() {
        return getTextFromElement(logInPageTitle);
    }

    public void clickLoginMenubutton() {
        clickElement(loginMenuButton);
    }


    public String getTextFromEmailField() {
        return getTextFromElement(emailLabel);
    }

    public String getTextFromPasswordField() {
        return getTextFromElement(passwordLabel);
    }

    public String getTextFromGoButton() {
        return getTextFromElement(goButton);
    }

    public String getTextFromCreateUserButton() {
        return getTextFromElement(createUserButton);
    }

    public void clickGoButton() throws InterruptedException {
        clickElement(goButton);
        Thread.sleep(1000);
    }

    public void clickCreateUserButton() throws InterruptedException {
        clickElement(createUserButton);
        Thread.sleep(1000);
    }

    public String getGoButtonColor() {
        return getColorFromElement(goButton);
    }

    public String getCreateUserButtonColor() {
        return getColorFromElement(createUserButton);
    }


    public String getFontStyleFromEmailField() {
        return getFontStyleFromElement(emailField);
    }

    public boolean isCreateuserButtonClicked() {
        return driver.getCurrentUrl().contains("mode=signup");
    }

    public String getFontFamilyFromEmailField() {
        return getFontFamilyFromElement(emailField);
    }


}
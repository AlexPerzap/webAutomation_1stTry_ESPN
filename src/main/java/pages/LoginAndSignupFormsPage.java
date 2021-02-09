package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginAndSignupFormsPage extends BasePage {
//Log in form related locators
    @FindBy(how = How.CSS, using = ".field-username-email input[type='email']")
    private WebElement emailField;
    @FindBy(how = How.CSS, using = ".field-password input[type='password']")
    private WebElement passwordField;
    @FindBy(how = How.CSS, using = "div:nth-of-type(3)>button")
    private WebElement submitButton;
    @FindBy(id = "disneyid-iframe")
    private WebElement loginAndSignupForms_IFrame;
    @FindBy(how = How.CSS, using = "form>section>div:nth-of-type(5)>a")
    private WebElement goToSignupForm_Button;
//Sign up form related locators
    @FindBy(how = How.CSS, using = "input[name='firstName']")
    private WebElement firstNameField;
    @FindBy(how = How.CSS, using = "input[name='lastName']")
    private WebElement lastNameField;
    @FindBy(how = How.CSS, using = "input[name='email']")
    private WebElement signupEmailField;
    @FindBy(how = How.CSS, using = "input[name='newPassword']")
    private WebElement signupPasswordField;
    @FindBy(how = How.CSS, using = "button[did-translate='create.SIGN_UP']")
    private WebElement signupConfirmation_Button;

    public LoginAndSignupFormsPage(WebDriver driver){
        super(driver);
    }

    public void fillAndSubmitLoginForm(String email, String password){
        signupEmailField.sendKeys(email);
        signupPasswordField.sendKeys(password);
        submitButton.click();
        getWait().until(ExpectedConditions.invisibilityOf(loginAndSignupForms_IFrame));// attention!
        switchToParentContent();
    }

    public HomePage createAccount(String fName, String lName, String email, String password){
        clickAfterWaiting(goToSignupForm_Button);
        getWait().until(ExpectedConditions.elementToBeClickable(signupConfirmation_Button)); //attention
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        signupEmailField.sendKeys(email);
        signupPasswordField.sendKeys(password);
        signupConfirmation_Button.click();
        getWait().until(ExpectedConditions.invisibilityOf(loginAndSignupForms_IFrame));
        switchToParentContent();
        return new HomePage(getDriver());
    }
}

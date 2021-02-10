package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupFormPage extends BasePage{
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
    @FindBy(id = "disneyid-iframe")
    private WebElement disneyIdIFrame;

    public SignupFormPage(WebDriver driver){
        super(driver);
    }

    public void createAccount(String fName, String lName, String email, String password){
        log.info("Fill the 'create account' form and submit it");
        getWait().until(ExpectedConditions.elementToBeClickable(signupConfirmation_Button)); //attention!
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        signupEmailField.sendKeys(email);
        signupPasswordField.sendKeys(password);
        clickAfterWaiting(signupConfirmation_Button);
        getWait().until(ExpectedConditions.invisibilityOf(disneyIdIFrame)); //now and then
        switchToParentContent();
    }
}

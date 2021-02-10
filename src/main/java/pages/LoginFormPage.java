package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginFormPage extends BasePage {

    @FindBy(how = How.CSS, using = ".field-username-email input[type='email']")
    private WebElement emailField;
    @FindBy(how = How.CSS, using = ".field-password input[type='password']")
    private WebElement passwordField;
    @FindBy(how = How.CSS, using = "div:nth-of-type(3)>button")
    private WebElement submitButton;
    @FindBy(id = "disneyid-iframe")
    private WebElement disneyIdIFrame;
    @FindBy(how = How.CSS, using = "form>section>div:nth-of-type(5)>a")
    private WebElement goToSignupForm_Button;

    public LoginFormPage(WebDriver driver){
        super(driver);
    }

    public void getLoggedIn(String email, String password){

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
        getWait().until(ExpectedConditions.invisibilityOf(disneyIdIFrame));// attention!
        switchToParentContent();
    }

    public SignupFormPage goToSignupForm(){
        clickAfterWaiting(goToSignupForm_Button);
        return new SignupFormPage(getDriver());
    }
}

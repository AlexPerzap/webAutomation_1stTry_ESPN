package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSignupPage extends BasePage {
    @FindBy(how = How.CSS, using = ".field-username-email input[type='email']")
    private WebElement emailField;
    @FindBy(how = How.CSS, using = ".field-password input[type='password']")
    private WebElement passwordField;
    @FindBy(how = How.CSS, using = "div:nth-of-type(3)>button")
    private WebElement submitButton;
    @FindBy(id = "disneyid-iframe")
    private WebElement loginIFrame;


    public LoginSignupPage(WebDriver driver){
        super(driver);
    }

    public void fillAndSubmitLoginForm(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
        getWait().until(ExpectedConditions.invisibilityOf(loginIFrame));// attention!
    }

    //fill and submit para delete(reutilizo) parametros(exclusivos) se envían desde el test

}

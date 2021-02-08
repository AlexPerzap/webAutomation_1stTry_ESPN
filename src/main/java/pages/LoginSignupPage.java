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


    public LoginSignupPage(WebDriver driver){
        super(driver);
    }

    public void setEmail(String email){
        emailField.sendKeys(email);
    }
    public void setPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        //getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(submitButton)))
        //getWait();
        submitButton.click();
    //    getDriver().switchTo().defaultContent();
    }
}

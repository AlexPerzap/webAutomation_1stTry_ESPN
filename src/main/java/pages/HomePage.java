package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage{

    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;
    @FindBy(css=".tools a[tref*='login']")
    private WebElement loginLink;
    @FindBy(id = "disneyid-iframe")
    private WebElement loginIFrame;
    @FindBy(css=".tools a[onClick*='logout']")
    private WebElement logoutLink;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public LoginSignupPage goToLoginForm(){
        clickAfterWaiting(userIcon);
        clickAfterWaiting(loginLink);
        getDriver().switchTo().frame(loginIFrame);
        return new LoginSignupPage(getDriver());
    }

    public String checkLogoutBtnText(){
        clickAfterWaiting(userIcon);
        return logoutLink.getAttribute("innerText");
    }

    public void logOut(){
        clickAfterWaiting(userIcon);
        clickAfterWaiting(logoutLink);
    }



}

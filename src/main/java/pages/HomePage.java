package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;
    @FindBy(css=".tools a[tref*='login']")
    private WebElement loginLink;
    @FindBy(id = "disneyid-iframe")
    private WebElement disneyIdIFrame;
    @FindBy(css=".tools a[onClick*='logout']")
    private WebElement logoutLink;
    @FindBy(css=".user a[tref*='modifyAccount']")
    private WebElement espnProfileLink;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public LoginFormPage goToLoginForm(){
        clickAfterWaiting(userIcon);
        clickAfterWaiting(loginLink);
        getDriver().switchTo().frame(disneyIdIFrame);
        return new LoginFormPage(getDriver());
    }

    public String checkLogoutBtnText(){
        clickAfterWaiting(userIcon);
        return logoutLink.getAttribute("innerText");
    }
    public String checkLoginBtnText(){
        clickAfterWaiting(userIcon);
        return loginLink.getAttribute("innerText");
    }

    public void logOut(){
        clickAfterWaiting(userIcon);
        clickAfterWaiting(logoutLink);
    }

    public UpdateAccountPage goToUpdateAccountPage(){
        clickAfterWaiting(userIcon);
        clickAfterWaiting(espnProfileLink);
        getDriver().switchTo().frame(disneyIdIFrame);
        return new UpdateAccountPage(getDriver());
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        log.info("Click on the user icon and then click on the 'log in' link");
        clickAfterWaiting(userIcon);
        clickAfterWaiting(loginLink);
        getDriver().switchTo().frame(disneyIdIFrame);
        return new LoginFormPage(getDriver());
    }

    public String checkLogoutBtnText(){
        log.info("Click on the user icon and check if the 'log out' link is available to confirm the 'log in' was successful");
        clickAfterWaiting(userIcon);
        return logoutLink.getAttribute("innerText");
    }
    public String checkLoginBtnText(){
        log.info("Click on the user icon and check if the 'log in' link is available to confirm the 'log out' was successful");
        clickAfterWaiting(userIcon);
        return loginLink.getAttribute("innerText");
    }

    public void logout(){
        log.info("Click on the user icon and then click on the 'log out' link");
        clickAfterWaiting(userIcon);
        clickAfterWaiting(logoutLink);
        getWait().until(ExpectedConditions.elementToBeClickable(userIcon));
    }

    public UpdateAccountPage goToUpdateAccountPage(){
        log.info("Click on the user icon and then click on the 'ESPN Profile' link");
        clickAfterWaiting(userIcon);
        clickAfterWaiting(espnProfileLink);
        getDriver().switchTo().frame(disneyIdIFrame);
        return new UpdateAccountPage(getDriver());
    }
}

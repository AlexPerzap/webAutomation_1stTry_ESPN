package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage{

    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;
    @FindBy(css=".tools a[tref*='login']")
    private WebElement logInLink;
    @FindBy(id = "disneyid-iframe")
    private WebElement iFrame;

    @FindBy(css=".tools a[onClick*='logout']")
    private WebElement logOutLink;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public LoginSignupPage clickLoginBtn(){
        getWait().until(ExpectedConditions.visibilityOf(userIcon));
        userIcon.click();
        getWait().until(ExpectedConditions.visibilityOf(logInLink));
        logInLink.click();
        getDriver().switchTo().frame(iFrame);
        return new LoginSignupPage(getDriver());
    }

    public String checkLogoutBtn(){
        getWait().until(ExpectedConditions.visibilityOf(userIcon));
        userIcon.click();
        getWait().until(ExpectedConditions.visibilityOf(logOutLink));
        return logOutLink.getAttribute("innerText");
    }

    public void backToHome() {
        getDriver().switchTo().defaultContent();
    }
}

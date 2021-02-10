package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpdateAccountPage extends BasePage{

    @FindBy(id = "cancel-account")
    private WebElement deleteAccountLink;
    @FindBy(how = How.CSS, using = "button[did-translate='deactivate.confirmation.buttons.confirm']")
    private WebElement confirmDeleteAccountButton;
    @FindBy(id = "disneyid-iframe")
    private WebElement disneyIdIFrame;
    @FindBy(how = How.CSS, using = "span.name.ng-isolate-scope[did-translate=\"update.label.EMAIL\"]")
    private WebElement emailTitle;

    public UpdateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void deleteAccount(){
        getWait().until(ExpectedConditions.visibilityOf(emailTitle)); //attention
        Actions actions = new Actions(getDriver());
        actions.moveToElement(deleteAccountLink).perform();
        clickAfterWaiting(deleteAccountLink);
        clickAfterWaiting(confirmDeleteAccountButton);
        getWait().until(ExpectedConditions.invisibilityOf(disneyIdIFrame));
        switchToParentContent();
    }
}

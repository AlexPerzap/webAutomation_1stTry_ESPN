package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpdateAccountPage extends BasePage{


    @FindBy(how = How.CSS, using = "disneyid-iframe")
    private WebElement loginAndSignupForms_IFrame;

    public UpdateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void deleteAccount(){

    }
}

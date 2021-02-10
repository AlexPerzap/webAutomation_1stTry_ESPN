package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    protected Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver pDriver){
        PageFactory.initElements(pDriver, this);
        wait = new WebDriverWait(pDriver, 15);
        this.driver = pDriver;
    }

    protected WebDriver getDriver() {
        return driver;
    }
    protected WebDriverWait getWait() {
        return wait;
    }

    public void clickAfterWaiting(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void switchToParentContent(){
        getDriver().switchTo().defaultContent();
    }

}

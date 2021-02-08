package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver pDriver){
        PageFactory.initElements(pDriver, this);
        wait = new WebDriverWait(pDriver, 15);
        this.driver = pDriver;
        //this.wait = new WebDriverWait(this.driver, 20);
    }

    protected WebDriver getDriver() {
        return driver;
    }
    protected WebDriverWait getWait() {
        return wait;
    }

    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }



}

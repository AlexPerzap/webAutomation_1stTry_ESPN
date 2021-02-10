package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    protected Logger log = LoggerFactory.getLogger(BaseTests.class);

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.espnqa.com/?src=com&espn=cloud&_adblock=true");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

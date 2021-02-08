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

//    HomePage HomePage1 = PageFactory.initElements(driver, HomePage.class);
//    LoginPage loginPage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        Logger logger = LoggerFactory.getLogger(BaseTests.class);
        logger.info("Hello World");
    }

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.espnqa.com/?src=com&espn=cloud&_adblock=true");

        //driver.manage().window().maximize();
        homePage = new HomePage(driver);

    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
      //  homePage.clickLoginBtn();

    }
}

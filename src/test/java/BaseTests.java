
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;


public class BaseTests {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        Logger logger = LoggerFactory.getLogger(BaseTests.class);
        logger.info("Hello World");
    }

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        // Your test code here
    }
}

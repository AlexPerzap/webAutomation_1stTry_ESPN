package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.HomePage;

import java.util.UUID;

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

    protected String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[1][2];
        String randomString = generateRandomString();

        // 1st row
        data[0][0] = "juanperzap@gmail.com";
        data[0][1] = "clave098";
        // 2nd row
        //data[1][0] = "neonio@gmail.com";
        //data[1][1] = "¿'0987";
        return data;
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

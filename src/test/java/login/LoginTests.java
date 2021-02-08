package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginSignupPage;


public class LoginTests extends BaseTests {

    @Test
    public void loginTest(){
        LoginSignupPage loginSignupPage = homePage.clickLoginBtn();
        loginSignupPage.setEmail("juanperzap@gmail.com");
        loginSignupPage.setPassword("clave098");
        loginSignupPage.clickSubmit();
        homePage.backToHome();
        Assert.assertEquals(homePage.checkLogoutBtn(), "Log Out", "Incorrect text");
    }
}

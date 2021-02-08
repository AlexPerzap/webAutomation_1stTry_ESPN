package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginSignupPage;


public class LoginTests extends BaseTests {

    @Test(description = "Logging in with valid data")
    public void withValidData(){
        LoginSignupPage loginSignupPage = homePage.goToLoginForm();
        loginSignupPage.fillAndSubmitLoginForm("juanperzap@gmail.com", "clave098");
        homePage.switchToParentContent();
        Assert.assertEquals(homePage.checkLogoutBtnText(), "Log Out", "Login failed");
        homePage.logOut();
    }
}

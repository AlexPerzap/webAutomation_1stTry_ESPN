package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginFormPage;


public class LoginTests extends BaseTests {

    @Test(description = "Logging in with valid data")
    public void withValidData(){
        LoginFormPage loginFormPage = homePage.goToLoginForm();
        loginFormPage.getLoggedIn("juanperzap@gmail.com", "clave098");
        Assert.assertEquals(homePage.checkLogoutBtnText(), "Log Out", "Login failed");
        homePage.logOut();
    }
}

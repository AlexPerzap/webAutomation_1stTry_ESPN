package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginFormPage;

public class LoginTests extends BaseTests {

    @Test(dataProvider = "getData")
    public void withValidData(String email, String password){
        LoginFormPage loginFormPage = homePage.goToLoginForm();
        loginFormPage.getLoggedIn(email, password);
        Assert.assertEquals(homePage.checkLogoutBtnText(), "Log Out", "Login failed");
        homePage.logout();
        log.info("Login_test has been run");
    }
}

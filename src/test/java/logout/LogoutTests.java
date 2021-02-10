package logout;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginFormPage;

public class LogoutTests extends BaseTests {

    @BeforeMethod
    @Parameters({"email", "password"})
    public void loggingIn(String email, String password){
        LoginFormPage loginFormPage = homePage.goToLoginForm();
        loginFormPage.getLoggedIn(email, password);
        homePage.switchToParentContent();
    }

    @Test
    public void logout(){
        homePage.logout();
        Assert.assertEquals(homePage.checkLogoutBtnText(), "Log Out", "Logout failed");
        log.info("Logout_test has been run");
    }
}

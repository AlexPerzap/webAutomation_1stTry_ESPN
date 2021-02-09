package logout;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginAndSignupFormsPage;

public class LogoutTests extends BaseTests {

    @BeforeMethod
    public void loggingIn(){
        LoginAndSignupFormsPage loginAndSignupFormsPage = homePage.goToLoginForm();
        loginAndSignupFormsPage.fillAndSubmitLoginForm("juanperzap@gmail.com", "clave098");
        homePage.switchToParentContent();
    }

    @Test
    public void logout(){
        homePage.logOut();
        Assert.assertEquals(homePage.checkLogoutBtnText(), "Log Out", "Logout failed");
    }
}

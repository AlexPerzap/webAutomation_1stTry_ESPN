package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginAndSignupFormsPage;


public class LoginTests extends BaseTests {

    @Test(description = "Logging in with valid data")
    public void withValidData(){
        LoginAndSignupFormsPage loginAndSignupFormsPage = homePage.goToLoginForm();
        loginAndSignupFormsPage.fillAndSubmitLoginForm("juanperzap@gmail.com", "clave098");
        //homePage.switchToParentContent(); //prescindible ¿por qué?
        Assert.assertEquals(homePage.checkLogoutBtnText(), "Log Out", "Login failed");
        homePage.logOut();
    }
}

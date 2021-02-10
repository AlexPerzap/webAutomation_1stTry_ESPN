package accountManagement;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginFormPage;
import pages.SignupFormPage;
import pages.UpdateAccountPage;

public class DeleteAccountTests extends BaseTests {
    @BeforeMethod
    public void createNewAccount(){
        LoginFormPage loginFormPage = homePage.goToLoginForm();
        SignupFormPage signupFormPage = loginFormPage.goToSignupForm();
        signupFormPage.createAccount(
                "22juanperzap",
                "22toDelete",
                "44juanperzap_toDelete@gmail.com",
                "22clave098_toDelete");
    }

    @Test
    public void deleteAccount(){
        UpdateAccountPage updateAccountPage = homePage.goToUpdateAccountPage();
        updateAccountPage.deleteAccount();
        Assert.assertEquals(homePage.checkLoginBtnText(), "Log In", "Delete account failed");
        log.info("Delete_account_test have run");
    }
}

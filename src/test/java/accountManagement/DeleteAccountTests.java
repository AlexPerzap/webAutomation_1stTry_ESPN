package accountManagement;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginFormPage;
import pages.SignupFormPage;
import pages.UpdateAccountPage;

public class DeleteAccountTests extends BaseTests {

    @BeforeMethod
    @Parameters({"firstName","lastName","password"})
    public void createNewAccount(String firstName, String lastName, String password){
        LoginFormPage loginFormPage = homePage.goToLoginForm();
        SignupFormPage signupFormPage = loginFormPage.goToSignupForm();
        signupFormPage.createAccount(firstName, lastName, generateRandomString() + "_toDelete@testEmail.com", password);
    }

    @Test
    public void deleteAccount(){
        UpdateAccountPage updateAccountPage = homePage.goToUpdateAccountPage();
        updateAccountPage.deleteAccount();
        Assert.assertEquals(homePage.checkLoginBtnText(), "Log In", "Delete account failed");
        log.info("DeleteAccount_test has been run");
    }
}

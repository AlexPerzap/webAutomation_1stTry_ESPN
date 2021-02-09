package accountManagement;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginAndSignupFormsPage;

public class DeleteAccountTests extends BaseTests {
    @BeforeMethod
    public void createNewAccount(){
        LoginAndSignupFormsPage loginAndSignupFormsPage = homePage.goToLoginForm();
        loginAndSignupFormsPage.createAccount(
                "4juanperzap",
                "4toDelete",
                "4juanperzap_toDelete@gmail.com",
                "4clave098_toDelete");
        //homePage.switchToParentContent();
    }

    @Test
    public void deleteAccount(){
        System.out.println("upiupi");
    }
}

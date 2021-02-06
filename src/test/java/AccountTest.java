import org.testng.annotations.*;

import java.util.logging.Logger;


public class AccountTest {

    public Logger log = Logger.getLogger(AccountTest.class.getName());

    @BeforeTest
    public void device(){
        log.info("Having a working device and an internet connection");
    }
    @BeforeClass
    public void visit(){
        log.info("Browse to www.espn.com");
    }
    @BeforeMethod
    public void icon(){
        log.info("Click on the person icon at the top right");
    }
    @Test
    public void createAccount(){
        log.info("Click on Log in");
        log.info("Click on Sign up");
        log.info("Introduce the required personal data");
        log.info("Click on Sign up again");
    }
    @Test
    public void logOut(){
        log.info("Click on Log out");
    }
    @Test
    public void logIn(){
        log.info("Click on Log in");
        log.info("Enter an already registered username and password");
        log.info("Click on Log in again");
    }
    @Test
    public void deleteAccount(){
        log.info("Click on 'ESPN profile'");
        log.info("Click on 'Delete account' at the bottom of the modal");
        log.info("Click on 'Yes, delete this account'");
    }


}

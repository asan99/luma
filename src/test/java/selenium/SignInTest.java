package selenium;

import configTest.ConfigReaderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{
    
    @Test(description = "sign in to the site")
    public void signIn(){
        signInPage.signIn();
        Assert.assertTrue(homePage.checkWelcomeText(
                ConfigReaderTest.getTestProperty("name"),
                ConfigReaderTest.getTestProperty("lastName")));
    }


    @Test(description = "input wrong login")
    public void wrongSignIn(){
        Assert.assertTrue(signInPage.checkCustomerLogin());
    }

    @Test(description = "this is sout")
    void someTest(){
        System.out.println("test were done");
    }


}

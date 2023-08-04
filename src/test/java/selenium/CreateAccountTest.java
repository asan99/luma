package selenium;


import configTest.ConfigReaderTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.ui.helper.WaitManager;
import selenium.ui.models.CustomerAccountForm;

public class CreateAccountTest extends BaseTestForCreateAccount {


    @Test(description = "creating testing account")

    public void createAccountTest() {
        homePage.clickOnCreateAccount();
        Assert.assertTrue(createNewAccountPage.checkCreateNewAccountCustomerText());
        CustomerAccountForm customerAccountForm = fakeDataProvider.generateCustomerAccount();
        createNewAccountPage.fillUpTheCreateForm(customerAccountForm);
        WaitManager.pause(3);
        Assert.assertTrue(homePage.checkWelcomeText(customerAccountForm));
        Assert.assertTrue(homePage.checkThankYouForRegisteringText());
    }

    @Test(description = "verifying mandatory fields")
    public void verifyMandatoryFields() {
        homePage.clickOnCreateAccount();
        CustomerAccountForm customerAccountForm = fakeDataProvider.generateCustomerAccount();
        Assert.assertTrue(createNewAccountPage.checkMandatoryFirstNameField(customerAccountForm));
        Assert.assertTrue(createNewAccountPage.checkMandatoryLastNameField(customerAccountForm));
        Assert.assertTrue(createNewAccountPage.checkMandatoryEmailField(customerAccountForm));
        Assert.assertTrue(createNewAccountPage.checkMandatoryPasswordField(customerAccountForm));
        Assert.assertTrue(createNewAccountPage.checkMandatoryPasswordConfirmationField(customerAccountForm));
    }

    @Test
    public void checkingPasswordStrength() {
        homePage.clickOnCreateAccount();
        Assert.assertTrue(createNewAccountPage.checkPasswordStrengthEmpty());
        Assert.assertTrue(createNewAccountPage
                .checkPasswordStrengthWeak(ConfigReaderTest.getTestProperty("weak_password")));
        Assert.assertTrue(createNewAccountPage
                .checkPasswordStrengthMedium(ConfigReaderTest.getTestProperty("medium_password")));
        Assert.assertTrue(createNewAccountPage
                .checkPasswordStrengthStrong(ConfigReaderTest.getTestProperty("strong_password")));
        Assert.assertTrue(createNewAccountPage
                .checkPasswordStrengthVeryStrong(ConfigReaderTest.getTestProperty("very_strong_password")));
    }



}

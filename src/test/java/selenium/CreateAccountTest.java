package selenium;


import configTest.ConfigReaderPassword;
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
                .checkPasswordStrengthWeak(ConfigReaderPassword.getPasswordProperty("weak_password")));
        Assert.assertTrue(createNewAccountPage
                .checkPasswordStrengthMedium(ConfigReaderPassword.getPasswordProperty("medium_password")));
        Assert.assertTrue(createNewAccountPage
                .checkPasswordStrengthStrong(ConfigReaderPassword.getPasswordProperty("strong_password")));
        Assert.assertTrue(createNewAccountPage
                .checkPasswordStrengthVeryStrong(ConfigReaderPassword.getPasswordProperty("very_strong_password")));
    }



}

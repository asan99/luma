package selenium.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.ui.helper.WaitManager;
import selenium.ui.models.CustomerAccountForm;

public class CreateNewAccountPage extends BasePage {
    @FindBy(id = "firstname")
    WebElement inputFirstName;

    @FindBy(id = "lastname")
    WebElement inputLastName;

    @FindBy(id = "email_address")
    WebElement inputEmailAddress;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(id = "password-confirmation")
    WebElement inputConfirmPassword;

    @FindBy(xpath = "//span[text()='Create an Account']")
    WebElement clickOnCreateAccountButton;

    @FindBy(xpath = "//span[text()='Create New Customer Account']")
    WebElement createNewCustomerAccountText;

    @FindBy(xpath = "//div[@for=\"firstname\"]")
    WebElement firstnameError;

    @FindBy(xpath = "//div[@for=\"lastname\"]")
    WebElement lastnameError;

    @FindBy(xpath = "//div[@for=\"email_address\"]")
    WebElement emailAddressError;

    @FindBy(xpath = "//div[@for=\"password\"]")
    WebElement passwordError;

    @FindBy(xpath = "//div[@for=\"password-confirmation\"]")
    WebElement passwordConfirmationError;

    @FindBy(id = "password-strength-meter-container")
    WebElement passwordStrengthPasswordError;

    @FindBy(id = "password-strength-meter")
    WebElement passwordColor;

    public final String CREATE_NEW_CUSTOMER_ACCOUNT = "Create New Customer Account";
    public final String REQUIRED_FIELD_TEXT = "This is a required field.";
    public final String PASSWORD_STRENGTH_NO_PASSWORD_TEXT = "Password Strength: No Password";
    public final String PASSWORD_STRENGTH_WEAK_TEXT = "Password Strength: Weak";
    public final String PASSWORD_STRENGTH_MEDIUM_TEXT = "Password Strength: Medium";
    public final String PASSWORD_STRENGTH_STRONG_TEXT = "Password Strength: Strong";
    public final String PASSWORD_STRENGTH_VERY_STRONG_TEXT = "Password Strength: Very Strong";

    @Step("fill up the create form")
    public CreateNewAccountPage fillUpTheCreateForm(CustomerAccountForm customerAccountForm) {
        elementActions
                .sendKeys(inputFirstName, customerAccountForm.getFirstName())
                .sendKeys(inputLastName, customerAccountForm.getLastName())
                .sendKeys(inputEmailAddress, customerAccountForm.getEmailAddress())
                .sendKeys(inputPassword, customerAccountForm.getPassword())
                .sendKeys(inputConfirmPassword, customerAccountForm.getPassword())
                .click(clickOnCreateAccountButton);

        return this;
    }

    @Step("check for creating new account customer")
    public boolean checkCreateNewAccountCustomerText() {
        return elementActions.getText(createNewCustomerAccountText).equals(CREATE_NEW_CUSTOMER_ACCOUNT);
    }

    @Step("check mandatory first name field")
    public boolean checkMandatoryFirstNameField(CustomerAccountForm customerAccountForm) {
        elementActions
                .sendKeys(inputFirstName, " ")
                .sendKeys(inputLastName, customerAccountForm.getLastName())
                .sendKeys(inputEmailAddress, customerAccountForm.getEmailAddress())
                .sendKeys(inputPassword, customerAccountForm.getEmailAddress())
                .sendKeys(inputPassword, customerAccountForm.getPassword())
                .sendKeys(inputConfirmPassword, customerAccountForm.getConfirmPassword())
                .click(clickOnCreateAccountButton);
        return elementActions.getText(firstnameError).equals(REQUIRED_FIELD_TEXT);
    }

    @Step("check mandatory last name field")
    public boolean checkMandatoryLastNameField(CustomerAccountForm customerAccountForm) {
        elementActions
                .sendKeys(inputFirstName, customerAccountForm.getFirstName())
                .sendKeys(inputLastName, " ")
                .sendKeys(inputEmailAddress, customerAccountForm.getEmailAddress())
                .sendKeys(inputPassword, customerAccountForm.getPassword())
                .sendKeys(inputConfirmPassword, customerAccountForm.getConfirmPassword())
                .click(clickOnCreateAccountButton);

        return elementActions.getText(lastnameError).equals(REQUIRED_FIELD_TEXT);
    }

    @Step("check mandatory email field")
    public boolean checkMandatoryEmailField(CustomerAccountForm customerAccountForm) {
        elementActions
                .sendKeys(inputFirstName, customerAccountForm.getFirstName())
                .sendKeys(inputLastName, customerAccountForm.getLastName())
                .sendKeys(inputEmailAddress, " ")
                .sendKeys(inputPassword, customerAccountForm.getPassword())
                .sendKeys(inputConfirmPassword, customerAccountForm.getPassword())
                .click(clickOnCreateAccountButton);
        return elementActions.getText(emailAddressError).equals(REQUIRED_FIELD_TEXT);
    }

    @Step("check mandatory password field")
    public boolean checkMandatoryPasswordField(CustomerAccountForm customerAccountForm) {
        elementActions
                .sendKeys(inputFirstName, customerAccountForm.getFirstName())
                .sendKeys(inputLastName, customerAccountForm.getLastName())
                .sendKeys(inputEmailAddress, customerAccountForm.getEmailAddress())
                .sendKeys(inputPassword, " ")
                .sendKeys(inputConfirmPassword, customerAccountForm.getConfirmPassword())
                .click(clickOnCreateAccountButton);
        return elementActions.getText(passwordError).equals(REQUIRED_FIELD_TEXT);
    }

    @Step("check mandatory confirm password field")
    public boolean checkMandatoryPasswordConfirmationField(CustomerAccountForm customerAccountForm) {
        elementActions
                .sendKeys(inputFirstName, customerAccountForm.getFirstName())
                .sendKeys(inputLastName, customerAccountForm.getLastName())
                .sendKeys(inputEmailAddress, customerAccountForm.getEmailAddress())
                .sendKeys(inputPassword, customerAccountForm.getPassword())
                .sendKeys(inputConfirmPassword, "")
                .click(clickOnCreateAccountButton);
        return elementActions.getText(passwordConfirmationError).equals(REQUIRED_FIELD_TEXT);
    }


    @Step("check password strength NO PASSWORD")
    public boolean checkPasswordStrengthEmpty() {
        elementActions.scrollToElement(passwordStrengthPasswordError);
       return elementActions.getText(passwordStrengthPasswordError).equals(PASSWORD_STRENGTH_NO_PASSWORD_TEXT);
    }

    @Step("check password strength WEAK")
    public boolean checkPasswordStrengthWeak(String weakPassword) {
        elementActions.sendKeys(inputPassword,weakPassword);
        elementActions.waitElementToBeDisplayed(passwordStrengthPasswordError);
        return elementActions.getText(passwordStrengthPasswordError).equals(PASSWORD_STRENGTH_WEAK_TEXT);
    }

    @Step("check password strength MEDIUM")
    public boolean checkPasswordStrengthMedium(String mediumPassword) {
        elementActions.sendKeys(inputPassword, mediumPassword);
        return elementActions.getText(passwordStrengthPasswordError).equals(PASSWORD_STRENGTH_MEDIUM_TEXT);
    }

    @Step("check password strength STRONG")
    public boolean checkPasswordStrengthStrong(String strongPassword) {
        elementActions.sendKeys(inputPassword, strongPassword);
        WaitManager.pause(3);
        return elementActions.getText(passwordStrengthPasswordError).equals(PASSWORD_STRENGTH_STRONG_TEXT);
    }

    @Step("check password strength VERY STRONG")
    public boolean checkPasswordStrengthVeryStrong(String veryStrongPassword) {
        elementActions.sendKeys(inputPassword, veryStrongPassword);
        return elementActions.getText(passwordStrengthPasswordError).equals(PASSWORD_STRENGTH_VERY_STRONG_TEXT);
    }



}

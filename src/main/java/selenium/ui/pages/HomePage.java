package selenium.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.ui.models.CustomerAccountForm;


public class HomePage extends BasePage {
    @FindBy(xpath = "//a[text()='Create an Account']")
    WebElement createAnAccount;

    @FindBy(xpath = "//a[normalize-space()='Sign In']")
    WebElement signInButton;

    @FindBy(xpath = "//span[@class=\"logged-in\"]")
    private WebElement welcomeText;

    @FindBy(xpath = "//div[text()='Thank you for registering with Main Website Store.']")
    private WebElement thankYouForRegistering;




    @Step("click on create account button")
    public CreateNewAccountPage clickOnCreateAccount() {
        elementActions.click(createAnAccount);

        return new CreateNewAccountPage();
    }

    public SignInPage clickOnSignInBtn() {
        elementActions.click(signInButton);
        return new SignInPage();
    }

    @Step("checking welcome text is visible")
    public boolean checkWelcomeText(CustomerAccountForm customerAccountForm) {
        String WELCOME_USER_MESSAGE = "Welcome, " + customerAccountForm.getFirstName() + " "
                + customerAccountForm.getLastName() + "!";
        return elementActions.getText(welcomeText).equals(WELCOME_USER_MESSAGE);
    }

    @Step("checking for thank you registering text is visible")
    public boolean checkThankYouForRegisteringText() {
        final String THANK_YOU_FOR_REGISTERING = "Thank you for registering with Main Website Store.";
        return elementActions.getText(thankYouForRegistering).equals(THANK_YOU_FOR_REGISTERING);
    }

    @Step("checking welcome text is visible")
    public boolean checkWelcomeText(String name, String lastName) {
        String WELCOME_USER_MESSAGE = "Welcome, " + name + " "
                + lastName + "!";
        elementActions.waitElementToBeDisplayed(welcomeText);
        return elementActions.getText(welcomeText).equals(WELCOME_USER_MESSAGE);
    }

}

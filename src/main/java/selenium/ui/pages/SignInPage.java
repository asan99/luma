package selenium.ui.pages;


import io.netty.channel.EventLoopException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.ui.config.ConfigReader;


public class SignInPage extends BasePage{

    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(id = "pass")
    WebElement inputPassword;

    @FindBy(id = "send2")
    WebElement signInBtn;

    @FindBy(xpath = "//div[@class=\"page messages\"]")
    WebElement pleaseWaitAndTry;

    public final String THE_ACCOUNT_WAS_INCORRECT_TEST = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";


    public HomePage signIn(){
        elementActions.sendKeys(inputEmail, ConfigReader.getProperty("email"))
                .sendKeys(inputPassword, ConfigReader.getProperty("password"))
                .click(signInBtn);
        return new HomePage();
    }

    public boolean checkCustomerLogin() {
        elementActions.sendKeys(inputEmail, "turduhodzhaev9@gmail.com")
                .sendKeys(inputPassword, ConfigReader.getProperty("password"))
                .click(signInBtn)
                .waitElementToBeDisplayed(pleaseWaitAndTry);
        return pleaseWaitAndTry.getText().equals(THE_ACCOUNT_WAS_INCORRECT_TEST);
    }

}

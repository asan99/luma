package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import selenium.ui.config.FakeDataProvider;
import selenium.ui.drivers.Driver;
import selenium.ui.helper.ElementActions;
import selenium.ui.pages.CreateNewAccountPage;
import selenium.ui.pages.HomePage;
import selenium.ui.pages.SignInPage;

public abstract class BaseTest {
    public WebDriver driver;
    public ElementActions elementActions;
    public FakeDataProvider fakeDataProvider;
    public HomePage homePage;
    public CreateNewAccountPage createNewAccountPage;
    public SignInPage signInPage;



    @BeforeClass
    public void setUpBrowser() {
        driver = Driver.getDriver();
        elementActions = new ElementActions();
        fakeDataProvider = new FakeDataProvider();
        createNewAccountPage = new CreateNewAccountPage();
        homePage = new HomePage();
        signInPage = new SignInPage();
    }


    @BeforeMethod
    public void openLuma() {
        driver.get("https://magento.softwaretestingboard.com/");
        homePage.clickOnSignInBtn();

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}

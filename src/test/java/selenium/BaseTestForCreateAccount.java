package selenium;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import selenium.ui.config.FakeDataProvider;
import selenium.ui.drivers.Driver;
import selenium.ui.helper.ElementActions;
import selenium.ui.pages.CreateNewAccountPage;
import selenium.ui.pages.HomePage;

public class BaseTestForCreateAccount {
    public WebDriver driver;
    public ElementActions elementActions;
    public FakeDataProvider fakeDataProvider;
    public HomePage homePage;
    public CreateNewAccountPage createNewAccountPage;


//    @BeforeClass
//    public void setUpBrowser() {
//        driver = Driver.getDriver();
//        elementActions = new ElementActions();
//        fakeDataProvider = new FakeDataProvider();
//        createNewAccountPage = new CreateNewAccountPage();
//        homePage = new HomePage();
//
//    }

    @BeforeMethod
    @Step("open luma site")
    public void openLuma() {
        driver = Driver.getDriver();
        elementActions = new ElementActions();
        fakeDataProvider = new FakeDataProvider();
        createNewAccountPage = new CreateNewAccountPage();
        homePage = new HomePage();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();

    }


}

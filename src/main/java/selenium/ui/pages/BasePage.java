package selenium.ui.pages;


import org.openqa.selenium.support.PageFactory;
import selenium.ui.drivers.Driver;
import selenium.ui.helper.ElementActions;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public ElementActions elementActions = new ElementActions();

}

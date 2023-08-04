package selenium.ui.helper;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.ui.drivers.Driver;

import java.time.Duration;

public class ElementActions {

    public ElementActions waitButtonToBeClickable(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public ElementActions waitElementToBeDisplayed(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public ElementActions click(WebElement element) {
        waitButtonToBeClickable(element);
        element.click();
        return this;
    }


    public ElementActions clickJS(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        waitButtonToBeClickable(element);
        js.executeScript("arguments[0].click(true);", element);

        return this;
    }

    public ElementActions sendKeys(WebElement element, String text) {
        waitElementToBeDisplayed(element);
        clear(element);
        element.sendKeys(text);
        return this;
    }

    public ElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
//        js.executeScript("window.scrollBy(200,document.body.scrollHeight)", element);

        return this;
    }


    public ElementActions clear(WebElement element) {
        waitElementToBeDisplayed(element);
        element.clear();
        return this;
    }

    public ElementActions clickWithJs(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", element);
        return this;
    }

    public ElementActions highlightElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid red");
        return this;

    }

    public String getText(WebElement element){
        return element.getText();
    }



}
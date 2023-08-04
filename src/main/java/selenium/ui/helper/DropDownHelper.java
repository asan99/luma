package selenium.ui.helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DropDownHelper {
    public static void selectUsingVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectUsingValue(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByValue(text);
    }

    public static void selectUsingIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static List<String> getAllDropDownValues(WebElement locator){
        Select select = new Select(locator);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<>();

        for(WebElement element: elementList){
            valueList.add(element.getText());
        }
        return valueList;
    }

    public static List<WebElement> clickDropDown(WebElement locator) {
        Select select = new Select(locator);
        return select.getOptions();

    }


    public static void selectRandomValue(WebElement element){
        Random random = new Random();
        List<String> colors = getAllDropDownValues(element);
        int index = random.nextInt(colors.size());
        String color = colors.get(index);
        selectUsingVisibleText(element, color);
    }


}

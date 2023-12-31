package selenium.ui.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class OperaWebDriver {

    public static WebDriver loadOperaWebDriver(){
        WebDriverManager.edgedriver().setup();
        EdgeDriver options = new EdgeDriver();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }


}

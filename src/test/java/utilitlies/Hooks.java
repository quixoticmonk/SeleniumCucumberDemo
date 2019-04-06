package utilitlies;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks{
    private static WebDriver driver;
    private static final BrowserFactory browserFactory = new BrowserFactory();

    @Before
    public static void setup(){
        driver=browserFactory.configureDriver();
    }

    @After
    public static void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver returnDriver(){
        return driver;
    }
}

package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utilitlies.BrowserFactory;

import static utilitlies.BrowserFactory.closeBrowser;
import static utilitlies.BrowserFactory.openUrl;
import static utilitlies.LoggerUtil.info;

public class Hooks{
    private static WebDriver driver;
    private static final BrowserFactory browserFactory = new BrowserFactory();

    @Before()
    public void setup(Scenario scenario){
        info("------------------------------");
        info("Starting - " + scenario.getName());
        info("------------------------------");

        driver=browserFactory.configureDriver();
        openUrl("");
    }

    @After()
    public void tearDown(Scenario scenario){
        closeBrowser();

        info("------------------------------");
        info(scenario.getName() + " Status - " + scenario.getStatus());
        info("------------------------------");
    }

    static WebDriver returnDriver(){
        return driver;
    }
}

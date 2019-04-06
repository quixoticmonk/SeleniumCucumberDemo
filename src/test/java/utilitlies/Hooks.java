package utilitlies;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks{
    private static WebDriver driver;
    private static final BrowserFactory browserFactory = new BrowserFactory();

    @Before("@first")
    public void setup(Scenario scenario){
        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");

        driver=browserFactory.configureDriver();
        browserFactory.openUrl("");
    }

    @After("@first")
    public void tearDown(Scenario scenario){
        if (driver != null) {
            driver.quit();
        }

        System.out.println("------------------------------");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("------------------------------");
    }

    public static WebDriver returnDriver(){
        return driver;
    }
}

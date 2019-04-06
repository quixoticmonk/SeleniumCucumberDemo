package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utilitlies.BrowserFactory;
import utilitlies.Hooks;

public class LoginSteps {
    private static WebDriver driver;
    private static LoginPage loginPage;
    BrowserFactory browserFactory = new BrowserFactory();

 /*   public  LoginSteps() {
        driver = Hooks.returnDriver();
    }*/

    @Before("@first")
    public void setup(Scenario scenario){
        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");

        driver=browserFactory.configureDriver();
        //browserFactory.openUrl("");
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

    @Given("I am on the url {string}")
    public static void iAmOnTheUrl(String url) {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.verifyIAmOnLoginPage(url);

    }

    @When("I enter {string} for the field {string}")
    public static void iEnterForTheField(String fieldValue, String fieldlabel) {
        loginPage.enterFieldValue(fieldValue, fieldlabel);
    }

    @When("I select the {string} button")
    public static void iSelectTheButton(String buttonLabel) {
        loginPage.selectButton(buttonLabel);
    }

    @Then("I see the message {string}")
    public static void iSeeTheMessage(String messageText) {
        loginPage.validatMessageDisplayed(messageText);

    }


}

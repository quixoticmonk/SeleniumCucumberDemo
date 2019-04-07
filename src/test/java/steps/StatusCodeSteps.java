package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.StatusCodeIndPage;
import pages.StatusCodesPage;

import static pages.StatusCodesPage.passDriverInstance;

public class StatusCodeSteps {
    private static StatusCodesPage statusCodesPage;
    private static StatusCodeIndPage statusCodeIndPage ;
    private static WebDriver driver;

    public StatusCodeSteps(){
        driver=Hooks.returnDriver();
    }

    @Given("I am on the status Code url {string}")
    public void iAmOnTheStatusCodeUrl(String url) {
        statusCodesPage = PageFactory.initElements(driver,StatusCodesPage.class);
        statusCodesPage.verifyIAmOnStatusCodePage(url);

    }

    @And("I can see the status code {string} on the page")
    public void iCanSeeTheStatusCodeOnThePage(String statusCode) {
        statusCodesPage.verifyStatusCodesOnPage(statusCode);
    }

    @When("I select the status code {string}")
    public void iSelectTheStatusCode(String statusCode) {
        statusCodesPage.selectTheStatusCode(statusCode);
    }

    @Then("I am navigated to the status code {string}  page")
    public void iAmNavigatedToTheStatusCodePage(String statusCode) {
        statusCodeIndPage = PageFactory.initElements(passDriverInstance(),StatusCodeIndPage.class);
        statusCodeIndPage.validateIndividualStatusCodePage(statusCode);
    }

    @And("the message {string} is displayed to the user")
    public void theMessageIsDisplayedToTheUser(String statusMessage) {
        statusCodeIndPage.validateMessageDisplayed(statusMessage);

    }
}

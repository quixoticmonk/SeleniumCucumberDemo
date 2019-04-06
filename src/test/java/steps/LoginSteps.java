package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utilitlies.Hooks;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        driver = Hooks.returnDriver();
    }


    @Given("I am on the url {string}")
    public void iAmOnTheUrl(String url) {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.verifyIAmOnLoginPage(url);


    }

    @When("I enter {string} for the field {string}")
    public void iEnterForTheField(String fieldValue, String fieldlabel) {
        loginPage.enterFieldValue(fieldValue,fieldlabel);
    }

    @When("I select the {string} button")
    public void iSelectTheButton(String buttonLabel) {
        loginPage.selectButton(buttonLabel);
    }

    @Then("I see the message {string}")
    public void iSeeTheMessage(String messageText) {
        loginPage.validatMessageDisplayed(messageText);

    }


}

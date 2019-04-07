package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilitlies.BrowserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static utilitlies.SeleniumCommands.findElementByXpath;
import static utilitlies.SeleniumCommands.presenceOfElementByXpath;

public class LoginPage {
    private static final String PASSWORD_XPATH = "//input[@id='password']";
    private static final String LOGIN_HEADER_XPATH = "//h2[contains(text(),'Login Page')]";
    private static final String USERNAME_XPATH = "//input[@name='username']";
    private static WebDriver driver;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private static WebElement loginButton;
    public LoginPage(WebDriver driver1) {
        driver = driver1;
    }

    public void verifyIAmOnLoginPage(String url){
        BrowserFactory.openUrl(url);
        presenceOfElementByXpath(driver,LOGIN_HEADER_XPATH);
    }
    public void enterFieldValue(String fieldValue,String fieldLabel){
        switch (fieldLabel){
            case "UserName":
                findElementByXpath(driver,USERNAME_XPATH).sendKeys(fieldValue);
                break;
            case "Password":
                findElementByXpath(driver,PASSWORD_XPATH).sendKeys(fieldValue);
                break;
        }
    }
    public void selectButton(String buttonName){
        loginButton.click();
    }
    public void validatMessageDisplayed(String messageText){
        presenceOfElementByXpath(driver,"//h2[contains(text(),'Secure Area')]");
        assertThat(findElementByXpath(driver,"//h4[@class='subheader']").getText(),is(equalTo(messageText)));
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilitlies.BrowserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoginPage extends BrowserFactory {
    private static final String PASSWORD_XPATH = "//label[@for='password']";
    private static final String LOGIN_HEADER_XPATH = "//h2[contains(text(),'Login Page')]";
    private static final String USERNAME_XPATH = "//label[@for='username']";
    private static WebDriver driver;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private static WebElement loginButton;

    public LoginPage(WebDriver driver1) {
        driver = driver1;
    }

    public void verifyIAmOnLoginPage(String url){
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGIN_HEADER_XPATH)));
    }
    public void enterFieldValue(String fieldValue,String fieldLabel){
        switch (fieldLabel){
            case "UserName":
                driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(fieldValue);
                break;
            case "Password":
                driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(fieldValue);
                break;
        }
    }
    public static void selectButton(String buttonName){
        loginButton.click();
    }
    public void validatMessageDisplayed(String messageText){
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(text(),'Secure Area')]")));
        assertThat(driver.findElement(By.xpath("//h4[@class='subheader']")).getText(),is(equalTo(messageText)));
    }

}

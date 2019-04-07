package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static utilitlies.SeleniumCommands.findElementByXpath;

public class StatusCodeIndPage {
    private static WebDriver driver;
    private static final String STATUS_CODE_MESSAGE_XPATH="//p[contains(text(),\'%s\')]";
    public StatusCodeIndPage(WebDriver driver1){
        driver=driver1;
    }
    public void setDriverInstance(WebDriver driver1){
        driver=driver1;
    }
    public void validateIndividualStatusCodePage(String statusCode){
        String targetUrl = System.getProperty("baseUrl")+"/status_codes/"+statusCode;
        assertThat(driver.getCurrentUrl(),is(equalTo(targetUrl)));
    }

    public void validateMessageDisplayed(String statusMessage) {
        WebElement statusMessageElement = findElementByXpath(driver,String.format(STATUS_CODE_MESSAGE_XPATH,statusMessage));
        assertThat(statusMessageElement.isDisplayed(),is(equalTo(Boolean.TRUE)));
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import utilitlies.BrowserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static utilitlies.SeleniumCommands.findElementByXpath;
import static utilitlies.SeleniumCommands.presenceOfElementByXpath;

public class StatusCodesPage {
    private static WebDriver driver;
    private static final String STATUS_CODE_VALUE_XPATH = "//a[contains(text(),\'%s\')]";
    private static final String STATUS_CODE_HEADER_XPATH = "//h3[contains(text(),'Status Codes')]";

    public StatusCodesPage(WebDriver driver1) {
        driver = driver1;
    }

    public void verifyIAmOnStatusCodePage(String url) {
        BrowserFactory.openUrl(url);
        presenceOfElementByXpath(driver, STATUS_CODE_HEADER_XPATH);
    }

    public void verifyStatusCodesOnPage(String statusCode) {
        assertThat(findElementByXpath(driver, String.format(STATUS_CODE_VALUE_XPATH, statusCode)).isDisplayed(),is(equalTo(Boolean.TRUE)));

    }
    public void selectTheStatusCode(String statusCode) {
        findElementByXpath(driver,String.format(STATUS_CODE_VALUE_XPATH, statusCode)).click();
    }
    public static WebDriver passDriverInstance(){
        return driver;
    }


}

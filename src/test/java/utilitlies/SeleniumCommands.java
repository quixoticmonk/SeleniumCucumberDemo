package utilitlies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommands {
    public static void presenceOfElementByXpath(WebDriver driver,String xpath)
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    public static WebElement findElementByXpath(WebDriver driver, String xpath){
        return driver.findElement(By.xpath(xpath));
    }

}

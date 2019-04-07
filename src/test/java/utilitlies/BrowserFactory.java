package utilitlies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static WebDriver driver;
    private static final String BASE_URL = System.getProperty("baseUrl");
    private static final String BROWSER_NAME = System.getProperty("browserName");
    private static final String HEADLESS_CHROME = System.getProperty("headlessChrome");
    private static final String RUN_ON_GRID = System.getProperty("runOnGrid");
    private static final String CHROME = "CHROME";
    private static final String FIREFOX = "FIREFOX";
    private static final String INTERNET_EXPLORER = "INTERNET EXPLORER";
    private static ChromeOptions chromeOptions = new ChromeOptions();
    private static FirefoxOptions firefoxOptions = new FirefoxOptions();
    private static InternetExplorerOptions ieOptions = new InternetExplorerOptions();
    private static final String GRID_URL = System.getProperty("gridUrl");
    private static final String DRIVER_LOCATION=System.getProperty("driverLocation");
    private static final String CHROME_DRIVER_LCN=DRIVER_LOCATION+ File.separator+System.getProperty("chromeDriverBinary");

    public WebDriver configureDriver() {

        if ("true".equalsIgnoreCase(RUN_ON_GRID)) {
            switch (BROWSER_NAME) {
                case FIREFOX:
                    try {
                        driver = new RemoteWebDriver(new URL(GRID_URL), getFirefoxOptions());
                        setUpDriver();
                        return driver;
                    } catch (MalformedURLException e) {
                        e.getMessage();
                    }
                case CHROME:
                    try {
                        driver = new RemoteWebDriver(new URL(GRID_URL), getChromeOptions());
                        setUpDriver();
                        return driver;
                    } catch (MalformedURLException e) {
                        e.getMessage();
                    }
                case INTERNET_EXPLORER:
                    try {
                        driver = new RemoteWebDriver(new URL(GRID_URL), getIeOptions());
                        setUpDriver();
                        return driver;
                    } catch (MalformedURLException e) {
                        e.getMessage();
                    }
            }


        } else {
            switch (BROWSER_NAME.toUpperCase()) {
                case FIREFOX:
                    driver = configureFirefoxDriver();
                    setUpDriver();
                    break;
                case CHROME:
                    driver = configureChromeDriver();
                    setUpDriver();
                    break;
                case INTERNET_EXPLORER:
                    driver = configureIEDriver();
                    setUpDriver();
                    break;
                default:
                    break;
            }
        }
        return driver;
    }

    private void setUpDriver() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void openUrl(String url) {
        driver.get(BASE_URL + "/" + url);
    }
    public static void closeBrowser(){
        driver.close();
    }


    private static WebDriver configureIEDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver(getIeOptions());
    }

    private static WebDriver configureChromeDriver() {
        System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_LCN);
        return new ChromeDriver(getChromeOptions());
    }

    private static WebDriver configureFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(getFirefoxOptions());
    }

    private static ChromeOptions getChromeOptions() {
        if ("true".equalsIgnoreCase(HEADLESS_CHROME)) {
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.addArguments("--start-maximized")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage");
        return chromeOptions;
    }

    private static FirefoxOptions getFirefoxOptions() {
        firefoxOptions.addArguments("--start-maximized")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage");
        return firefoxOptions;
    }

    private static InternetExplorerOptions getIeOptions() {
        return ieOptions;
    }

}

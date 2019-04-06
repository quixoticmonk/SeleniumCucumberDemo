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

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
    private static WebDriver driver;
    private static final String BASE_URL = System.getProperty("baseUrl");
    private static final String BROWSER_NAME = System.getProperty("browserName");
    private static final String HEADLESS_CHROME = System.getProperty("headlessChrome");
    private static final String RUN_ON_GRID = System.getProperty("runOnGrid");
    private static final String CHROME = "Chrome";
    private static final String FIREFOX = "Firefox";
    private static final String INTERNET_EXPLORER = "Internet Explorer";
    private static ChromeOptions chromeOptions = new ChromeOptions();
    private static FirefoxOptions firefoxOptions = new FirefoxOptions();
    private static InternetExplorerOptions ieOptions = new InternetExplorerOptions();
    private static final String GRID_URL = System.getProperty("gridUrl");

    public WebDriver configureDriver() {
        if ("true".equalsIgnoreCase(RUN_ON_GRID)) {
            switch (BROWSER_NAME) {
                case FIREFOX:
                    try {
                        driver = new RemoteWebDriver(new URL(GRID_URL), getFirefoxOptions());
                        return driver;
                    } catch (MalformedURLException e) {
                        e.getMessage();
                    }
                case CHROME:
                    try {
                        driver = new RemoteWebDriver(new URL(GRID_URL), getChromeOptions());
                        return driver;
                    } catch (MalformedURLException e) {
                        e.getMessage();
                    }
                case INTERNET_EXPLORER:
                    try {
                        driver = new RemoteWebDriver(new URL(GRID_URL), getIeOptions());
                        return driver;
                    } catch (MalformedURLException e) {
                        e.getMessage();
                    }
            }


        } else {
            switch (BROWSER_NAME.toUpperCase()) {
                case FIREFOX:
                    driver = configureFirefoxDriver();
                    break;
                case CHROME:
                    driver = configureChromeDriver();
                    break;
                case INTERNET_EXPLORER:
                    driver = configureIEDriver();
                    break;
                default:
                    break;
            }
        }
        return driver;
    }

    public void openUrl(String url) {
        driver.get(BASE_URL + "/" + url);
    }


    private static WebDriver configureIEDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver(getIeOptions());
    }

    private static WebDriver configureChromeDriver() {
        WebDriverManager.chromedriver().setup();
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

package factories;

import data.BrowserData;
import exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory implements IFactory {
    private String browserName = System.getProperty("browser", "chrome");

    public void setUpDriver() throws BrowserNotSupportedException {

        switch (BrowserData.valueOf(browserName.toUpperCase())) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
            default:
                throw new BrowserNotSupportedException(browserName);
        }
    }

    @Override
    public WebDriver createDriver() throws BrowserNotSupportedException {
        switch (BrowserData.valueOf(browserName.toUpperCase())) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                return new ChromeDriver(chromeOptions);
            default:
                throw new BrowserNotSupportedException(browserName);
        }
    }
}

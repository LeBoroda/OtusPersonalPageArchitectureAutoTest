package otus;

import components.HeaderComponent;
import data.*;
import data.locationadata.CityData;
import exceptions.BrowserNotSupportedException;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class OtusPersonalInfoPageTest {
    private WebDriver driver;
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void init() throws BrowserNotSupportedException {
        driver = new WebDriverFactory().createDriver();
    }
    @AfterEach
    public void close(){
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }
    @Test
    public void fillPersonalInfo(){
        MainPage mainPage = new MainPage(driver);
        HeaderComponent headerComponent = new HeaderComponent(driver);

        mainPage.open();
        headerComponent
                .clickLoginButton()
                .loginToOtus()
                .clickPersonalMenu(PopupMenuItemsData.PERSONAL)
                .addLocationInfo(CityData.AKSAY)
                .addPersonalData()
                .clickSaveButton(SaveButtonData.SAVEANDFILLLATER);
        mainPage.clearSession()
                .open();
        headerComponent
                .clickLoginButton()
                .loginToOtus()
                .clickPersonalMenu(PopupMenuItemsData.PERSONAL)
                .checkAddedInformation()
                .checkLocationInformation(CityData.AKSAY);
    }
}

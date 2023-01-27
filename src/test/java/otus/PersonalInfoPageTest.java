package otus;

import exceptions.BrowserNotSupportedException;
import factories.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class PersonalInfoPageTest {
    private WebDriver driver;
    @BeforeAll
    public static void setUpDriver() throws BrowserNotSupportedException{
        new WebDriverFactory().setUpDriver();
    }
    @BeforeEach
    public void init() throws BrowserNotSupportedException {
        driver = new WebDriverFactory().createDriver();
    }
    @AfterEach
    public void close(){
        if(driver!=null){
            driver.close();
            driver.quit();
        }
    }
    @Test
    public void PersonalInfoPageTest(){
        new MainPage(driver)
                .OpenPage();

    }
}

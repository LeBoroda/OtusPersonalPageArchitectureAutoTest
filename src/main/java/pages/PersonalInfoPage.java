package pages;

import org.openqa.selenium.WebDriver;

public class PersonalInfoPage extends AbsPage{
    private String path = "/lk/biography/personal/";
    public PersonalInfoPage(WebDriver driver, String path) {
        super(driver, path);
    }
}

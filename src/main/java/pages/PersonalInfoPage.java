package pages;

import org.openqa.selenium.WebDriver;

public class PersonalInfoPage extends AbsPage{
    public PersonalInfoPage(WebDriver driver) {
        super(driver, "/lk/biography/personal/");
    }
}

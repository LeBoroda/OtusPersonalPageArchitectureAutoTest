package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderButtonComponent extends AbsComponent{
    public HeaderButtonComponent(WebDriver driver) {
        super(driver);
    }
    public HeaderButtonComponent clickLoginButton(){
        String selector = ".header3__button-sign-in";
        $(By.cssSelector(selector)).click();
        return this;
    }
}

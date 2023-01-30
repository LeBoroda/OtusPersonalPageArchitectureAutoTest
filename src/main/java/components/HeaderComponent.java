package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends AbsComponent{
    public HeaderComponent(WebDriver driver) {
        super(driver);
    }
    public ModalLoginComponent clickLoginButton(){
        String selector = ".header3__button-sign-in";
        $(By.cssSelector(selector)).click();
        return new ModalLoginComponent(driver);
    }
}

package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbsComponent {
    @FindBy(css = "\".header3__button-sign-in\"")
    WebElement loginButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public OtusLoginComponent clickLoginButton() {
        loginButton.click();
        return new OtusLoginComponent(driver);
    }

}

package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModalLoginComponent extends AbsComponent {

    private final String loginSelector = "input[class ^=new-input][name=email][type=text]";
    private final String passwordSelector = "input[class ^=new-input][name=password][type=password]";
    private final String submitButtonSelector = "button[class $=new-button_md][type=submit]";
    public ModalLoginComponent(WebDriver driver) {
        super(driver);
    }
    public PersonalMenuPopupComponent loginToOtus(){
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginSelector)));
        clearAndInput(By.cssSelector(loginSelector), System.getProperty("login"));
        clearAndInput(By.cssSelector(passwordSelector), System.getProperty("password"));
        $(By.cssSelector(submitButtonSelector)).submit();
        return new PersonalMenuPopupComponent(driver);
    }

}
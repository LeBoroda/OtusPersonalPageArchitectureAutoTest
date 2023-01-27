package components;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ModalLoginComponent extends AbsComponent {

    private String loginSelector = "input[class ^=new-input][name=email][type=text]";
    private String passwordSelector = "input[class ^=new-input][name=password][type=password]";
    private String submitButtonSelector = "button[class $=new-button_md][type=submit]";
    public ModalLoginComponent(WebDriver driver) {
        super(driver);
    }
    public void loginToOtus(){
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginSelector)));
        clearAndInput(By.cssSelector(loginSelector), System.getProperty("login"));
        clearAndInput(By.cssSelector(passwordSelector), System.getProperty("password"));
        $(By.cssSelector(submitButtonSelector)).submit();
    }

}
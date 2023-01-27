package components;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OtusLoginComponent extends AbsComponent implements IModalComponent{
    private String loginComponentSelector = "[class='new-log-reg__login'][data-mode='login']";
    public OtusLoginComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void popupShouldNotBeVisible() {
        Assertions.assertFalse(commonWaiter.waitForCondition(
                ExpectedConditions.visibilityOf($(By.cssSelector(loginComponentSelector))))
        );
    }

    @Override
    public void popupShouldBeVisible() {
        commonWaiter.waitToBeVisible(By.cssSelector(loginComponentSelector));
        Assertions.assertTrue(commonWaiter.waitForCondition(
                ExpectedConditions.visibilityOf($(By.cssSelector(loginComponentSelector))))
        );
    }
}

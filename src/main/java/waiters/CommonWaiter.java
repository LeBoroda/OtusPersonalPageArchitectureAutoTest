package waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonWaiter {

    private final WebDriver driver;

    public CommonWaiter(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForCondition(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            webDriverWait.until(condition);
        } catch (Exception ignored) {
        }
    }

}

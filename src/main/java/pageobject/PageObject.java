package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.CommonWaiters;

public abstract class PageObject {
    protected Actions actions;
    protected WebDriver driver;
    protected CommonWaiters commonWaiter;

    public PageObject(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        commonWaiter = new CommonWaiters(driver);
        PageFactory.initElements(driver, this);
    }
    protected WebElement $(By by){
        return driver.findElement(by);
    }
}

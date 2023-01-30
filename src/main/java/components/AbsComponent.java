package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

public abstract class AbsComponent extends PageObject {
    public AbsComponent(WebDriver driver) {
        super(driver);
    }
    protected void clearAndInput(By inputField, String line){
        $(inputField).clear();
        $(inputField).sendKeys(line);
    }
    public void dropDownMenuClick(By menu, By button) {
        actions.moveToElement($(menu)).click().perform();
        $(button).click();
    }
}

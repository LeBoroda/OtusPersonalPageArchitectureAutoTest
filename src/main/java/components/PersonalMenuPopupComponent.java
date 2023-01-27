package components;

import data.PopupMenuItemsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class PersonalMenuPopupComponent extends AbsComponent{

    private String popupMenuSelector = ".header3__user-info-name";
    private String popupSubMenuItemSelector = "a[href*=%s]";
    public PersonalMenuPopupComponent(WebDriver driver) {
        super(driver);
    }

    public void clickPersonalMenu(PopupMenuItemsData popupMenuItemsData){
        String selector = String.format(popupSubMenuItemSelector, popupMenuItemsData.getName().toLowerCase(Locale.ROOT));
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(popupMenuSelector)));
        actions.moveToElement($(By.cssSelector(popupMenuSelector))).perform();
//        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(popupSubMenuItemSelector)));
        $(By.cssSelector(selector)).click();

    }

}

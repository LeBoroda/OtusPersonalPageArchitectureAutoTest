package components;

import org.openqa.selenium.WebDriver;

public class OtusLoginComponent extends AbsComponent implements IModalComponent{
    public OtusLoginComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void popupShouldNotBeVisible() {

    }

    @Override
    public void popupShouldBeVisible() {

    }
}

package components.personalInfoComponents;

import components.AbsComponent;
import org.openqa.selenium.WebDriver;

public class personalInfoComponentMain extends AbsComponent {
    private String mainInfoSelector = "input[name='%s']";
    public personalInfoComponentMain(WebDriver driver) {
        super(driver);
    }
    public personalInfoComponentMain insertMainInfo(){

        return this;
    }
}

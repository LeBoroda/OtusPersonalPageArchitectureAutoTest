package pages;

import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

public abstract class AbsPage extends PageObject {
    private String baseUrl = System.getProperty("base.url");
    private String path;

    public AbsPage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }

    public void OpenPage() {
        if (!path.startsWith("/")) {
            path += "/";
        }
        driver.get(baseUrl.replaceAll("\\/$", "") + path);
    }

    
}

package components;

import data.*;
import data.locationadata.CityData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalInfoComponent extends AbsComponent {

    private final String buttonSelectorTemplate = "button[title='%s']";

    public PersonalInfoComponent(WebDriver driver) {
        super(driver);
    }
    public PersonalInfoComponent addPersonalData(){
        clearAndInput(By.cssSelector(PersonalInfoSelectorsData.FIRSTNAMECYR.getName()), TestData.FIRSTNAMECYR.getName());
        clearAndInput(By.cssSelector(PersonalInfoSelectorsData.FIRSTNAMELAT.getName()), TestData.FIRSTNAMELAT.getName());
        clearAndInput(By.cssSelector(PersonalInfoSelectorsData.LASTNAMECYR.getName()), TestData.LASTNAMECYR.getName());
        clearAndInput(By.cssSelector(PersonalInfoSelectorsData.LASTNAMELAT.getName()), TestData.LASTNAMELAT.getName());
        clearAndInput(By.cssSelector(PersonalInfoSelectorsData.BLOGNAME.getName()), TestData.BLOGNAME.getName());
        clearAndInput(By.cssSelector(PersonalInfoSelectorsData.DOB.getName()), TestData.DOB.getName());
        $(By.cssSelector(PersonalInfoSelectorsData.YESRELOCATE.getName())).click();
        $(By.cssSelector(PersonalInfoSelectorsData.WORKFULLDAY.getName())).click();
        $(By.cssSelector(PersonalInfoSelectorsData.WORKFLEXIBLE.getName())).click();
        dropDownMenuClick(By.cssSelector(PersonalInfoSelectorsData.FIRSTADDCONTACTMENU.getName()),
                By.cssSelector(PersonalInfoSelectorsData.TELEGRAM.getName()));
        clearAndInput(By.cssSelector(PersonalInfoSelectorsData.ADDITIONALCONTACT1.getName()), TestData.ADDITIONALCONTACT1.getName());
        $(By.cssSelector(PersonalInfoSelectorsData.PREFFERABLECONTACT.getName())).click();
        $(By.cssSelector(PersonalInfoSelectorsData.ADDCONTACT.getName())).click();
        dropDownMenuClick(By.cssSelector(PersonalInfoSelectorsData.SECONTADDCONTACTMENU.getName()),
                By.xpath(PersonalInfoSelectorsData.WHATSAPP.getName()));
        clearAndInput(By.cssSelector(PersonalInfoSelectorsData.ADDITIONALCONTACT2.getName()), TestData.ADDITIONALCONTACT2.getName());
        dropDownMenuClick(By.cssSelector(PersonalInfoSelectorsData.ENGLISHLEVEL.getName()),
                By.cssSelector(PersonalInfoSelectorsData.ENGLISHLEVELMASTERY.getName()));
        dropDownMenuClick(By.cssSelector(PersonalInfoSelectorsData.SEX.getName()),
                By.cssSelector(PersonalInfoSelectorsData.SEXFEMALE.getName()));
        clearAndInput(By.cssSelector(PersonalInfoSelectorsData.COMPANY.getName()), TestData.COMPANY.getName());
        clearAndInput(By.cssSelector(PersonalInfoSelectorsData.POSITION.getName()), TestData.POSITION.getName());

        return this;
    }

    public PersonalInfoComponent addLocationInfo(CityData cityData){
        String countryButtonSelector = String.format(buttonSelectorTemplate, cityData.getCountryName());
        String cityButtonSelector = String.format(buttonSelectorTemplate, cityData.getName());

        dropDownMenuClick(By.cssSelector("input[name='country']+div"), By.cssSelector(countryButtonSelector));

        waiter.waitForCondition(ExpectedConditions.not(
                ExpectedConditions.attributeContains(By.cssSelector("input[name='city']"),
                        "disabled", "disabled")));
        waiter.waitForCondition(ExpectedConditions.not(
                ExpectedConditions.attributeContains(By.cssSelector("input[name='country']"),
                        "disabled", "disabled")));
        waiter.waitForCondition(ExpectedConditions
                .elementToBeClickable(By.cssSelector("input[name='city']+div")));

        dropDownMenuClick(By.cssSelector("input[name='city']+div"), By.cssSelector(cityButtonSelector));
        return this;
    }

    public void clickSaveButton(SaveButtonData saveButtonData){
        String saveButtonSelector = String.format(buttonSelectorTemplate, saveButtonData.getName());
        $(By.cssSelector(saveButtonSelector)).click();
    }

    public PersonalInfoComponent checkAddedInformation(){

        Assertions.assertEquals(TestData.FIRSTNAMECYR.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.FIRSTNAMECYR.getName())).getAttribute("value"));
        Assertions.assertEquals(TestData.FIRSTNAMELAT.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.FIRSTNAMELAT.getName())).getAttribute("value"));
        Assertions.assertEquals(TestData.LASTNAMECYR.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.LASTNAMECYR.getName())).getAttribute("value"));
        Assertions.assertEquals(TestData.LASTNAMELAT.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.LASTNAMELAT.getName())).getAttribute("value"));
        Assertions.assertEquals(TestData.BLOGNAME.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.BLOGNAME.getName())).getAttribute("value"));
        Assertions.assertEquals(TestData.DOB.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.DOB.getName())).getAttribute("value"));
        Assertions.assertEquals(TestData.ENGLISHLEVEL.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.ENGLISHLEVEL.getName())).getText());
        Assertions.assertEquals(TestData.YESRELOCATE.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.YESRELOCATE.getName())).getText());
        Assertions.assertFalse(false,
                $(By.cssSelector(PersonalInfoSelectorsData.WORKFULLDAY.getName())).getAttribute("checked"));
        Assertions.assertTrue(true,
                $(By.cssSelector(PersonalInfoSelectorsData.WORKFLEXIBLE.getName())).getAttribute("checked"));
        Assertions.assertEquals(TestData.ADDITIONALMESSENGER1.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.FIRSTADDCONTACTMENU.getName())).getText());
        Assertions.assertEquals(TestData.ADDITIONALCONTACT1.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.ADDITIONALCONTACT1.getName())).getAttribute("value"));
        Assertions.assertTrue(true,
                $(By.cssSelector(PersonalInfoSelectorsData.PREFFERABLECONTACT.getName())).getAttribute("checked"));
        Assertions.assertEquals(TestData.ADDITIONALMESSENGER2.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.SECONTADDCONTACTMENU.getName())).getText());
        Assertions.assertEquals(TestData.ADDITIONALCONTACT2.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.ADDITIONALCONTACT2.getName())).getAttribute("value"));
        Assertions.assertFalse(false,
                $(By.cssSelector(PersonalInfoSelectorsData.PREFFERABLECONTACT.getName())).getAttribute("checked"));
        Assertions.assertEquals(TestData.SEXFEMALE.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.SEXFEMALE.getName())).getAttribute("value"));
        Assertions.assertEquals(TestData.COMPANY.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.COMPANY.getName())).getAttribute("value"));
        Assertions.assertEquals(TestData.POSITION.getName(),
                $(By.cssSelector(PersonalInfoSelectorsData.POSITION.getName())).getAttribute("value"));
        return this;
    }

    public void checkLocationInformation(CityData cityData){
        Assertions.assertEquals(cityData.getCountryName(),
                $(By.cssSelector("div[data-ajax-slave*=by_country]")).getText());
        Assertions.assertEquals(cityData.getName(),
                $(By.cssSelector("div[class*=slave-city]")).getText());
    }
}

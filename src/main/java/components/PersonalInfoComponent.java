package components;

import data.*;
import data.locationadata.CityData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalInfoComponent extends AbsComponent {

    private final String buttonSelectorTemplate = "button[title='%s']";
    private final String firstNameCyrSelector = "input[name='fname']";
    private final String firstNameLatSelector = "input[name='fname_latin']";
    private final String lastNameCyrSelector = "input[name='lname']";
    private final String lastNameLatSelector = "input[name='lname_latin']";
    private final String blogNameSelector = "input[name='blog_name']";
    private final String dOBSelector = "input[name='date_of_birth']";
    private final String yesRelocateSelector = "#id_ready_to_relocate_1+span";
    private final String workFullDaySelector = "input[value='full']+span";
    private final String workFlexibleSelector = "input[value='flexible']+span";
    private final String companyNameSelector = "#id_company";
    private final String workPositionSelector = "#id_work";
    private final String englishLevelFieldSelector = "input[name=english_level]+div";
    private final String englishLevelMasteryButtonSelector = "button[title='Супер продвинутый (Mastery)']";
    private final String sexFieldSelector = "div[class='select select_full']";
    private final String femaleSexButtonSelector = "#id_gender>option[value=f]";
    private final String additionalContact1Field = "input[name='contact-0-value']";
    private final String additionalContact2Field = "input[name='contact-1-value']";
    private final String telegramButtonSelector = "button[title='Тelegram']";
    private final String whatsappButtonSelector = "//*[@name='contact-1-id']//following::button[@title='WhatsApp']";
    private final String addContactInfoButtonSelector = "button[class*='custom-select-add']";
    private final String preferableContactCheckButtonSelector = "input[name='contact-0-preferable']+span";
    private final String firstAdditionalContactMenuSelector = "input[name*='contact-0']~.lk-cv-block__input";
    private final String secondAdditionalContactMenuSelector = "input[name*='contact-1']~.lk-cv-block__input";


    public PersonalInfoComponent(WebDriver driver) {
        super(driver);
    }
    public PersonalInfoComponent addPersonalData(){
        clearAndInput(By.cssSelector(firstNameCyrSelector), TestData.FIRSTNAMECYR.getName());
        clearAndInput(By.cssSelector(firstNameLatSelector), TestData.FIRSTNAMELAT.getName());
        clearAndInput(By.cssSelector(lastNameCyrSelector), TestData.LASTNAMECYR.getName());
        clearAndInput(By.cssSelector(lastNameLatSelector), TestData.LASTNAMELAT.getName());
        clearAndInput(By.cssSelector(blogNameSelector), TestData.BLOGNAME.getName());
        clearAndInput(By.cssSelector(dOBSelector), TestData.DOB.getName());
        $(By.cssSelector(yesRelocateSelector)).click();
        $(By.cssSelector(workFullDaySelector)).click();
        $(By.cssSelector(workFlexibleSelector)).click();
        dropDownMenuClick(By.cssSelector(firstAdditionalContactMenuSelector),
                By.cssSelector(telegramButtonSelector));
        clearAndInput(By.cssSelector(additionalContact1Field), TestData.ADDITIONALCONTACT1.getName());
        $(By.cssSelector(preferableContactCheckButtonSelector)).click();
        $(By.cssSelector(addContactInfoButtonSelector)).click();
        dropDownMenuClick(By.cssSelector(secondAdditionalContactMenuSelector),
                By.xpath(whatsappButtonSelector));
        clearAndInput(By.cssSelector(additionalContact2Field), TestData.ADDITIONALCONTACT2.getName());
        dropDownMenuClick(By.cssSelector(englishLevelFieldSelector),
                By.cssSelector(englishLevelMasteryButtonSelector));
        dropDownMenuClick(By.cssSelector(sexFieldSelector),
                By.cssSelector(femaleSexButtonSelector));
        clearAndInput(By.cssSelector(companyNameSelector), TestData.COMPANY.getName());
        clearAndInput(By.cssSelector(workPositionSelector), TestData.POSITION.getName());

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
                $(By.cssSelector(firstNameCyrSelector)).getAttribute("value"));
        Assertions.assertEquals(TestData.FIRSTNAMELAT.getName(),
                $(By.cssSelector(firstNameLatSelector)).getAttribute("value"));
        Assertions.assertEquals(TestData.LASTNAMECYR.getName(),
                $(By.cssSelector(lastNameCyrSelector)).getAttribute("value"));
        Assertions.assertEquals(TestData.LASTNAMELAT.getName(),
                $(By.cssSelector(lastNameLatSelector)).getAttribute("value"));
        Assertions.assertEquals(TestData.BLOGNAME.getName(),
                $(By.cssSelector(blogNameSelector)).getAttribute("value"));
        Assertions.assertEquals(TestData.DOB.getName(),
                $(By.cssSelector(dOBSelector)).getAttribute("value"));
        Assertions.assertEquals(TestData.ENGLISHLEVEL.getName(),
                $(By.cssSelector(englishLevelFieldSelector)).getText());
        Assertions.assertEquals(TestData.YESRELOCATE.getName(),
                $(By.cssSelector(yesRelocateSelector)).getText());
        Assertions.assertFalse(false,
                $(By.cssSelector(workFullDaySelector)).getAttribute("checked"));
        Assertions.assertTrue(true,
                $(By.cssSelector(workFlexibleSelector)).getAttribute("checked"));
        Assertions.assertEquals(TestData.ADDITIONALMESSENGER1.getName(),
                $(By.cssSelector(firstAdditionalContactMenuSelector)).getText());
        Assertions.assertEquals(TestData.ADDITIONALCONTACT1.getName(),
                $(By.cssSelector(additionalContact1Field)).getAttribute("value"));
        Assertions.assertTrue(true,
                $(By.cssSelector(preferableContactCheckButtonSelector)).getAttribute("checked"));
        Assertions.assertEquals(TestData.ADDITIONALMESSENGER2.getName(),
                $(By.cssSelector(secondAdditionalContactMenuSelector)).getText());
        Assertions.assertEquals(TestData.ADDITIONALCONTACT2.getName(),
                $(By.cssSelector(additionalContact2Field)).getAttribute("value"));
        Assertions.assertFalse(false,
                $(By.cssSelector(preferableContactCheckButtonSelector)).getAttribute("checked"));
        Assertions.assertEquals(TestData.SEXFEMALE.getName(),
                $(By.cssSelector(femaleSexButtonSelector)).getAttribute("value"));
        Assertions.assertEquals(TestData.COMPANY.getName(),
                $(By.cssSelector(companyNameSelector)).getAttribute("value"));
        Assertions.assertEquals(TestData.POSITION.getName(),
                $(By.cssSelector(workPositionSelector)).getAttribute("value"));
        return this;
    }

    public void checkLocationInformation(CityData cityData){
        Assertions.assertEquals(cityData.getCountryName(),
                $(By.cssSelector("div[data-ajax-slave*=by_country]")).getText());
        Assertions.assertEquals(cityData.getName(),
                $(By.cssSelector("div[class*=slave-city]")).getText());
    }
}

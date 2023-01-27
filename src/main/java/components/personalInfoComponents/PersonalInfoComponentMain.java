package components.personalInfoComponents;

import components.AbsComponent;
import data.PersonalPageInfoData;
import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class PersonalInfoComponentMain extends AbsComponent {
    private String mainInfoSelector = "input[name='%s']";
    public PersonalInfoComponentMain(WebDriver driver) {
        super(driver);
    }
    public PersonalInfoComponentMain insertMainInfo(){
        List<PersonalPageInfoData> personalInfoCelectorsList = Arrays.asList(PersonalPageInfoData.values());
        List<TestData> testDataList = Arrays.asList(TestData.values());
        for(int i=0; i<personalInfoCelectorsList.size(); i++){
            String selector = String.format(mainInfoSelector, personalInfoCelectorsList.get(i).getName());
            clearAndInput(By.cssSelector(selector), testDataList.get(i).getName());
        }
        return this;
    }
}

package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResidencyStatus {
    public AppiumDriver<MobileElement> driver;

    public ResidencyStatus(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement FifthPageHeaderText;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement FifthPagePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement FifthPageQueTitle;
    @AndroidFindBy(xpath = "//*[contains(@text, 'Permanent resident')]")
    public MobileElement validationResidency;
   @AndroidFindAll(@AndroidBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*"))
    public static List<MobileElement> ResidencyListXpath;

   @AndroidFindBy(xpath = "//*[@text='Citizen']")
    public MobileElement Citizen;
    public static List<String> getResidencyStatusTexts() {
        List<String> residencyTexts = new ArrayList<>();
        for (MobileElement Status : ResidencyListXpath) {
            residencyTexts.add(Status.getText());
        }
        return residencyTexts;
    }

    public String expectedResidencyQueText="What is your residency status?";

    public String expectedResidencyPrivacyText="This information will not be\n" +
            "shown to references";


}

package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class CurrentLocation {
    public AppiumDriver<MobileElement> driver;
    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public MobileElement conti;

    @AndroidFindBy(id = "com.commonfriend:id/txtTagLine")
    public MobileElement CurrentLocationHomeScreenText;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement gps;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    public MobileElement permissionDeny;
    @AndroidFindBy(xpath = "//*[@text='Approximate']")
    public MobileElement approxRadioImage;
    @AndroidFindBy(xpath = "//*[@text='Precise']")
    public MobileElement PreciseRadioImage;
    @AndroidFindBy(xpath = "//*[@text='Your location.']")
    public MobileElement thirdPageQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public MobileElement thirdPagePrivacyText;
    @AndroidFindBy(xpath = "//*[@text='3/6']")
    public MobileElement ThirdPageNo;

    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement FourthScreenQueTitle;
    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public MobileElement LocalityPlaceHolderText;

    public CurrentLocation(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public String expectedCurrentLocHomeScreenText="I would like\n" +
            "to access your\n" +
            "current location.";


}

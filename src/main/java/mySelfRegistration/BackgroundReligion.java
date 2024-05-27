package mySelfRegistration;

import base.TestListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BackgroundReligion {

    public AppiumDriver<MobileElement> driver;
    @AndroidFindBy(id = "com.commonfriend:id/txtTagLine")
    public MobileElement BackgroundHomePageTitleText;
    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public MobileElement buttonadd;
    @AndroidFindBy(xpath = "//*[@text='Background']")
    public MobileElement FirstPageHeaderTitle;

    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public MobileElement religionPagePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement religionPageQueTitle;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/txtLocationName\"]")
    public MobileElement dropDownPlaceHolderText;

    @AndroidFindBy(xpath = "//*[@resource-id='com.commonfriend:id/btnCancel']")
    public MobileElement downArrowButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hindu']")
    public MobileElement tickreligion;
  /*  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Muslim']")
    public MobileElement tickreligion;
*/




    public BackgroundReligion(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String expectedBackgroundHomeScreenText = "Now, let's dive into your background.";
    public String expectedBackgroundHomeScreenTimerText = "Should take about 30 seconds.";
    public String expectedReligionScreenText = "What religion do you follow?";
    public String expectedReligionPlaceHolderText = "Add religion";


    @AndroidFindBy(id = "com.commonfriend:id/txtLocation")
    private List<MobileElement> religionTextViews;

    public void printAllReligions() {
        for (MobileElement religion : religionTextViews) {
            System.out.println(religion.getText());
            TestListener.logToExtentReport("All religion are :"+religion.getText());
        }
    }

}

package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LivingLocation {

    public AppiumDriver<MobileElement> driver;

    public LivingLocation(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement FourthPageHeaderText;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement FourthPagePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement FourthPageQueTitle;
    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public MobileElement LivingLocationPlaceHolder;
    @AndroidFindBy(id = "com.commonfriend:id/edtSearch")
    public MobileElement Search;

    @AndroidFindBy(xpath = "//*[contains(@text,'Ahmedabad, Gujarat, India')]")
    public MobileElement SelectAhmedabad;
    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public MobileElement btncontinue;

    public String expectedlivingQueText="Where do you live?";
    public String expectedlivingPlaceHolderText="Select a location";
    public String expectedlivingPrivacyText="This information will not be\n" +
            "shown to references";



}

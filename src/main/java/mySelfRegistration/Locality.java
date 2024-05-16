package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.mac.Mac2Element;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Locality {
    public AppiumDriver<MobileElement> driver;

    public Locality(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement FifthPageHeaderText;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement FifthPagePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement FifthPageQueTitle;
    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public MobileElement LocalityPlaceHolder;
    @AndroidFindBy(id = "com.commonfriend:id/btnSkip")
    public MobileElement Skipbtn;
    @AndroidFindBy(id = "com.commonfriend:id/edtSearch")
    public MobileElement EditSearch;

    @AndroidFindBy(xpath = "//*[contains(@text,'Gota, Ahmedabad, Gujarat')]")
    public MobileElement SelectGota;
    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public MobileElement btncontinue;

    public String expectedlocalityQueText="What is your locality?";
    public String expectedlocalityPlaceHolderText="Select your locality";
    public String expectedlocalityPrivacyText="This information will not be\n" +
            "shown to references";





}

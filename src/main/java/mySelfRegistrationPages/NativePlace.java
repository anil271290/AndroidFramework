package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class NativePlace {
    public AppiumDriver<MobileElement> driver;

    public NativePlace(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement NativePlaceQue;

    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public MobileElement NativePlaceHolder;
    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement NativePageHeader;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement NativePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/edtSearch")
    public MobileElement EditSearch;
    @AndroidFindBy(xpath = "//*[contains(@text,'Gota, Ahmedabad, Gujarat')]")
    public MobileElement Gota;

    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public MobileElement ContinueBtn;


    public String expectedNativePlaceHolder="Select your native place";


}

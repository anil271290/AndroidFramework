package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.mac.Mac2Element;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BirthPlace {
    public AppiumDriver<Mac2Element> driver;

    public BirthPlace(AppiumDriver<Mac2Element> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement BirthPlaceQue;

    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement BirthPlacePrivacyText;

    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement BirthPlaceHeader;
    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public MobileElement BirthPlacePlaceHolder;
    @AndroidFindBy(id = "com.commonfriend:id/edtSearch")
    public MobileElement EditSearch;
    @AndroidFindBy(xpath = "//*[contains(@text,'Gota, Ahmedabad, Gujarat, India')]")
    public MobileElement Gota;

    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public MobileElement ContinueBtn;


}

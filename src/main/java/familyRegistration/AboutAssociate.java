package familyRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AboutAssociate {

    public AppiumDriver<MobileElement> driver;

    public AboutAssociate(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.commonfriend:id/btnLeft")
    public MobileElement BackArrow;
    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement FirstPageHeader;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement FirstPagePrivacyText;

    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement FirstQue;

    @AndroidFindBy(id = "com.commonfriend:id/edtFirstName")
    public MobileElement FirstNamePlaceHolder;
    @AndroidFindBy(id = "com.commonfriend:id/edtLastName")
    public MobileElement LastNamePlaceHolder;

      /*Second Screen*/
    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement SecondPageHeader;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement SecondPagePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement SecondQue;
    @AndroidFindBy(xpath = "//*[contains(@text, 'Female')]")
    public MobileElement femaleBtn;
    @AndroidFindBy(xpath = "//*[contains(@text, 'Male')]")
    public MobileElement maleBtn;


    /*Third Screen*/

    @AndroidFindBy(id = "com.commonfriend:id/txtTagLine")
    public MobileElement LocationScreenBreakerTitle;
    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public MobileElement ScreenBreakerContinueBtn;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public MobileElement permissionBtn;

    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement ThirdPageHeader;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement ThirdPagePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement ThirdQue;


    /*Fourth screen*/
    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement FourthPageHeader;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement FourthPagePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement FourthQue;

    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public MobileElement ProfessionPlaceHolder;
    @AndroidFindBy(xpath = "//*[contains(@text, 'Private company')]")
    public MobileElement SelectedProfession;

    /*Fifth Screen*/
    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement FifthPageHeader;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement FifthPagePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement FifthQue;
    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public MobileElement DesignationPlaceHolder;
    @AndroidFindBy(id = "com.commonfriend:id/edtSearch")
    public MobileElement EditDesignation;
    @AndroidFindBy(xpath = "//*[contains(@text, 'Software Developer')]")
    public MobileElement SelectSoftwareDeveloper;

    /*Sixth Screen */

    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement SixthPageHeader;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement SixthPagePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement SixthQue;
    @AndroidFindBy(id = "com.commonfriend:id/edtIndustry")
    public MobileElement IndustryPlaceHolder;
    @AndroidFindBy(xpath = "//*[contains(@text, 'Technology')]")
    public MobileElement SelectIndustry;


}

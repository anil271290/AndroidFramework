package mySelfRegistrationPages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.commonfriend:id/imgPlayButton")
    public MobileElement clickImoji;
    @AndroidFindBy(xpath = "//*[@text='Not for people looking for anything\n" +
            "short term.']")
    public MobileElement BanImgText;
    @AndroidFindBy(xpath = "//*[@text='Not for people looking for anything\n" +
            "short term.']/../*[1]")
    public MobileElement BanImg;

    @AndroidFindBy(xpath = "//*[@text='People looking to get married.']/../*[1]")
    public MobileElement RingImg;
    @AndroidFindBy(xpath = "//*[@text='People looking to get married.']")
    public MobileElement RingImgText;

    @AndroidFindBy(xpath = "//*[contains(@text,'Mumbai, Navi')]")
    public MobileElement LocationImgText;
   @AndroidFindBy(xpath = "//*[contains(@text,'Mumbai, Navi')]/../*[3]")
   public MobileElement LocationImg;

    @AndroidFindBy(xpath = "//*[@text='But, how does it work?']/../*[1]")
    public MobileElement ImojiImg;

    @AndroidFindBy(id = "com.commonfriend:id/btnCancel")
    public MobileElement crossBtn;

    @AndroidFindBy(xpath = "//*[@text='People looking to get married.']")
    public MobileElement ringTextXpath;

    @AndroidFindBy(xpath = "//*[contains(@text,'waitlist')]")
    public MobileElement SecondScreenTitleText;
    @AndroidFindBy(xpath = "//*[@text='Usual turnaround time is 72 hours.']/../*[1]")
    public MobileElement HourGlassImg;
    @AndroidFindBy(xpath = "//*[@text='Usual turnaround time is 72 hours.']")
    public MobileElement HourGlassImgText;

    @AndroidFindBy(xpath = "//*[contains(@text,'To maintain a balanced gender')]/../*[1]")
    public MobileElement ScaleImg;

    @AndroidFindBy(xpath = "//*[contains(@text,'To maintain a balanced gender')]")
    public MobileElement ScaleImgText;

    @AndroidFindBy(xpath = "//*[contains(@text,'To maintain a balanced gender')]/../*[3]")
    public MobileElement WhistleImg;

    @AndroidFindBy(xpath = "//*[contains(@text,'To maintain a balanced gender')]/../*[4]")
    public MobileElement WhistleImgText;
    @AndroidFindBy(xpath = "//*[contains(@text,'About')]")
    public MobileElement ThirdPageTitleText;

    @AndroidFindBy(xpath = "//*[contains(@text,'mandatory')]")
    public MobileElement ManImgText;
    @AndroidFindBy(xpath = "//*[contains(@text,'mandatory')]/../*[1]")
    public MobileElement ManImg;
    @AndroidFindBy(xpath = "//*[contains(@text,'information is optional')]/../*[1]")
    public MobileElement DolorImg;
    @AndroidFindBy(xpath = "//*[contains(@text,'information is optional')]")
    public MobileElement DolorImgText;
    @AndroidFindBy(xpath = "//*[contains(@text,'information is optional')]/../*[3]")
    public MobileElement LockImg;

    @AndroidFindBy(xpath = "//*[contains(@text,'confidential')]")
    public MobileElement LockImgText;
    @AndroidFindBy(xpath = "//*[contains(@text,'Partner')]")
    public MobileElement FourthScreenTitleText;

    @AndroidFindBy(xpath = "//*[contains(@text,'We are new')]/../*[1]")
    public MobileElement NamasteImg;
    @AndroidFindBy(xpath = "//*[contains(@text,'We are new')]")
    public MobileElement NamasteImgText;
    @AndroidFindBy(xpath = "//*[contains(@text,'connections are made')]/../*[1]")
    public MobileElement RaiseHandImg;
    @AndroidFindBy(xpath = "//*[contains(@text,'connections are made')]")
    public MobileElement RaiseHandImgText;
    @AndroidFindBy(xpath = "//*[contains(@text,'connections are made')]/../*[3]")
    public MobileElement HeartImg;
    @AndroidFindBy(xpath = "//*[contains(@text,'Share the love')]")
    public MobileElement HeartImgText;

    @AndroidFindBy(xpath = "//*[@text='Who is it for?']")
    public MobileElement startPageScreenTitle;
    @AndroidFindBy(xpath = "//*[@text='If required, I shall use this number\n" +
            "to get in touch.']")
    public MobileElement startPageMiniTitle;
    @AndroidFindBy(xpath = "//*[@text='I will send you a text with a verification code.']")
    public MobileElement verificationText;
    @AndroidFindBy(xpath = "//*[@text=\"By login in you agree to my 'Terms' and 'Privacy Policy'\"]")
    public MobileElement privacyPolicyText;

    @AndroidFindBy(id = "btnNext")
    public MobileElement firstButton;
    @AndroidFindBy(id = "com.commonfriend:id/txtMsg")
    public MobileElement profileSelectionText;
    @AndroidFindBy(xpath = "//*[contains(@text,'get married')]")
    public MobileElement HelloScreenSubtitle;
    @AndroidFindBy(xpath = "//*[@text='Me']")
    public MobileElement MyselfButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Someone')]")
    public MobileElement SomeOneButton;
    @AndroidFindBy(xpath = "//*[@text='%s' and @resource-id='com.commonfriend:id/txtCulture']/../android.widget.ImageView")
    public MobileElement selectCity;

    public StartPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickButton() {
       firstButton.click();
    }

    public String expectedHelloScreenSubTitle="Who is planning to get married?";
}

package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class Photos {

    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "btnAdd")
    public MobileElement continuebttn;
    @AndroidFindBy(id = "com.commonfriend:id/txtTagLine")
    public MobileElement PhotoHomeScreenTitle;
    @AndroidFindBy(id = "com.commonfriend:id/txtBottomTagLine")
    public MobileElement TimeInfoText;
    @AndroidFindBy(id = "btnAction")
    public MobileElement okbutn;
    @AndroidFindBy(id = "com.commonfriend:id/txtMsgDesc")
    public MobileElement DialogBoxMsg;
    @AndroidFindBy(xpath = "//*[@text='Just FYI']")
    public MobileElement DialogBoxHeader;


    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement allow;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Screenshots\")")
    public MobileElement MotoselectPhotoFolder;
    @AndroidFindBy(xpath = "//*[contains(@text,'Download')]")
    public MobileElement DownloadSamsung;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*[2]")
    public MobileElement firstphoto;

    @AndroidFindBy(xpath = "//android.widget.ImageView[4]")
    public MobileElement SamsungPhoto1;
    @AndroidFindBy(xpath = "//android.widget.ImageView[5]")
    public MobileElement SamsungPhoto2;
    @AndroidFindBy(xpath = "//android.widget.ImageView[7]")
    public MobileElement SamsungPhoto3;
    @AndroidFindBy(xpath = "//android.widget.ImageView[8]")
    public MobileElement SamsungPhoto4;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.commonfriend:id/imgProfile'])[1]")
    public MobileElement Plus1;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.commonfriend:id/imgProfile'])[2]")
    public MobileElement Plus2;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.commonfriend:id/imgProfile'])[3]")
    public MobileElement Plus3;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.commonfriend:id/imgProfile'])[4]")
    public MobileElement Plus4;
    public String start= "(//*[@resource-id='com.commonfriend:id/imgProfile'])[%s]";
    public String end= "(//*[@resource-id='com.commonfriend:id/imgProfile'])[%s]";

    public Photos(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void continuephoto() throws InterruptedException {
        continuebttn.click();
        Thread.sleep(3000);

    }

    public void tapphoto() {
       Plus1.click();
       allow.click();

    }
}

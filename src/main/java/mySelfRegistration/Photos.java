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

    @AndroidFindBy(id = "com.commonfriend:id/imgDisplayPicture")
    public MobileElement plusphoto;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public MobileElement allow;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Screenshots\")")
    public MobileElement selectPhotoFolder;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Photo taken on 07-Dec-2023 10:54:05 am\")")
    public MobileElement selectPhoto;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*[2]")
    public MobileElement firstphoto;

    public Photos(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void continuephoto() throws InterruptedException {
        continuebttn.click();
        Thread.sleep(3000);

    }

    public void tapphoto() {
       plusphoto.click();
       allow.click();

    }
}

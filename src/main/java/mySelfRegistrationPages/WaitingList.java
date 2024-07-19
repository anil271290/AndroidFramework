package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WaitingList {
    private static final Logger logger = LogManager.getLogger(WaitingList.class);
    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//(android.widget.EditText)[1]")
    public MobileElement entrycode;
    @AndroidFindBy(xpath = "//*[@text='Waitlist!']")
    public MobileElement WaitListText;

    @AndroidFindBy(id = "btnSetCode")
    public MobileElement arrow;

    @AndroidFindBy(id = "com.commonfriend:id/txtAccessCode")
    public MobileElement txtdisplay;
    @AndroidFindBy(id = "btnRemoveAccessCode")
    public MobileElement removecode;

    @AndroidFindBy(id = "imgCustomProfile")
    public MobileElement clickprofile;
    @AndroidFindBy(id = "com.commonfriend:id/imgAadharError")
    public MobileElement locksymbol;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public MobileElement permission;

    @AndroidFindBy(id = "com.commonfriend:id/edtFeedback")
    public MobileElement editfeedback;
    @AndroidFindBy(id = "com.commonfriend:id/btnDone")
    public MobileElement submit;

    @AndroidFindBy(id = "com.commonfriend:id/edtNumber")
    public MobileElement EditNumber;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Invitations']")
    public MobileElement InvitationText;

    @AndroidFindBy(id = "com.commonfriend:id/txtWordCount")
    public MobileElement textCount;


    @AndroidFindBy(xpath = "//*[@text='Refer me']/..//following-sibling::android.widget.ImageView")
    public MobileElement SendInvitation;

    @AndroidFindBy(id = "com.commonfriend:id/btnAddMember")
    public MobileElement AddMemberBtn;

    @AndroidFindBy(id = "com.commonfriend:id/txtMsg")
    public MobileElement feedbackHeader;

    @AndroidFindBy(xpath = "//*[@text='Waitlist!']")
    public MobileElement waitListText;

    @AndroidFindBy(id = "com.commonfriend:id/btnAccount")
    public MobileElement recommendationBtn;
    @AndroidFindBy(xpath = "//*[@text='Recommendations']/../*[2]")
    public MobileElement recommendationField;


    public WaitingList(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clkpermission() {
        permission.click();
    }


    public void getdisplaytxt() {
        System.out.println(txtdisplay.getText());
    }

    public void verifydisplaytxt() {
        if (txtdisplay.getText() == null) {
            entrycode.sendKeys("595959");
        } else {
            logger.info("Already applied");
        }

    }

    public void removeaccesscode() {
        removecode.click();
    }

    public void profileclickbutton() {
        clickprofile.click();
    }

    public void checkProfileActivation() {
        Assert.assertFalse(locksymbol.isDisplayed(),"Profile Activated");
    }

    public void feedback() {
        editfeedback.sendKeys("hello hi how r u?");
        submit.click();
    }

    public void invitationField() {
        EditNumber.sendKeys("7265883883");
        SendInvitation.click();
    }

    public void permission() {
        permission.click();
    }

    @AndroidFindBy(xpath = "//*[@text='Family']/../*[3]")
    public MobileElement RequestSize;

}

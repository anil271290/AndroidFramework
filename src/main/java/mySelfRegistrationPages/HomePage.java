package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public AppiumDriver<MobileElement> driver;

    public HomePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/imgAccount")
    public MobileElement recommendationbtn;
    @AndroidFindBy(id = "com.commonfriend:id/imgHome")
    public MobileElement homebtn;
    @AndroidFindBy(id = "com.commonfriend:id/btnChat")
    public MobileElement chatbtn;
    @AndroidFindBy(id = "com.commonfriend:id/imgSettings")
    public MobileElement settingbtn;
    @AndroidFindBy(id = "com.commonfriend:id/txtChannelName")
    public MobileElement chatperson;
    @AndroidFindBy(id = "com.commonfriend:id/messageEditText")
    public MobileElement editchat;
    @AndroidFindBy(id = "com.commonfriend:id/sendMessageButton")
    public MobileElement senttext;
    @AndroidFindBy(id = "com.commonfriend:id/imgBack")
    public MobileElement backfromchat;
    @AndroidFindBy(id = "com.commonfriend:id/txtUserInits")
    public MobileElement clickimage;
    @AndroidFindBy(id = "com.commonfriend:id/btnCross")
    public MobileElement closefrndprofile;

    public void clickrecommendaation() {
        recommendationbtn.click();
    }

    public void clickhome() {
        homebtn.click();
    }

    public void clickchat() {
        chatbtn.click();
    }

    public void clicksetting() {
        settingbtn.click();
    }

    public void clickchatperson() {
        chatperson.click();
    }

    public void startChat() {
        editchat.sendKeys("hiii");
        senttext.click();
    }

    public void backFromChatting() {
        backfromchat.click();
    }

    public void clickonProfileImage() {
        clickimage.click();
    }

    public void closeFriendProfile() {
        closefrndprofile.click();
    }


}

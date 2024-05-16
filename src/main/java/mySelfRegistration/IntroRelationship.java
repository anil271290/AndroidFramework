package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IntroRelationship {
    public AppiumDriver<MobileElement> driver;

    /*@AndroidFindBy(xpath = "//android.widget.TextView[@text='Awaiting divorce']")//Annulled,Awaiting divorce,Widow,Divorced
    public MobileElement rstatus;*/
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Never married']")
    public MobileElement rstatus;

    @AndroidFindBy(xpath = "//*[@text='No']")
    public MobileElement Nokids;


    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement relationPagePrivacyText;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement relationPageQueTitle;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement kidsQueTitle;
    @AndroidFindBy(xpath = "//*[contains(@text, 'have kids')]")
    public MobileElement validationKids;

    @AndroidFindAll(@AndroidBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*"))
    public static List<MobileElement> AllRelation;


    public void getRelationText(){
        for (MobileElement Relations : AllRelation) {
            System.out.println(Relations.getText());
        }
    }


    public IntroRelationship(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void relationst() throws InterruptedException {
        rstatus.click();
        Thread.sleep(500);

    }

    public String expectedRelationQueText="What's your relationship status?";
    public String expectedRelationPrivacyText="Visible to your recommendations only";
    public String expectedKidsQueText="Do you have kids?";
}

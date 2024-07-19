package familyRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AssociateScreenBreaker {
    public AppiumDriver<MobileElement> driver;

    public AssociateScreenBreaker(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/txtTagLine")
    public MobileElement AssociateHomeText;
    @AndroidFindBy(id = "com.commonfriend:id/txtBottomTagLine")
    public MobileElement HomescreenTimetext;
    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public MobileElement continuebtn;

}

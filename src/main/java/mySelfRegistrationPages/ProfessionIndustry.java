package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class ProfessionIndustry {

    public AppiumDriver<MobileElement> driver;
    @AndroidFindBy(xpath = "//*[@text='2/2']")
    public MobileElement SecondPageNo;
    @AndroidFindBy(xpath = "//*[@text='Which industry ?']")
    public MobileElement profession2ndScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/llPrivacy\"]/../*[3]/*[1]/*")
    public MobileElement DropDown2ndScreenPlaceHolderText;
    @AndroidFindBy(xpath = "//*[@text='Profession']")
    public MobileElement ProfessionHeaderTitle;


    @AndroidFindBy(id = "com.commonfriend:id/rvLocation")
    public MobileElement PaginationXpath;


    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*")
    public MobileElement AllIndustriesXpath;

    @AndroidFindBy(xpath = "//*[@text='Technology']")
    public MobileElement addindustry;

    public ProfessionIndustry(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }




}

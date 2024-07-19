package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class ProfessionHome {

    public AppiumDriver<MobileElement> driver;
    @AndroidFindBy(id = "btnAdd")
    public MobileElement continueprofession;


    @AndroidFindBy(xpath = "//*[@text='Should take about 30 seconds.']")
    public MobileElement TimeInfoText;
    @AndroidFindBy(xpath = "//*[@text='1/2']")
    public MobileElement FirstPageNo;

    @AndroidFindBy(xpath = "//*[@text='Add job title']")
    public MobileElement addjobtitle;

    @AndroidFindBy(id = "edtSearch")
    public MobileElement editsearch;

    @AndroidFindBy(id = "com.commonfriend:id/rvLocation")
    public MobileElement PaginationXpath;



    @AndroidFindBy(xpath = "//*[@text='Software Developer']")
    public MobileElement selectjob;

    //@Text='IT & Software Engineering' or 'Software Developer' //for scroll down to visible text
    @AndroidFindBy(xpath = "//*[@text='Tell me about your profession.']")
    public MobileElement professionHomeScreenTitle;
    @AndroidFindBy(xpath = "//*[@text=\"What's your job title?\"]")
    public MobileElement profession1stScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Add job title']")
    public MobileElement DropDown1stScreenPlaceHolderText;
    @AndroidFindBy(xpath = "//*[@text='Profession']")
    public MobileElement ProfessionHeaderTitle;


    public ProfessionHome(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void continueprofessionbtn() {
        continueprofession.click();
    }

    public void jobentry() {
        addjobtitle.click();
    }

    public void editjob() {
        editsearch.sendKeys("Software Developer");


    }




}

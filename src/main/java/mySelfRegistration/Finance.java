package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class Finance {
    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "btnAdd")
    public MobileElement enterfinance;
    @AndroidFindBy(xpath = "//*[@text='Money matters! Lets discuss it.']")
    public MobileElement FinanceHomeScreenTitle;
    @AndroidFindBy(xpath = "//*[@text='Should take about 30 seconds.']")
    public MobileElement TimeInfoText;
    @AndroidFindBy(xpath = "//*[@text='Finances']")
    public MobileElement FinanceScreenHeaderTitle;
    @AndroidFindBy(xpath = "//*[@text=\"What's your line of work?\"]")
    public MobileElement FinanceFirstScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='1/3']")
    public MobileElement FirstPageNo;
    @AndroidFindBy(id = "txtLocationName")
    public MobileElement work;
    @AndroidFindBy(xpath = "//*[@text='Select line of work']")
    public MobileElement DropDownPlaceHolderText;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*")
    public MobileElement AllWorksXpath;
    @AndroidFindBy(xpath = "//*[@text='Student']")
    public MobileElement verifyText;
    @AndroidFindBy(xpath = "//*[@text='2/3']")
    public MobileElement SecondPageNo;
    @AndroidFindBy(xpath = "//*[@text='3/3']")
    public MobileElement ThirdPageNo;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public MobileElement Finance2ndPrivacyText;
    @AndroidFindBy(xpath = "//*[@text='Visible to yourself only']")
    public MobileElement Finance3rdPrivacyText;
    @AndroidFindBy(xpath = "//*[@text='How much money do you make in a year?']")
    public MobileElement finance2ndscreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text=\"What is your family's net worth?\"]")
    public MobileElement finance3rdscreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='No Income']")
    public MobileElement SecondScreenDefaultIncomeTitle;
    @AndroidFindBy(xpath = "//*[@text='Below ₹1 crores']")
    public MobileElement ThirdScreenDefaultIncomeTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Private company']")//Private company,Family business,Own business,Own firm,Civil services,Do not work
    public MobileElement selectwork;

    @AndroidFindBy(id = "btnIncrease")
    public MobileElement PlusButton;
    @AndroidFindBy(id = "btnDecrease")
    public MobileElement MinusButton;

    @AndroidFindBy(id = "btnAction")
    public MobileElement okaybutton;

    @AndroidFindBy(xpath = "//*[@text='Proceed']")
    public MobileElement proceedBtn;
    @AndroidFindBy(xpath = "//*[@text='Prefer not to say']")
    public MobileElement preferNotToSayBtn;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Value, 0\"]")
    public MobileElement dotbutton;
    @AndroidFindBy(xpath = "//*[@text='About Net worth']")
    public MobileElement DialogBoxHeaderText;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/*[2]/*[2]")
    public MobileElement DialogBoxTexts;


    public Finance(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void financehome() {
        enterfinance.click();
    }

    public void enterwork() {
        work.click();
    }

    public void workselection() {
        selectwork.click();
    }



    public void okbutton() {
        okaybutton.click();
    }

    /**
     * @param key between 1 to 12
     */
    public void dotBtnPlusMinus(String key){
        dotbutton.sendKeys(key);
    }
}

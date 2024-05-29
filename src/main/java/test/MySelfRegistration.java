package test;

import base.ExtentReport;
import base.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import base.AppiumBase;
import org.testng.asserts.SoftAssert;
import mySelfRegistration.*;
import util.OTPService;
import util.Utils;

import java.net.MalformedURLException;
import java.util.Random;
import java.util.Set;


@Listeners(base.TestListener.class)


public class MySelfRegistration extends AppiumBase {
    protected static final Logger logger = LogManager.getLogger(MySelfRegistration.class);


    @BeforeTest
    public void launchApp() throws MalformedURLException {
        setup();
        // setupEmulator();
    }

    @Test(priority = 1, description = "StartPage")
    public void StartPage() throws InterruptedException {
        StartPage sp = new StartPage(getAppiumDriver());
        Loginpage log = new Loginpage(getAppiumDriver());

        OTPService ot = new OTPService(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Who is it for?", sp.startPageScreenTitle.getText());
        TestListener.logToExtentReport("StartPage Screen Title is :" + sp.startPageScreenTitle.getText());

        ut.waitForElementWithFluentWait(sp.firstButton);
        Thread.sleep(2000);
        sp.clickButton();
        softAssert.assertEquals(sp.startPageMiniTitle.getText(), getStrings().get("Get_In_Touch"));
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Text below title is : " + sp.startPageMiniTitle.getText());
        softAssert.assertEquals(sp.verificationText.getText(), getStrings().get("Verification_Code"));
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("VerificationCode Text below Enter Mobile Field is " + sp.verificationText.getText());

        /*Random Number Generator*/

        Random random = new Random();
        int randomSuffix = 10000000 + random.nextInt(90000000); // Generate a random 8-digit suffix
        String mobileNumber = "62" + String.valueOf(randomSuffix);
        log.entermono(mobileNumber);
        TestListener.logToExtentReport("RandomMobile Number is : +91-" + mobileNumber);
        takeScreenshot("mobileNo");
        Thread.sleep(2000);
        log.continuebutton();
        Thread.sleep(4000);
        try {
            softAssert.assertEquals(sp.privacyPolicyText.getText(), getStrings().get("Terms"));
            TestListener.handleSoftAssertions(softAssert);
            TestListener.logToExtentReport("Assertion Passed");
        } catch (AssertionError e) {
            ExtentReport.getTest().fail("Assertion failed: " + e.getMessage());
        }

        TestListener.logToExtentReport("PrivacyPolicy Text is " + sp.privacyPolicyText.getText());


        // Get OTP from server
        String countryCode = "+91";
        String phonNumber = mobileNumber;
        String otp = OTPService.getOTPFromServer(countryCode, phonNumber);
        TestListener.logToExtentReport("OTP received from server is: " + otp);

        // Enter OTP
        ot.enterOTP(otp);


        softAssert.assertAll();


    }

    @Test(priority = 2, description = "IntroductionName")
    public void introduction() {
        StartPage sp = new StartPage(getAppiumDriver());
        IntroName name = new IntroName(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        WelcomePage wp = new WelcomePage(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        sp.MyselfButton.click();
        // wp.permission1();
        softAssert.assertEquals(name.IntroHomeTitleText.getText(), name.expectedHomeTitleText);
        TestListener.handleSoftAssertions((softAssert));
        TestListener.logToExtentReport("IntroHomePage Title : " + name.expectedHomeTitleText);
        name.continue1.click();
        softAssert.assertEquals(name.firstPageQueTitle.getText(), name.expectedFirstPageQueTitle);
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Introduction 1st page question : " + name.firstPageQueTitle.getText());
        name.enterfirstname("Raghav");
        name.enterlastname("Pandey");
        softAssert.assertEquals(name.privacyText.getText(), getStrings().get("name"));
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Name");
        continueButton();
        softAssert.assertAll();

    }

    @Test(priority = 3, description = "IntroductionGender")
    public void gender() {
        IntroGender gender = new IntroGender(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(gender.secondPageQueTitle.getText(), getStrings().get("IntroGenderQue"));
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("SecondPage Question Title is : " + gender.secondPageQueTitle.getText());
        TestListener.logToExtentReport("PrivacyText of 2nd Page is : " + gender.privacyText.getText());
        takeScreenshot("Gender");
        softAssert.assertTrue(gender.backArrow.isDisplayed(), "BackArrow not displayed");
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("2nd Page Header Title is : " + gender.headerTitle.getText());
        gender.selectgender(gender.Female);
        // continueButton();
        softAssert.assertAll();
    }

    @Test(priority = 4, description = "Location")
    public void locationAccess() throws InterruptedException {
        CurrentLocation cl = new CurrentLocation(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(cl.CurrentLocationHomeScreenText.getText(), cl.expectedCurrentLocHomeScreenText);
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Current_Location Section_Breaker");
        softAssert.assertTrue(cl.conti.isDisplayed(), "Element not found");
        TestListener.handleSoftAssertions(softAssert);
        cl.conti.click();
        takeScreenshot("permission");
        Thread.sleep(2000);
        cl.gps.click();
        takeScreenshot("Your Location");
        continueButton();
        softAssert.assertAll();

    }

    @Test(priority = 5, description = "Where Do You Live?")
    public void livingLocation() {
        LivingLocation ll = new LivingLocation(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(ll.FourthPageQueTitle.getText(), ll.expectedlivingQueText);
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Living Location screen");
        softAssert.assertEquals(ll.LivingLocationPlaceHolder.getText(), ll.expectedlivingPlaceHolderText);
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Privacy Text : " + ll.FourthPagePrivacyText.getText());
        ll.LivingLocationPlaceHolder.click();
        takeScreenshot("Search Location");
        ll.Search.sendKeys("Ahmedabad");
        ll.SelectAhmedabad.click();
        takeScreenshot("Living Location Selected");
        ll.btncontinue.click();
        softAssert.assertAll();


    }


    @Test(priority = 6, description = "Residency Status")
    public void residenceStatus() {
        ResidencyStatus rs = new ResidencyStatus(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

        if (isElementDisplayed(rs.validationResidency)) {
            softAssert.assertEquals(rs.FifthPageQueTitle.getText(), rs.expectedResidencyQueText);
            TestListener.handleSoftAssertions(softAssert);
            takeScreenshot("Residency Status Screen");
            rs.Citizen.click();
        } else {
            logger.info("Residency Status Page is not available for selected Living Location");
            throw new SkipException("Skipping the test as Residency Status Page is not available.");

        }
        softAssert.assertAll();
    }

    @Test(priority = 7, description = "Residency Status")
    private void locality() {
        Locality lt = new Locality(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

       /* lt.Skipbtn.click();
        takeScreenshot("skipp locality");
        getAppiumDriver().navigate().back();*/
        softAssert.assertEquals(lt.SixthPageQueTitle.getText(), lt.expectedlocalityQueText);
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Locality Screen");
        softAssert.assertEquals(lt.LocalityPlaceHolder.getText(), lt.expectedlocalityPlaceHolderText);
        TestListener.handleSoftAssertions(softAssert);
        lt.LocalityPlaceHolder.click();
        takeScreenshot("Search Locality");
        lt.printSuggestedLocalities();
        lt.EditSearch.sendKeys("Gota");
        lt.SelectGota.click();
        lt.btncontinue.click();
        softAssert.assertAll();


    }

    @Test(priority = 8, description = "Locations to settle")
    public void locationsToSettle() {
        IntroLocations il = new IntroLocations(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals(il.SettleLocQueTitle.getText(), getStrings().get("IntroSettleQue"));
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Fourth page Question Title is : " + il.SettleLocQueTitle.getText());
        TestListener.logToExtentReport("DropDown PlaceHolder Text is: " + il.dropDownPlaceHolderText.getText());
        softAssert.assertEquals(il.dropDownPlaceHolderText.getText(), il.expectedSettleLocPlaceHolderText);
        TestListener.handleSoftAssertions(softAssert);
        il.dropDownPlaceHolderText.click();
        TestListener.logToExtentReport("Below AddLocation Text is : " + il.belowAddLocationsText.getText());
        takeScreenshot("MultiLocations");
        // il.selectlocat();
        il.clickFirstSixLocations();
       /* Set<String> allLocations = il.getAllLocations();
        for (String location : allLocations) {
            System.out.println(location);
        }*/
        takeScreenshot("Locations selected");
        il.conbutton.click();
        softAssert.assertAll();

    }

    @Test(priority = 9, description = "RelationShip")
    public void relationShip() throws InterruptedException {
        IntroRelationship ir = new IntroRelationship(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(ir.relationPageQueTitle.getText(), getStrings().get("IntroRelationQue"));
        TestListener.handleSoftAssertions(softAssert);
        ir.getRelationText();
        TestListener.logToExtentReport("Question Title is : " + ir.relationPageQueTitle.getText());
        TestListener.logToExtentReport("Privacy Text is : " + ir.relationPagePrivacyText.getText());
        takeScreenshot("Relationship");
        ir.relationst();

        if (isElementDisplayed(ir.validationKids)) {
            takeScreenshot("Kids Page");
            softAssert.assertEquals(ir.kidsQueTitle.getText(), ir.expectedKidsQueText);
            TestListener.handleSoftAssertions(softAssert);
            ir.Nokids.click();

        } else {
            TestListener.logToExtentReport("Kids Page is not available for selected criteria");
        }

        softAssert.assertAll();

    }

    @Test(priority = 10, description = "BackGround Religion")
    public void selectReligion() {
        BackgroundReligion religion = new BackgroundReligion(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals(religion.BackgroundHomePageTitleText.getText(), getStrings().get("Background"));
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("BackgroundSectionBreaker Title : " + religion.BackgroundHomePageTitleText.getText());
        religion.buttonadd.click();
        TestListener.logToExtentReport("HeaderTitle is : " + religion.FirstPageHeaderTitle.getText());
        softAssert.assertEquals(religion.religionPageQueTitle.getText(), getStrings().get("ReligionQue"));
        softAssert.assertEquals(religion.dropDownPlaceHolderText.getText(), religion.expectedReligionPlaceHolderText);
        TestListener.handleSoftAssertions(softAssert);
        religion.dropDownPlaceHolderText.click();
        religion.printAllReligions();
        softAssert.assertTrue(religion.downArrowButton.isDisplayed(), "DownArrow Button Not Displayed");
        TestListener.handleSoftAssertions(softAssert);
        religion.tickreligion.click();
        takeScreenshot("religion");
        TestListener.logToExtentReport("Religion selected");
        softAssert.assertAll();
    }

    @Test(priority = 11, description = "BackGround Cultures")
    public void backCultures() {
        BackgroundCulture bc = new BackgroundCulture(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        TestListener.logToExtentReport("2nd Page Header Title is : " + bc.CulturePageHeaderTitle.getText());
        TestListener.logToExtentReport("Privacy Text is : " + bc.CulturePagePrivacyText.getText());
        softAssert.assertEquals(bc.CulturePageQueTitle.getText(), getStrings().get("CultureQue"));
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Question Title is : " + bc.CulturePageQueTitle.getText());
        softAssert.assertEquals(bc.dropDownPlaceHolderText.getText(), bc.expectedCulturePlaceHolderText);
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("DropDown PlaceHolder Text is : " + bc.dropDownPlaceHolderText.getText());
        bc.dropDownPlaceHolderText.click();
        //  bc.tickculture();
        bc.selectFirstFiveCultures();
       // bc.printAllCultures();
        takeScreenshot("cultures");
        bc.cltrcontinu();
        softAssert.assertAll();
    }

    @Test(priority = 12, description = "Caste")
    public void caste() {
        Caste cs = new Caste(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();
        Gotra gt = new Gotra(getAppiumDriver());


        if (isElementDisplayed(cs.validationCaste)) {
            cs.SkipBtn.click();
            takeScreenshot("");
            getAppiumDriver().navigate().back();
            softAssert.assertEquals(cs.CastePageQue.getText(), cs.expectedCasteQueTitle);
            TestListener.handleSoftAssertions(softAssert);
            softAssert.assertEquals(cs.CastePlaceHolder.getText(), cs.expectedDropDownPlaceHolder);
            TestListener.handleSoftAssertions(softAssert);
            cs.CastePlaceHolder.click();
            takeScreenshot("Select caste");
            cs.FirstCaste.click();



        } else {
            TestListener.logToExtentReport("Caste Page is not available for selected Religion");
        }
        softAssert.assertAll();
    }

    @Test(priority = 13, description = "Gotra")
    public void gotraPage() {
        Gotra gt = new Gotra(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

        if (isElementDisplayed(gt.validationgotra)) {
            gt.SkipBtn.click();
            takeScreenshot("Skip Gotra");
            getAppiumDriver().navigate().back();
            softAssert.assertEquals(gt.GotraPageQue.getText(), gt.expectedGotraQueTitle);
            TestListener.handleSoftAssertions(softAssert);
            softAssert.assertEquals(gt.GotraPlaceHolder.getText(), gt.expectedDropDownPlaceHolder);
            TestListener.handleSoftAssertions(softAssert);
            gt.GotraPlaceHolder.sendKeys("Bhargava");
            continueButton();


        } else {
            System.out.println("Gotra page is not available for selected Religion");
            TestListener.logToExtentReport("Gotra page is not available for selected Religion");
        }
        softAssert.assertAll();
    }

    @Test(priority = 14, description = "Native Place")
    public void nativePlace() {
        NativePlace nt = new NativePlace(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(nt.NativePlaceQue.getText(), getStrings().get("NativeQue"));
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Native Placeholder text is : " + nt.NativePlaceHolder.getText());
        nt.NativePlaceHolder.click();
        nt.EditSearch.sendKeys("Gota");
        nt.Gota.click();
        nt.ContinueBtn.click();

    }

    @Test(priority = 15, description = "BackGround Birthday")
    public void birthDay() {
        BackgroundBday bday = new BackgroundBday(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(bday.bdayQueTitle);
        TestListener.logToExtentReport("Birth Page Question Title is : " + bday.bdayQueTitle.getText());
        softAssert.assertEquals(bday.bdayQueTitle.getText(), getStrings().get("BirthDayQue"));
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Header Title is : " + bday.ThirdPageHeaderTitle.getText());
        TestListener.logToExtentReport("Privacy Text is : " + bday.thirdPagePrivacyText.getText());
        takeScreenshot("Scroll Bday");

        Utils.tapElementMultipleTimes(bday.TapYearXpath, 3);
        takeScreenshot("Birthday selected");
        ut.waitForElementToBeVisible(getAppiumDriver().findElement(By.id("com.commonfriend:id/btnContinue")).isEnabled());
        continueButton();
        softAssert.assertAll();
    }

    @Test(priority = 16, description = "BirthPlace")
    public void birthPlace() {
        BirthPlace bp = new BirthPlace(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

        if (isElementDisplayed(bp.ValidationBirthPlace)) {
            softAssert.assertEquals(bp.BirthPlaceQue.getText(), getStrings().get("BirthPlaceQue"));
            TestListener.handleSoftAssertions(softAssert);
            softAssert.assertEquals(bp.BirthPlacePlaceHolder.getText(), bp.expectedBirthPlace_placeHolder);
            TestListener.handleSoftAssertions(softAssert);
            takeScreenshot("BirthPlace");
            bp.BirthPlacePlaceHolder.click();
            bp.EditSearch.sendKeys("Himatnagar");
            bp.Himatnagar.click();
            bp.ContinueBtn.click();

        } else {
            TestListener.logToExtentReport("BirthPlace is not available for selected religion");
        }
        softAssert.assertAll();
    }

    @Test(priority = 17, description = "BirthTime")
    public void birthTime() {
        BackgroundBdayTime bt = new BackgroundBdayTime(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();
        if (isElementDisplayed(bt.ValidationBirthTime)) {
            softAssert.assertEquals(bt.BirthTimeQue.getText(), getStrings().get("BirthTimeQue"));
            TestListener.handleSoftAssertions(softAssert);
            takeScreenshot("BirthTime");
            Utils.tapElementMultipleTimes(bt.HoursXpath, 1);
            continueButton();
        } else {
          TestListener.logToExtentReport("Birth time page is not available for selected Religion");
        }
    }

    @Test(priority = 18, description = "BackGround Height")
    public void height() {
        Utils ut = new Utils(getAppiumDriver());
        BackgroundHeight ht = new BackgroundHeight(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(ht.HeightScreenQueTitle);
        softAssert.assertEquals(ht.HeightScreenQueTitle.getText(),ht.expectedHeightQue);
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Height Screen Question Title is : " + ht.HeightScreenQueTitle.getText());
        TestListener.logToExtentReport("Privacy text is : " + ht.heightPrivacyText.getText());
        softAssert.assertTrue(ht.HeightContainerText.isDisplayed(), "Text not displayed");
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Scroll Height");
        Utils.tapElementMultipleTimes(ht.InchXpath, 8);
        takeScreenshot("Height selected");
        TestListener.logToExtentReport("Hieght scrolled and selected");
        ut.waitForElementToBeVisible(getAppiumDriver().findElement(By.id("com.commonfriend:id/btnContinue")).isEnabled());
        continueButton();
        softAssert.assertAll();
    }

    @Test(priority = 19, description = "BackGround Hendicap")
    public void hendicap() {
        BackGroundAbled abled = new BackGroundAbled(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(abled.HandicapScreenQueTitle);
        TestListener.logToExtentReport("Question Title is :" + abled.HandicapScreenQueTitle.getText());
        TestListener.logToExtentReport("Privacy text is : " + abled.HandicapPrivacyText.getText());
        takeScreenshot("Handicap");
        abled.ability(abled.No);
        //continueButton();
        softAssert.assertAll();
    }

    @Test(priority = 20, description = "BackGround Eating Habits")
    public void eatingHabit() {
        BackgroundEatingHabit habit = new BackgroundEatingHabit(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(habit.EatScreenQueTitle);
        TestListener.logToExtentReport("Question Title is : " + habit.EatScreenQueTitle.getText());
        TestListener.logToExtentReport("Pravacy Text is: " + habit.EatingPrivacyText.getText());
        takeScreenshot("EatingHabits");
        habit.getEatHabitTexts();
        habit.eathabit();
        softAssert.assertAll();

    }

    @Test(priority = 21, description = "Finance")
    public void money() throws InterruptedException {
        Finance fc = new Finance(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(fc.FinanceHomeScreenTitle);
        softAssert.assertEquals( fc.FinanceHomeScreenTitle.getText(), getStrings().get("Finances"));
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Finance HomeScreen Title : " + fc.FinanceHomeScreenTitle.getText());
        TestListener.logToExtentReport("Timing Msg is :" + fc.TimeInfoText.getText());
        takeScreenshot("Finance");
        fc.financehome();
        ut.waitForElementToBeVisible(fc.DropDownPlaceHolderText);
        TestListener.logToExtentReport("1st screen Question title is : " + fc.FinanceFirstScreenQueTitle.getText());
        softAssert.assertEquals("What's your line of work?", fc.FinanceFirstScreenQueTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Whats your work?");
        TestListener.logToExtentReport("Header txt is : " + fc.FinanceScreenHeaderTitle.getText());
        softAssert.assertEquals("Select line of work", fc.DropDownPlaceHolderText.getText());
        TestListener.handleSoftAssertions(softAssert);
        fc.DropDownPlaceHolderText.click();
        ut.waitForElementToBeVisible(fc.verifyText);
        takeScreenshot("Work Selection Screen");
        fc.printWorkOptions();
        fc.selectwork.click();
        // fc.makemoney();
        ut.waitForElementToBeVisible(fc.finance2ndscreenQueTitle);
        softAssert.assertEquals(fc.finance2ndscreenQueTitle.getText(),fc.expectedYearMoneyQue );
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("2nd screen title is : " + fc.finance2ndscreenQueTitle.getText());
        takeScreenshot("Yearly Income");
        TestListener.logToExtentReport("Default Income before Editing is :" + fc.SecondScreenDefaultIncomeTitle.getText());
        fc.dotBtnPlusMinus("2");
        takeScreenshot("Yearly Income after Edit");
        continueButton();
        TestListener.logToExtentReport("DialogBox HeaderText Is: " + fc.DialogBoxHeaderText.getText());
        TestListener.logToExtentReport("DialogBox Text Is : " + fc.DialogBoxTexts.getText());
        fc.proceedBtn.click();
        ut.waitForElementToBeVisible(fc.ThirdScreenDefaultIncomeTitle);
        TestListener.logToExtentReport("3rd Screen Question Title is: " + fc.finance3rdscreenQueTitle.getText());
        TestListener.logToExtentReport("Before editing NetWorth is: " + fc.ThirdScreenDefaultIncomeTitle.getText());
        takeScreenshot("Default NetWorth");
        Thread.sleep(2000);
        fc.dotBtnPlusMinus("1");
        takeScreenshot("Edited NetWorth");
        Thread.sleep(2000);
        continueButton();
        softAssert.assertAll();
    }

    @Test(priority = 22, description = "Profession Home")
    public void profession() {
        ProfessionHome ph = new ProfessionHome(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

        if (ph.professionHomeScreenTitle.isDisplayed()) {
            ut.waitForElementToBeVisible(ph.professionHomeScreenTitle);
            takeScreenshot("Profession");
            softAssert.assertEquals("Tell me about your profession.", ph.professionHomeScreenTitle.getText());
            TestListener.handleSoftAssertions(softAssert);
            TestListener.logToExtentReport("Profession Home Screen Title is: " + ph.professionHomeScreenTitle.getText());
            ph.continueprofessionbtn();
            ut.waitForElementToBeVisible(ph.profession1stScreenQueTitle);
            softAssert.assertEquals("What's your job title?", ph.profession1stScreenQueTitle.getText());
            TestListener.handleSoftAssertions(softAssert);
            TestListener.logToExtentReport("Header is: " + ph.ProfessionHeaderTitle.getText());
            TestListener.logToExtentReport("1st Question is : " + ph.profession1stScreenQueTitle.getText());
            TestListener.logToExtentReport("Page No is: " + ph.FirstPageNo.getText());
            softAssert.assertEquals("Add job title", ph.addjobtitle.getText());
            TestListener.handleSoftAssertions(softAssert);
            takeScreenshot("Add Job Title");
            ph.addjobtitle.click();
            // ph.editjob();
            // ut.swipeToAGivenTextAndClick("Software Developer");
            //  ut.scrollToElementByActionClass("Software Developer");
            ut.swipeToAGivenXpathAndClick("Software Developer");
            takeScreenshot("search profession");
            // ph.selectjob.click();
            softAssert.assertAll();

        } else {
            logger.info("ProfessionPage is not available for Selected Work");
        }
    }

    @Test(priority = 23, description = "Profession Industry")
    public void industry() throws InterruptedException {
        Utils ut = new Utils(getAppiumDriver());
        ProfessionIndustry pi = new ProfessionIndustry(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();
        ProfessionHome ph = new ProfessionHome(getAppiumDriver());

        if (!ph.ProfessionHeaderTitle.isDisplayed()) {
            logger.info("Profession Industry is not available for selected work");
        } else {
            ut.waitForElementToBeVisible(pi.profession2ndScreenQueTitle);
            TestListener.logToExtentReport("2nd Screen Question Title is : " + pi.profession2ndScreenQueTitle.getText());
            softAssert.assertEquals("Add industry", pi.DropDown2ndScreenPlaceHolderText.getText());
            TestListener.handleSoftAssertions(softAssert);
            TestListener.logToExtentReport("DropDown Text is : " + pi.DropDown2ndScreenPlaceHolderText.getText());
            takeScreenshot("2nd Screen");
            Thread.sleep(1000);
            pi.DropDown2ndScreenPlaceHolderText.click();
            Thread.sleep(2000);
            takeScreenshot("Select Your Industry");
            pi.addindustry.click();
            softAssert.assertAll();
        }

    }

    @Test(priority = 24, description = "EducationBackground")
    public void education() throws InterruptedException {
        Education education = new Education(getAppiumDriver());
        Settings st = new Settings(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals("Let's explore your educational background.", education.educationHomeScreenTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Education Section Breaker");
        TestListener.logToExtentReport("EducationHomeScreen Title is " + education.educationHomeScreenTitle.getText());
        education.continueeducation.click();
        softAssert.assertEquals("Visible to your recommendations only", education.privacyText.getText());
        TestListener.logToExtentReport("Privacy text is : " + education.privacyText.getText());
        takeScreenshot("Education 1st screen");
        softAssert.assertEquals("What are your education details?", education.education1stScreenQueTitle.getText());
        TestListener.logToExtentReport("Education 1st Screen title is : " + education.education1stScreenQueTitle.getText());
        softAssert.assertEquals("Add qualification", education.dropDownPlaceHolderText.getText());
        TestListener.handleSoftAssertions(softAssert);
        Thread.sleep(1000);
        education.dropDownPlaceHolderText.click();
        ut.swipeToAGivenTextAndClick("B.Tech");
        TestListener.logToExtentReport("Degree Screen Question is : " + education.DegreeScreenQueText.getText());
        softAssert.assertEquals("What was the type of degree?", education.DegreeScreenQueText.getText());
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Degree");
        education.degreetype.click();
        softAssert.assertEquals("Add college name", education.CollageScreenHeaderText.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Collage Screen Header is : " + education.CollageScreenHeaderText.getText());
        education.SearchCollege.sendKeys("University of Oxford");
        education.collegeselect.click();
        ut.waitForElementToBeVisible(education.PlusButtonImage);
        takeScreenshot("After add ");
        logger.info(education.deletButton.isDisplayed());
        if (education.BtnContinue.isEnabled()) {
            continueButton();
        } else {
            ut.waitForElementToBeVisible(education.BtnContinue.isEnabled());
        }
        softAssert.assertAll();
    }

    @Test(priority = 25, description = "AddPhotos")
    public void photo() throws InterruptedException {
        Photos ph = new Photos(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        EditProfile edit = new EditProfile(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals("And finally, share a photo that you'd like.", ph.PhotoHomeScreenTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Photos Home screen Title is :" + ph.PhotoHomeScreenTitle.getText());
        softAssert.assertEquals("Should take about 30 seconds.", ph.TimeInfoText.getText());
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Photos");
        ph.continuephoto();
        softAssert.assertEquals("Your photos will undergo verification by me. Only if they meet our guidelines will your profile be approved. Uploading fake or irrelevant photos will be a wasted effort.", ph.DialogBoxMsg.getText());
        TestListener.logToExtentReport("Just FYI DialogBox msg is : " + ph.DialogBoxMsg.getText());
        ph.okbutn.click();
        ph.tapphoto();
        ph.DownloadSamsung.click();
        ph.SamsungPhoto1.click();
        ut.waitForElementToBeVisible(ph.Plus2);
        ph.Plus2.click();
        ph.DownloadSamsung.click();
        ph.SamsungPhoto2.click();
        ut.waitForElementToBeVisible(ph.Plus3);
        ph.Plus3.click();
        ph.DownloadSamsung.click();
        ph.SamsungPhoto3.click();
        ut.waitForElementToBeVisible(ph.Plus4);
        ph.Plus4.click();
        ph.DownloadSamsung.click();
        ph.SamsungPhoto4.click();
        takeScreenshot("PhotoSelection");
        Thread.sleep(1000);
        Utils.dragAndDropUsingTouchAction(ph.start,1,ph.end,4);
        continueButton();
        ut.waitForElementWithFluentWait(edit.textGender);
        softAssert.assertAll();
    }

    @Test(priority = 26, description = "EditProfile")
    public void editProfile() throws InterruptedException {
        EditProfile edit = new EditProfile(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(edit.WorkHeaderText);
        takeScreenshot("Image");
        Thread.sleep(2000);
        ut.swipeToAGivenTextAndClick("Save");
        softAssert.assertAll();
    }

    @Test(priority = 27, description = "CheckList")
    public void checkList() {
        CheckList list = new CheckList(getAppiumDriver());


        Utils ut = new Utils(getAppiumDriver());
        ut.swipeToAGivenTextAndClick("Eating habits");
        ut.swipeToAGivenTextAndClick("Save");
    }

    @Test(priority = 28, description = "Priority")
    public void priority() {
        Priority pr = new Priority(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        pr.tickpriority();
        Utils.dragAndDrop(pr.start, 6, pr.end, 1);
        continueButton();
    }



    @AfterTest
    public void close() {

        tearDown();
    }
}

package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Petsure;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import pages.PolicyDetails;

public class BaseClass {
    private Browser browser;
    protected Petsure petSure;
    protected PolicyDetails policyDetails;

    @BeforeMethod
    public void setUp(){
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize( 1920, 1080);
        page.navigate("https://exaltwebuat.petsure.com/pet-name");
        petSure = new Petsure(page);
        policyDetails = new PolicyDetails(page);
    }

    @AfterMethod
    public void tearDown(){
        browser.close();
    }

}

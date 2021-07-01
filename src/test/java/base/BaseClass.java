package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Petsure;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import pages.PlaywrightGarage;
import pages.PolicyDetails;
import utils.Log;

public class BaseClass {
    private Browser browser;
    protected Petsure petSure;
    protected PolicyDetails policyDetails;
    protected PlaywrightGarage playwrightGarage;

    @BeforeMethod
    public void setUp(){
        String surfer = System.getProperty("browser");
        String pointer = "https://" + System.getProperty("environment") + "/pet-name";
        switch (surfer) {
            case "chrome":
                browser = Playwright
                        .create()
                        .chromium()
                        .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                Log.info("Starting web browser Google Chrome");
                break;
            case "edge":
                browser = Playwright
                        .create()
                        .chromium()
                        .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
                Log.info("Starting web browser Microsoft Edge");
                break;
            case "firefox":
                browser = Playwright
                        .create()
                        .firefox()
                        .launch(new BrowserType.LaunchOptions().setHeadless(false));
                Log.info("Starting web browser Mozilla Firefox");
                break;
            default:
                browser = Playwright
                        .create()
                        .chromium()
                        .launch(new BrowserType.LaunchOptions());
                Log.info("Starting web browser Chromium headless");
                break;
        }

        Page page = browser.newPage();
        page.setViewportSize( 1920, 1080);
        page.navigate(pointer);
        page.click("text=Accept all");
        Log.info("Browser started and resized. Navigated to the URL, then accepted cookies!");

        petSure = new Petsure(page);
        policyDetails = new PolicyDetails(page);
        playwrightGarage = new PlaywrightGarage(page);
    }

    @AfterMethod
    public void tearDown(){
        Log.info("Closing web browser.");
        browser.close();
    }

}

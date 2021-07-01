package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;

public class PlaywrightGarage {
    private final Page page;

    public PlaywrightGarage(Page page) {
        this.page = page;
    }

    public void testPilot() {
        // Click input[name="petName"]
        page.click("input[name=\"petName\"]");

        // Fill input[name="petName"]
        page.fill("input[name=\"petName\"]", "Yuki");

        // Click text=Continue
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://exaltwebuat.petsure.com/pet-type?personReference=8hhHGtg3cE%2BJmS3z40sCEw%3D%3D&quoteReference=ahSfKR0q%2F2bQAbiu3VG3Vg%3D%3D&propertyReference=QHZZtqF0qCG1sgKZPURUeg%3D%3D"), () ->
        page.waitForNavigation(() -> {
            page.click("text=Continue");
        });

        // Click label:has-text("Cat")
        page.click("label:has-text(\"Cat\")");

        // Click text=Continue
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://exaltwebuat.petsure.com/pet-gender?quoteReference=ahSfKR0q%2F2bQAbiu3VG3Vg%3D%3D&personReference=8hhHGtg3cE%2BJmS3z40sCEw%3D%3D&propertyReference=QHZZtqF0qCG1sgKZPURUeg%3D%3D"), () ->
        page.waitForNavigation(() -> {
            page.click("text=Continue");
        });

        // Click text=Male Selected
        page.click("text=Male Selected");

        // Click input[type="text"]
        page.click("input[type=\"text\"]");

        // Fill input[type="text"]
        page.fill("input[type=\"text\"]", "14");

        // Click #month
        page.click("#month");

        // Fill #month
        page.fill("#month", "10");

        // Click #year
        page.click("#year");

        // Fill #year
        page.fill("#year", "2016");
        page.keyboard().press("Tab");

        // Click text=Continue
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://exaltwebuat.petsure.com/pet-breed?quoteReference=ahSfKR0q%2F2bQAbiu3VG3Vg%3D%3D&personReference=8hhHGtg3cE%2BJmS3z40sCEw%3D%3D&propertyReference=QHZZtqF0qCG1sgKZPURUeg%3D%3D"), () ->
        page.waitForNavigation(() -> {
            page.click("text=Continue");
        });

        // Click text=Moggie Selected
        page.click("text=Moggie Selected");

        // Click text=Continue
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://exaltwebuat.petsure.com/pet-neutered?quoteReference=ahSfKR0q%2F2bQAbiu3VG3Vg%3D%3D&personReference=8hhHGtg3cE%2BJmS3z40sCEw%3D%3D&propertyReference=QHZZtqF0qCG1sgKZPURUeg%3D%3D"), () ->
        page.waitForNavigation(() -> {
            page.click("text=Continue");
        });

        // Click text=No Selected
        page.click("text=No Selected");

        // Click :nth-match(:text("Yes Selected"), 2)
        page.click(":nth-match(:text(\"Yes Selected\"), 2)");

        // Click text=Continue
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://exaltwebuat.petsure.com/pet-cost?quoteReference=ahSfKR0q%2F2bQAbiu3VG3Vg%3D%3D&personReference=8hhHGtg3cE%2BJmS3z40sCEw%3D%3D&propertyReference=QHZZtqF0qCG1sgKZPURUeg%3D%3D"), () ->
        page.waitForNavigation(() -> {
            page.click("text=Continue");
        });

        // Click input[type="number"]
        page.click("input[type=\"number\"]");

        // Fill input[type="number"]
        page.fill("input[type=\"number\"]", "100");

        // Click text=Continue
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://exaltwebuat.petsure.com/pet-dental-cover?quoteReference=ahSfKR0q%2F2bQAbiu3VG3Vg%3D%3D&personReference=8hhHGtg3cE%2BJmS3z40sCEw%3D%3D&propertyReference=QHZZtqF0qCG1sgKZPURUeg%3D%3D"), () ->
        page.waitForNavigation(() -> {
            page.click("text=Continue");
        });

        // Click text=No Selected
        page.click("text=No Selected");

        // Click text=Continue
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://exaltwebuat.petsure.com/pet-medical-condition?quoteReference=ahSfKR0q%2F2bQAbiu3VG3Vg%3D%3D&personReference=8hhHGtg3cE%2BJmS3z40sCEw%3D%3D&propertyReference=QHZZtqF0qCG1sgKZPURUeg%3D%3D"), () ->
        page.waitForNavigation(() -> {
            page.click("text=Continue");
        });

        // Click text=Yes Selected
        page.click("text=Yes Selected");

        // Click text=Continue
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://exaltwebuat.petsure.com/pet-awaiting-diagnosis?quoteReference=ahSfKR0q%2F2bQAbiu3VG3Vg%3D%3D&personReference=8hhHGtg3cE%2BJmS3z40sCEw%3D%3D&propertyReference=QHZZtqF0qCG1sgKZPURUeg%3D%3D"), () ->
        page.waitForNavigation(() -> {
            page.click("text=Continue");
        });

        page.click("text=No Selected");

        page.waitForNavigation(() -> {
            // Click text=No Selected

            // Click text=Continue
            page.click("text=Continue");

            for (int i=0; i<7; i++) {
                page.keyboard().press("Tab");
            }
//            page.click("text=Continue");
            System.out.println("clicked continue button and waiting for medical page to load");


        });




//        page.waitForNavigation(() -> {
//            ElementHandle frameElement = page.querySelector("#healthFrame");
//            Frame frame = frameElement.contentFrame();
//
//                                frame.click("input[name=\"conditionsearch\"]");
//
//                    // Fill input[name="conditionsearch"]
//                    frame.fill("input[name=\"conditionsearch\"]", "tick");
//
//                    // Click button[role="button"]:has-text("Select")
//                    frame.click("button[role=\"button\"]:has-text(\"Select\")");
//        });

        System.out.println("Medical page should be loaded by now.");

//        page.evaluate("document.getElementById('btnSearch').click(); ");
//
//        frame.evaluate("document.getElementById('btnSearch').click(); ");


//
        ElementHandle frameElement = page.querySelector("#healthFrame");
        Frame frame = frameElement.contentFrame();

        frame.evaluate("document.getElementById('btnSearch').click(); ");


        // Click input[name="conditionsearch"]
        page.frame("healthFrame").click("input[name=\"conditionsearch\"]");

        // Fill input[name="conditionsearch"]
        page.frame("#healthFrame").fill("input[name=\"conditionsearch\"]", "tick");

        // Click button[role="button"]:has-text("Select")
        page.frame("healthFrame").click("button[role=\"button\"]:has-text(\"Select\")");

        // Click :nth-match(input[name="answerNum"], 2)
        page.frame("healthFrame").click(":nth-match(input[name=\"answerNum\"], 2)");

        // Click :nth-match(input[name="answerNum"], 2)
        page.frame("healthFrame").click(":nth-match(input[name=\"answerNum\"], 2)");

        // Click text=Continue
        page.frame("healthFrame").click("text=Continue");

        // Click button:has-text("Finish")
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://exaltwebuat.petsure.com/verisk-summary?quoteReference=ahSfKR0q%2F2bQAbiu3VG3Vg%3D%3D&personReference=8hhHGtg3cE%2BJmS3z40sCEw%3D%3D&propertyReference=QHZZtqF0qCG1sgKZPURUeg%3D%3D&hashCode=adebad55f0862f7e3f4621ea2b1dbdd0"), () ->
        page.waitForNavigation(() -> {
            page.frame("healthFrame").click("button:has-text(\"Finish\")");
        });

        // Click text=Continue
        page.click("text=Continue");
        // assert page.url().equals("https://exaltwebuat.petsure.com/pet-assumption?quoteReference=ahSfKR0q%2F2bQAbiu3VG3Vg%3D%3D&personReference=8hhHGtg3cE%2BJmS3z40sCEw%3D%3D&propertyReference=QHZZtqF0qCG1sgKZPURUeg%3D%3D");
    }
}

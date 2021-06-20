package pages;

import com.microsoft.playwright.Page;

public class Petsure {
    private Page page;

    private final String appVersion = "body > div.sticky-ver-label";

    private final String acceptCookies = "//button[@id='accept-all']";
    private final String iDontWantCookies = "//button[@id='accept-all']//preceding::button";
    private final String learnMoreCookies = "//a[@id='cookieLearnMoreOpener']";

    private final String openHelp = "//a[@id='helpOpen']";
    private final String helpFAQ = "//a[@onclick='faqshow()']";
    private final String helpCallUs = "//a[@onclick='callUshow()']";
    private final String helpClose = "//a[@onclick='backToHelp()']";

    private final String dontHavePet = "//a[@data-target='#petNameModal']";
    private final String dontHavePetOK = "//button[@text='Ok, got it']";

    private final String petName = "//input[@name='petName']";
    private final String continueButton = "text=Continue";

    public Petsure(Page page) {
        this.page = page;
    }

    public void getVersion() {
        System.out.println(page.waitForSelector(appVersion).getAttribute("innerText"));
    }

    public void clickAcceptAllButton() {
        page.click(acceptCookies);
    }

    public void typePetName(String pet) {
        page.fill(petName, pet);
    }

    public void clickContinueButton() {
        page.click(continueButton);
    }

}

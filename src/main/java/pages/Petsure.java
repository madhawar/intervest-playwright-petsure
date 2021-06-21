package pages;

import com.microsoft.playwright.Page;

public class Petsure {
    private Page page;

    private final String appVersion = "body > div.sticky-ver-label";

    private final String iDontWantCookies = "button:has-text('×')";
    private final String acceptCookies = "text=Accept all";
    private final String learnMoreCookies = "text=learn more";
    private final String acceptRecommendedCookies = "text=Accept Recommended settings";

    private final String openHelp = "#helpOpen";
    private final String helpFAQ = "text=FAQs";
    private final String helpFAQBack = "text=Back";
    private final String helpCallUs = "text=Call us";
    private final String helpCallUsBack = "#callModalBody >> text=Back";
    private final String helpClose = "button:has-text('Help')";

    private final String dontHavePet = "text=Tell us about your future pet";
    private final String dontHavePetOK = "text=Ok, got it";

    private final String petName = "input[id='petName']";

    private final String petCat = "label:has-text('Cat')";
    private final String petDog = "label:has-text('Dog')";

    private final String petMale = "text=Male";
    private final String petFemale = "text=Female";
    private final String dobDay = "input[id='day']";
    private final String dobMonth = "input[id='month']";
    private final String dobYear = "input[id='year']";

    private final String dogTypePedigree = "text=Pedigree";
    private final String dogTypeCross = "text=Cross breed";
    private final String dogTypeMixed = "text=Mixed breed";
    private final String dogDomBreedUnknown = "text=I'm not sure";
    private final String dogDomBreed = "[placeholder='Search the dominant breed']";
    private final String dogDomBreedSearch = "#breedSelectDominant";
    private final String dogDomBreedPure = "#pure-Labrador";
    private final String dogWeight = "#weight";
    private final String dogWeightCat1 = "#weightDropdown >> text=Up to 10kg";
    private final String dogWeightCat2 = "text=10kg - 20kg";
    private final String dogWeightCat3 = "text=20kg or more";

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

    public void selectCat() {
        page.click(petCat);
    }

    public void selectDog() {
        page.click(petDog);
    }

    public void selectMale() {
        page.click(petMale);
    }

    public void selectFemale() {
        page.click(petFemale);
    }

    public void enterBirthday() {
        page.fill(dobDay, "10");
        page.fill(dobMonth, "06");
        page.fill(dobYear, "2010");
        page.press(dobYear, "Tab");
    }

    public void selectPedigree() {
        page.click(dogTypePedigree);
    }

    public void selectCross() {
        page.click(dogTypeCross);
    }

    public void selectMixed() {
        page.click(dogTypeMixed);
    }

    public void selectDominantBreedUnknown() {
        page.click(dogDomBreedUnknown);
    }

    public void selectWeight_1() {
        page.click(dogWeight);
        page.click(dogWeightCat1);
    }

    public void clickContinueButton() {
        page.waitForNavigation(() -> {
            page.click(continueButton);
        });

    }

}

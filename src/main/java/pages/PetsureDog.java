package pages;

import com.microsoft.playwright.Page;

public class PetsureDog {
    private Page page;

    private final static String MAX_AGE = "Please enter a valid birthday";
    private final static String MIN_AGE = " must be at least 4 weeks old";
    private final static String NAME_VALIDATION_EMPTY = "Name is required";
    private final static String NAME_VALIDATION_SHORT = "Minimum length should be 2";
    private final static String NAME_VALIDATION_INVALID = "Invalid input";

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

    public PetsureDog(Page page) {
        this.page = page;
    }

    public void getVersion() {
        System.out.println(page.waitForSelector(appVersion).getAttribute("innerText"));
    }

    public void clickAcceptAllCookiesButton() {
        page.click(acceptCookies);
    }

    public void typePetName(String pet) {
        page.fill(petName, pet);
        page.press(petName, "Tab");
    }

    public void verifyPetNameEmpty() {
        page.isVisible("text=" +NAME_VALIDATION_EMPTY+"'");
    }

    public void verifyPetNameShort() {
        page.isVisible("text=" +NAME_VALIDATION_SHORT+"'");
    }

    public void verifyPetNameInvalid() {
        page.isVisible("text=" +NAME_VALIDATION_INVALID+"'");
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

    public void enterBirthday(String birthday, String birthmonth, String birthyear) {
        page.fill(dobDay, birthday);
        page.fill(dobMonth, birthmonth);
        page.fill(dobYear, birthyear);
        page.press(dobYear, "Tab");
    }

    public void verifyMaxAge() {
        page.isVisible("text=" +MAX_AGE+"'");
    }

    public void verifyMinAge(String pet) {
        page.isVisible("text=" + pet + MIN_AGE+"'");
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

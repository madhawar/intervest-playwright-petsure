package pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;

import java.util.Random;

public class Petsure {
    private final Page page;

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

    private final String typeMoggie = "text=Moggie";

    private final String typePedigree = "text=Pedigree";
    private final String typeOther = "text=Other";

    private final String typeCrossBreed = "text=Cross breed";
    private final String typeCrossBreedNotListed = "text=Breed Not Listed";
    private final String typeMixedBreed = "text=Mixed breed";
    private final String typeMixedBreedNotSure = "text=I'm not sure";

    private final String breedSearchBox = "#breed";
    private final String breedPureSearchList_1 = "[id='pure-";
    private final String breedPureSearchList_2 = "']";

    private final String breedCrossSearchBox = "#breedCross";
    private final String breedCrossSearchBox1 = "#breedCross1";
    private final String breedCrossSearchBox2 = "#breedCross2";
    private final String breedMixedDominantSearchBox = "#breedDominant";
    private final String breedCrossSearchList_1 = "[id='cross-";
    private final String breedCrossSearchList_2 = "']";

    private final String breedMixedWeight = "#weight";
    private final String breedMixedWeightOption1 = "#weightDropdown >> text=Up to 10kg";
    private final String breedMixedWeightOption2 = "text=10kg - 20kg";
    private final String breedMixedWeightOption3 = "text=20kg or more";

    private final String neuteredOrSpayedYes = "//label[@for='yes']";
    private final String neuteredOrSpayedNo = "//label[@for='no']";

    private final String microchippedYes = "//label[@for='isMicroChipped-yes']";
    private final String microchippedNo = "//label[@for='isMicroChipped-no']";

    private final String dentalIllnessYes = "//label[@for='yes']";
    private final String dentalIllnessNo = "//label[@for='no']";

    private final String healthCheckQuestionYes = "//label[@for='yes']";
    private final String healthCheckQuestionNo = "//label[@for='no']";

    private final String assumptionsYes = "text=Yes, I agree";
    private final String assumptionsNo = "No, I don't agree";

    private final String iFrameHealth = "#healthFrame";

    private final String petCost = "#petCost";

    private final String okayGotItButton = "#confirm";
    private final String okayGotItMedicalButton = "#medicalWarningDismiss";

    private final String submitButton = "text=Continue";
    private final String continueButton = "#submit";

    public Petsure(Page page) {
        this.page = page;
    }

    public void getVersion() {
        System.out.println(page.waitForSelector(appVersion).getAttribute("innerText"));
    }

    public void clickAcceptAllCookiesButton() {
        page.click(acceptCookies);
    }

    public void clickContinueButton() {
        page.waitForNavigation(() -> {
            page.click(continueButton);
        });
    }

    public void verifyContinueButtonRemainsHidden() {
        page.waitForNavigation(() -> {
            boolean continueButtonDisplayed = page.isVisible(continueButton);
            Assert.assertFalse(continueButtonDisplayed);
        });
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

    public void selectPetType(String animal) {
        switch (animal) {
            case "cat":
                page.click(petCat);
                break;
            case "dog":
                page.click(petDog);
                break;
        }
    }

    public void selectPetGender(String gender) {
        switch (gender) {
            case "male":
                page.click(petMale);
                break;
            case "female":
                page.click(petFemale);
                break;
        }
    }

    public void selectBreed(String animal, String type, String breed, String dominant_breed) {
        if (animal.equals("cat")) {
            switch (type) {
                case "moggie":
                    page.click(typeMoggie);
                    break;
                case "pedigree":
                    page.click(typePedigree);

                    page.fill(breedSearchBox, breed);
                    page.click(breedSearchBox);
                    page.click(breedPureSearchList_1 + breed + breedPureSearchList_2);
                    break;
                case "other":
                    page.click(typeOther);

                    page.fill(breedSearchBox, breed);
                    page.click(breedSearchBox);
                    page.click(breedPureSearchList_1 + breed + breedPureSearchList_2);
                    break;
            }
        }
        else if (animal.equals("dog")) {
            switch (type) {
                case "pedigree":
                    page.click(typePedigree);

                    page.fill(breedSearchBox, breed);
                    page.click(breedSearchBox);
                    page.click(breedPureSearchList_1 + breed + breedPureSearchList_2);
                    break;
                case "cross":
                    page.click(typeCrossBreed);

                    page.fill(breedCrossSearchBox, dominant_breed);
                    page.click(breedCrossSearchBox);
                    page.click(breedCrossSearchList_1 + dominant_breed + breedCrossSearchList_2);
                    break;
                case "mixed":
                    page.click(typeMixedBreed);

                    page.fill(breedMixedDominantSearchBox, dominant_breed);
                    page.click(breedMixedDominantSearchBox);
                    page.click(breedPureSearchList_1 + dominant_breed + breedPureSearchList_2);
                    break;
            }
        }
    }

    public void crossBreedNotListed(String breed, String dominant_breed) {
        page.click(typeCrossBreed);
        page.click(typeCrossBreedNotListed);

        page.fill(breedCrossSearchBox1, breed);
        page.click(breedCrossSearchBox1);
        page.click(breedPureSearchList_1 + breed + breedPureSearchList_2);

        page.fill(breedCrossSearchBox2, dominant_breed);
        page.click(breedCrossSearchBox2);
        page.click(breedPureSearchList_1 + dominant_breed + breedPureSearchList_2);
    }

    public void mixedBreedNotSure() {
        page.click(typeMixedBreed);
        page.click(typeMixedBreedNotSure);

        Random r = new Random();
        int low = 1;
        int high = 4;
        int result = r.nextInt(high-low) + low;

        switch (result) {
            case 1:
                page.click(breedMixedWeight);
                page.click(breedMixedWeightOption1);
                break;
            case 2:
                page.click(breedMixedWeight);
                page.click(breedMixedWeightOption2);
                break;
            case 3:
                page.click(breedMixedWeight);
                page.click(breedMixedWeightOption3);
                break;
        }
    }

    public void answerNeuteredOrSpayedQuestion(String neutered_spayed) {
        switch (neutered_spayed) {
            case "yes":
                page.click(neuteredOrSpayedYes);
                break;
            case "no":
                page.click(neuteredOrSpayedNo);
                break;
        }
    }

    public void answerMicrochipQuestion(String microchipped) {
        switch (microchipped) {
            case "yes":
                page.click(microchippedYes);
                page.waitForNavigation(() -> {
                    page.click(continueButton);
                });
                break;
            case "no":
                page.click(microchippedNo);
                page.click(continueButton);

                page.waitForNavigation(() -> {
                    page.click(okayGotItButton);
                });
                break;
        }
    }

    public void costPaidOrDonated(String donation) {
        page.fill(petCost, donation);
    }

    public void dentalIllnessCover(String dental_illness) {
        switch (dental_illness) {
            case "yes":
                page.click(dentalIllnessYes);
                break;
            case "no":
                page.click(dentalIllnessNo);
                break;
        }
    }

    public void healthCover(String visited_vet_prescribed_medication, String awaiting_surgery, String animal) {
        if (visited_vet_prescribed_medication.equals("no")) {
            page.click(healthCheckQuestionNo);
            page.waitForNavigation(() -> {
                 page.click(continueButton);
            });
        }
        else if (visited_vet_prescribed_medication.equals("yes")){
            if (awaiting_surgery.equals("yes")) {
                page.click(healthCheckQuestionYes);
                page.waitForNavigation(() -> {
                    page.click(continueButton);
                });

                page.click(healthCheckQuestionYes);
                page.click(continueButton);
                page.waitForNavigation(() -> {
                    page.click(okayGotItMedicalButton);
                });
            }
            else if (awaiting_surgery.equals("no")) {
                page.click(healthCheckQuestionYes);
                page.waitForNavigation(() -> {
                    page.click(continueButton);
                });

                page.click(healthCheckQuestionNo);
                page.waitForNavigation(() -> {
                    page.click(continueButton);
                });

                if (animal.equals("cat")) {
                    // page.click("text=Continue");

                    page.frame(iFrameHealth).click("input[name=\"conditionsearch\"]");

                    page.frame(iFrameHealth).fill("input[name=\"conditionsearch\"]", "tick");

                    page.frame(iFrameHealth).click("input:has-text(\"Search\")");

                    page.frame(iFrameHealth).click("button[role=\"button\"]:has-text(\"Select\")");

                    page.frame(iFrameHealth).click(":nth-match(input[name=\"answerNum\"], 2)");

                    page.frame(iFrameHealth).click(":nth-match(input[name=\"answerNum\"], 2)");

                    page.frame(iFrameHealth).click("text=Continue");

                    page.waitForNavigation(() -> {
                        page.frame(iFrameHealth).click("button:has-text(\"Finish\")");
                    });

                    page.click("text=Continue");
                } else if (animal.equals("dog")) {
                    // page.click("text=Continue");

                    page.frame(iFrameHealth).click("input[name=\"conditionsearch\"]");

                    page.frame(iFrameHealth).fill("input[name=\"conditionsearch\"]", "tick");

                    page.frame(iFrameHealth).click("input:has-text(\"Search\")");

                    page.frame(iFrameHealth).click("text=Ticks (canine) Select >> button[role=\"button\"]");

                    page.frame(iFrameHealth).click("input[name=\"answerNum\"]");

                    page.frame(iFrameHealth).click(":nth-match(input[name=\"answerNum\"], 2)");

                    page.frame(iFrameHealth).click("text=Continue");

                    page.waitForNavigation(() -> {
                        page.frame(iFrameHealth).click("button:has-text(\"Finish\")");
                    });

                    page.click("text=Continue");
                }
            }
        }
    }

    public void agreeToAssumptions() {
        page.click(assumptionsYes);
    }

    public void disagreeToAssumptions() {
        page.click(assumptionsNo);
    }

}

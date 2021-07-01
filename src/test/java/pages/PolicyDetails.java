package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import utils.Log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PolicyDetails {
    private final Page page;

    private final String anyOtherPetsYes = "//label[@for='yesVisited']";
    private final String anyOtherPetsNo = "//label[@for='noVisited']";

    private final String alreadyCoveredPet = "input[name='name']";
    private final String alreadyCoveredPetRenewMonth = "input[name='month']";
    private final String alreadyCoveredPetRenewYear = "input[name='year']";
    private final String petsAlreadyCovered = "text=They already have cover";
    private final String petsAlreadyCoveredSubmit = "text=Confirm";
    private final String petsAlreadyCoveredConfirmPopup = "text=ok, got it";
    private final String petsAlreadyCoveredClosePopup = "text=No thanks";

    private final String policyStartsToday = "text=Today";
    private final String policyStartsTomorrow = "text=Tomorrow";
    private final String policyStartsOther = "text=Other";

    private final String ownerTitle = "select[name='title']";
    private final String ownerFirstName = "input[name='firstName']";
    private final String ownerLastName = "input[name='lastName']";
    private final String ownerBirthDay = "input[name='day']";
    private final String ownerBirthMonth = "input[name='month']";
    private final String ownerBirthYear = "input[name='year']";
    private final String ownerEmail = "input[name='email']";
    private final String ownerTelephone = "input[name='phone']";
    private final String ownerPostcode = "input[name='postCode']";
    private final String staysurePostcode = "text=Staysure Services Ltd Britannia House Rushmills Northampton";
    private final String ownerAddress1 = "input[name='address1']";
    private final String ownerAddress2 = "input[name='address2']";
    private final String ownerCity = "input[name='city']";
    private final String ownerCountry = "select[name='country1']";

    private final String labelComms = "text=Communication preferences";
    private final String commsEmail = "text=Email";
    private final String commsTelephone = "text=Telephone";
    private final String commsSMS = "text=Text message";
    private final String commsPost = "text=Post";

    private final String tailorVetFee = "text=£1,000";
    private final String tailorExcess = "text=£100";
    private final String tailorBillShare = "text=10%";

    private final String docIPID = "text=Insurance Product Information Document (IPID)";
    private final String docPolicyWording = "text=Policy Wording";

    private final String extraFarewell = "//*[@id='switch-0FAREWELL_COVER']//parent::div";
    private final String extraTravelAndHoliday = "//*[@id='switch-0TRAVEL_AND_HOLIDAY_COVER']//parent::div";
    private final String extraMissingPet = "//*[@id='switch-0MISSING_PET_COVER']//parent::div";

    private final String labelDentalIllness = "text=Dental Illness Cover";
    private final String labelFarewell = "text=Farewell Cover";
    private final String labelTavelAndHoliday = "text=Travel & Holiday Cover";
    private final String labelMissingPet = "text=Missing Pet Cover";

    private final String payMonthly = "text=Monthly";
    private final String payAnnually = "text=Annually";
    private final String agreeToTerms = "#confirmInfo";

    private final String iFramePayment = "#paymentFrame";
    private final String cardHolderName = "#cardholderName";
    private final String cardNumber = "#cardNumber";
    private final String cardExpMM = "#expiryMonth";
    private final String cardExpYY = "#expiryYear";
    private final String cardCVV = "#csc";
    private final String paymentBack = "#btnCancel";
    private final String paymentConfirm = "#btnSubmit";

    private final String newPassword = "#password1";
    private final String agreeCheckbox = "#readAgreement";
    private final String createAccountButton = "#registerBtn";
    private final String existingPassword = "#password";
    private final String signInButton = "#signInBtn";

    private final String nextButton = "text=Next";
    private final String continueButton = "text=Continue";
    private final String okGotItButton = "text=Ok, got it";

    public PolicyDetails(Page page) {
        this.page = page;
    }

    public void clickOkGotItButton() {
        page.waitForNavigation(() -> {
            page.click(okGotItButton);
        });
    }

    public void selectYesForAnyOtherPets() {
        page.click(anyOtherPetsYes);
        page.waitForNavigation(() -> {
            page.click(continueButton);
        });

        Log.info("Selected Yes for other pets.");
    }

    public void selectNoForAnyOtherPets() {
        page.click(anyOtherPetsNo);
        page.waitForNavigation(() -> {
            page.click(continueButton);
        });

        Log.info("Selected No for other pets.");
    }

    public void addAlreadyCoveredPetDetails(String covered_pet, String renew_month, String renew_year) {
        page.click(petsAlreadyCovered);
        page.fill(alreadyCoveredPet, covered_pet);
        page.fill(alreadyCoveredPetRenewMonth, renew_month);
        page.fill(alreadyCoveredPetRenewYear, renew_year);

        page.click(petsAlreadyCoveredSubmit);

        page.waitForNavigation(() -> {
            page.click(petsAlreadyCoveredConfirmPopup);
        });

        page.click(continueButton);

        Log.info("Adding info of already covered pets.");
    }

    public void selectPolicyStartDate() {
        page.click(policyStartsTomorrow);

        page.waitForNavigation(() -> {
            page.click(continueButton);
        });

        Log.info("Selected policy start date.");
    }

    public void fillOwnerDetails() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuuMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String email_address = "madhawa_ist+" + dtf.format(now) + "pet@pm.me";

        page.selectOption(ownerTitle, "Mr");
        page.fill(ownerFirstName, "Madhawa");
        page.fill(ownerLastName, "Ratnayake");
        page.fill(ownerBirthDay, "27");
        page.fill(ownerBirthMonth, "05");
        page.fill(ownerBirthYear, "1989");
        page.fill(ownerEmail, email_address);
        page.fill(ownerTelephone, "0777837227");
        page.fill(ownerPostcode, "NN47YB");
        page.click("text=Staysure Services Ltd Britannia House Rushmills Northampton");

        page.click(labelComms);
        page.keyboard().press("ArrowDown");

        Log.info("Submitted owner details along with the email address: " + email_address);
    }

    public void setMarketingPreferences() {
        page.click(commsEmail);
        page.click(commsTelephone);
        page.click(commsSMS);
        page.click(commsPost);

        Log.info("Set marketing preferences.");
    }

    public void selectVetFree(String vet_fee) { // Supported values 1,000 | 3,000 | 5,000 | 7,500 | 10,000 | 15,000
        page.click("text=£" + vet_fee);

        page.keyboard().press("Tab");
        page.keyboard().press("ArrowDown");

        Log.info("Select Vet Fee.");
    }

    public void selectExcess(String excess) { // Supported values 0 | 100 | 200 | 300 | 400 | 500
        page.click("text=£" + excess);

        page.keyboard().press("Tab");
        page.keyboard().press("ArrowDown");

        Log.info("Select Excess.");
    }

    public void selectBillShare(String bill_share) { // Supported values 0 | 10 | 20 | 30
        page.click("text=" + bill_share + "%");

        page.keyboard().press("Tab");
        page.keyboard().press("ArrowDown");

        Log.info("Select Bill Share.");
    }

    public void selectDentalIllnessCover(String dental_illness) {
        if (dental_illness.equals("yes")) {
            String h3 = page.innerText(labelDentalIllness);
            Assert.assertEquals("Dental Illness Cover", h3);

            Log.info("Dental Illness extra already included.");
        }
        else {
            Log.info("NOT ELIGIBLE FOR Dental Illness extra.");
        }
    }

    public void selectFarewellCover() {
        String h3 = page.innerText(labelFarewell);
        Assert.assertEquals("Farewell Cover", h3);
        page.click(extraFarewell);

        Log.info("Farewell extra selected.");
    }

    public void selectTravelAndHolidayCover() {
        String h3 = page.innerText(labelTavelAndHoliday);
        Assert.assertEquals("Travel & Holiday Cover", h3);
        page.click(extraTravelAndHoliday);

        Log.info("Travel and Holiday extra selected.");
    }

    public void selectMissingPetCover(String microchipped) {
        if (microchipped.equals("yes")) {
            String h3 = page.innerText(labelMissingPet);
            Assert.assertEquals("Missing Pet Cover", h3);
            page.click(extraMissingPet);

            Log.info("Selected Missing Pet extra.");
        }
        else {
            Log.info("NOT ELIGIBLE FOR Missing Pet extra.");
        }
    }

    public void selectPaymentOption() {
        page.click(payAnnually);
        page.click(agreeToTerms);
        page.waitForNavigation(() -> {
            page.click(continueButton);
        });

        Log.info("Seleted payment option and agreed to conditions.");
    }

    public void enterPaymentDetails() {
        ElementHandle frameElement = page.querySelector(iFramePayment);
        Frame frame = frameElement.contentFrame();
        frame.fill(cardHolderName, "Madhawa Ratnayake");
        frame.fill(cardNumber, "4111111111111111");
        frame.selectOption(cardExpMM, "03");
        frame.selectOption(cardExpYY, "2030");
        frame.fill(cardCVV, "737");
//        frame.click(paymentConfirm);
        page.keyboard().press("Enter");

        Log.info("Submitted payment details.");
    }

    public void createAccount() {
        page.fill(newPassword, "January*27");
        page.click(agreeCheckbox);
        page.click(createAccountButton);

        Log.info("Created account successfully!");
    }

    public void signInToAccount() {
        page.fill(existingPassword, "January*27");
        page.click(signInButton);
    }

}

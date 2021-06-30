package pages;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import org.testng.Assert;

import java.util.regex.Pattern;

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

    private final String nextButton = "text=Next";
    private final String continueButton = "text=Continue";
    private final String okGotItButton = "text=Ok, got it";
    private String iFramePayment1;

    public PolicyDetails(Page page) {
        this.page = page;
    }

    public void clickOkGotItButton() {
        page.waitForNavigation(() -> {
            page.click(okGotItButton);
        });
    }

    public void scrollDown() {
        page.keyboard().press("Tab");
        page.keyboard().press("ArrowDown");
    }

    public void selectYesForAnyOtherPets() {
        page.click(anyOtherPetsYes);
    }

    public void selectNoForAnyOtherPets() {
        page.click(anyOtherPetsNo);
    }

    public void addAlreadyCoveredPetDetails(String covered_pet, String renew_month, String renew_year) {
        page.click(petsAlreadyCovered);
        page.fill(alreadyCoveredPet, covered_pet);
        page.fill(alreadyCoveredPetRenewMonth, renew_month);
        page.fill(alreadyCoveredPetRenewYear, renew_year);
    }

    public void submitAlreadyCoveredPets() {
        page.click(petsAlreadyCoveredSubmit);
    }

    public void confirmAlreadyCoveredPetPopup() {
        page.waitForNavigation(() -> {
            page.click(petsAlreadyCoveredConfirmPopup);
        });
    }

    public void selectPolicyStartDate() {
        page.click(policyStartsTomorrow);
    }

    public void fillOwnerDetails() {
        page.selectOption(ownerTitle, "Mr");
        page.fill(ownerFirstName, "Madhawa");
        page.fill(ownerLastName, "Ratnayake");
        page.fill(ownerBirthDay, "27");
        page.fill(ownerBirthMonth, "05");
        page.fill(ownerBirthYear, "1989");
        page.fill(ownerEmail, "madhawa_ist@protonmail.com");
        page.fill(ownerTelephone, "0777837227");
        page.fill(ownerPostcode, "NN47YB");

        page.click("text=Staysure Services Ltd Britannia House Rushmills Northampton");

        page.click(commsEmail);
        page.click(commsTelephone);
        page.click(commsSMS);
        page.click(commsPost);
    }

    public void selectVetFree(String vet_fee) {
        page.click("text=£" + vet_fee);
        // Supported values 1,000 | 3,000 | 5,000 | 7,500 | 10,000 | 15,000
        page.keyboard().press("Tab");
        page.keyboard().press("ArrowDown");
    }

    public void selectExcess(String excess) {
        page.click("text=£" + excess);
        // Supported values 0 | 100 | 200 | 300 | 400 | 500
        page.keyboard().press("Tab");
        page.keyboard().press("ArrowDown");
    }

    public void selectBillShare(String bill_share) {
        page.click("text=" + bill_share + "%");
        // Supported values 0 | 10 | 20 | 30
        page.keyboard().press("Tab");
        page.keyboard().press("ArrowDown");
    }

    public void openDocumentIPIDS() {
        page.click(docIPID);
    }

    public void openDocumentPolicyWording() {
        page.click(docPolicyWording);
    }

    public void selectDentalIllnessCover(String dental_illness) {
        if (dental_illness.equals("yes")) {
            String h3 = page.innerText(labelDentalIllness);
            Assert.assertEquals("Dental Illness Cover", h3);
        }
    }

    public void selectFarewellCover() {
        String h3 = page.innerText(labelFarewell);
        Assert.assertEquals("Farewell Cover", h3);
        page.click(extraFarewell);
    }

    public void selectTravelAndHolidayCover() {
        String h3 = page.innerText(labelTavelAndHoliday);
        Assert.assertEquals("Travel & Holiday Cover", h3);
        page.click(extraTravelAndHoliday);
    }

    public void selectMissingPetCover(String microchipped) {
        if (microchipped.equals("yes")) {
            String h3 = page.innerText(labelMissingPet);
            Assert.assertEquals("Missing Pet Cover", h3);
            page.click(extraMissingPet);
        }
    }

    public void selectPaymentOption() {
        page.click(payAnnually);
        page.click(agreeToTerms);
    }

    public void enterPaymentDetails() {
        Frame frame = page.frameByUrl(Pattern.compile(".*eshapay.*"));

//        Frame frame = page.frameByUrl(Pattern.compile("pp.eshapay.net"));
            frame.fill(cardHolderName, "Madhawa Ratnayake");
            frame.fill(cardNumber, "4111 1111 1111 1111");
            frame.selectOption(cardExpMM, "03");
            frame.selectOption(cardExpYY, "2030");
            frame.fill(cardCVV, "737");
            frame.click(paymentConfirm);
    }


}

package pages;

import com.microsoft.playwright.Page;

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

    private final String nextButton = "text=Next";

    public PolicyDetails(Page page) {
        this.page = page;
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
        page.click(petsAlreadyCoveredSubmit);
        page.click(petsAlreadyCoveredConfirmPopup);
    }

    public void selectPolicyStartDate() {
        page.click(policyStartsToday);
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
    }

    public void selectCommunicationPreferences() {
        page.click(commsEmail);
        page.click(commsTelephone);
        page.click(commsSMS);
        page.click(commsPost);
    }


}

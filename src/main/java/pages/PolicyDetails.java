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


}

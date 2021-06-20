package webquote;

import base.BaseClass;
import org.testng.annotations.Test;

public class TestPetsure extends BaseClass {

    @Test()
    public void acceptAllCookies() {
        petSure.getVersion();
        petSure.clickAcceptAllButton();
    }

    @Test()
    public void typePetName() {
        String pet = "Togo";

        petSure.clickAcceptAllButton();
        petSure.typePetName(pet);
        petSure.clickContinueButton();
    }
}

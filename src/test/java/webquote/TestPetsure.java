package webquote;

import base.BaseClass;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.DataPOJO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class TestPetsure extends BaseClass {
    @DataProvider
    public Object[][] activeAccountDetails() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/resources/pet-owner.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("pawsomeOwner");
        List<DataPOJO> testData = new Gson().fromJson(dataSet, new TypeToken<List<DataPOJO>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @Test()
    public void acceptAllCookies() {
        petSure.clickAcceptAllButton();
    }

    @Test()
    public void pawsomeE2E() {
        String pet = "Togo";

        petSure.clickAcceptAllButton();
        petSure.typePetName(pet);
        petSure.clickContinueButton();

        petSure.selectDog();
        petSure.clickContinueButton();

        petSure.selectMale();
        petSure.enterBirthday();
        petSure.clickContinueButton();

        petSure.selectMixed();
        petSure.selectDominantBreedUnknown();
        petSure.selectWeight_1();
        petSure.clickContinueButton();
    }
}

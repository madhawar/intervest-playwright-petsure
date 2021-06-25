package testcases;

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

public class TestPolicyDetails extends BaseClass {
    @DataProvider
    public Object[][] petInfo() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/resources/pet-common.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("petCommon");
        List<DataPOJO> testData = new Gson().fromJson(dataSet, new TypeToken<List<DataPOJO>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @Test(dataProvider = "petInfo")
    public void selectPetType(DataPOJO petInfo) {
        petSure.clickAcceptAllCookiesButton();
        petSure.typePetName(petInfo.getName());
        petSure.clickContinueButton();

        petSure.selectPetType(petInfo.getAnimal());
        petSure.clickContinueButton();

        petSure.selectPetGender(petInfo.getGender());
        petSure.enterBirthday(petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());
        petSure.clickContinueButton();

        if (petInfo.getAnimal().equals("cat")) {
            petSure.selectCatType(petInfo.getType(), petInfo.getBreed());
        } else if (petInfo.getAnimal().equals("dog")) {
            petSure.selectDogType(petInfo.getType(), petInfo.getBreed(), petInfo.getDominantBreed());
        }
    }

}

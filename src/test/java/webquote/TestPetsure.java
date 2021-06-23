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
import java.time.LocalDate;
import java.util.List;

public class TestPetsure extends BaseClass {
    @DataProvider
    public Object[][] petInfo() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/resources/pet-min.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("petCommon");
        List<DataPOJO> testData = new Gson().fromJson(dataSet, new TypeToken<List<DataPOJO>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @Test(priority=1, dataProvider = "petInfo")
    public void enterPetNameInvalid(DataPOJO petInfo) {
        petSure.clickAcceptAllCookiesButton();

        petSure.typePetName("");
        petSure.verifyPetNameEmpty();

        petSure.typePetName("T");
        petSure.verifyPetNameShort();

        petSure.typePetName("Togo Gunaratne");
        petSure.verifyPetNameInvalid();
    }

    @Test(priority=2, dataProvider = "petInfo")
    public void enterPetNameValid(DataPOJO petInfo) {
        petSure.clickAcceptAllCookiesButton();

        petSure.typePetName(petInfo.getName());
        petSure.clickContinueButton();
    }

    @Test(priority=3, dataProvider = "petInfo")
    public void enterPetGender(DataPOJO petInfo) {
        petSure.clickAcceptAllCookiesButton();
        petSure.typePetName(petInfo.getName());
        petSure.clickContinueButton();

        if (petInfo.getAnimal().equals("cat")) {
            petSure.selectCat();
        }
        else if (petInfo.getAnimal().equals("dog")) {
            petSure.selectDog();
        }
        petSure.clickContinueButton();

        if (petInfo.getGender().equals("male")) {
            petSure.selectMale();
        }
        else if (petInfo.getGender().equals("female")) {
            petSure.selectFemale();
        }
    }

    @Test(priority=4, dataProvider = "petInfo")
    public void enterPetBirthdayAgeMin(DataPOJO petInfo) {
        petSure.clickAcceptAllCookiesButton();
        petSure.typePetName(petInfo.getName());
        petSure.clickContinueButton();

        if (petInfo.getAnimal().equals("cat")) {
            petSure.selectCat();
        }
        else if (petInfo.getAnimal().equals("dog")) {
            petSure.selectDog();
        }
        petSure.clickContinueButton();

        if (petInfo.getGender().equals("male")) {
            petSure.selectMale();
        } else if (petInfo.getGender().equals("female")) {
            petSure.selectFemale();
        }

        LocalDate currentdate = LocalDate.now();

        int currentYear = currentdate.getYear();
        String birthyear = Integer.toString(currentYear);

        int currentMonth = currentdate.getMonthValue();
        String birthmonth = Integer.toString(currentMonth);

        int currentDay = currentdate.getDayOfMonth() -1;
        String birthday = Integer.toString(currentDay);

        petSure.enterBirthday(birthday, birthmonth, birthyear);
        petSure.verifyMinAge(petInfo.getName());
    }

    @Test(priority=5, dataProvider = "petInfo")
    public void enterPetBirthdayAgeMax(DataPOJO petInfo) {
        petSure.clickAcceptAllCookiesButton();
        petSure.typePetName(petInfo.getName());
        petSure.clickContinueButton();

        if (petInfo.getAnimal().equals("cat")) {
            petSure.selectCat();
        }
        else if (petInfo.getAnimal().equals("dog")) {
            petSure.selectDog();
        }
        petSure.clickContinueButton();

        if (petInfo.getGender().equals("male")) {
            petSure.selectMale();
        }
        else if (petInfo.getGender().equals("female")) {
            petSure.selectFemale();
        }

        LocalDate currentdate = LocalDate.now();

        int maxAge = currentdate.getYear() - 50;
        String birthyear = Integer.toString(maxAge);

        petSure.enterBirthday(petInfo.getBirthDay(), petInfo.getBirthMonth(), birthyear);
        petSure.verifyMaxAge();
    }

    @Test(priority=6, dataProvider = "petInfo")
    public void enterPetBirthday(DataPOJO petInfo) {
        petSure.clickAcceptAllCookiesButton();
        petSure.typePetName(petInfo.getName());
        petSure.clickContinueButton();

        if (petInfo.getAnimal().equals("cat")) {
            petSure.selectCat();
        }
        else if (petInfo.getAnimal().equals("dog")) {
            petSure.selectDog();
        }
        petSure.clickContinueButton();

        if (petInfo.getGender().equals("male")) {
            petSure.selectMale();
        }
        else if (petInfo.getGender().equals("female")) {
            petSure.selectFemale();
        }
        petSure.enterBirthday(petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());
        petSure.clickContinueButton();
    }

}

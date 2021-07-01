package tests;

import base.BaseClass;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.DataPOJO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.List;

public class TestPetsure extends BaseClass {
    @DataProvider
    public Object[][] petInfo() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/data/pet-common.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("petCommon");
        List<DataPOJO> testData = new Gson().fromJson(dataSet, new TypeToken<List<DataPOJO>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @DataProvider
    public Object[][] petDog() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/data/pet-common.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("petDog");
        List<DataPOJO> testData = new Gson().fromJson(dataSet, new TypeToken<List<DataPOJO>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @Test(priority=1, dataProvider = "petInfo")
    public void enterPetNameValid(DataPOJO petInfo) {
        petSure.typePetName(petInfo.getName());
    }

    @Test(priority=2, dataProvider = "petInfo")
    public void enterPetBirthdayAgeMin(DataPOJO petInfo) {
        petSure.typePetName(petInfo.getName());

        petSure.selectPetType(petInfo.getAnimal());

        petSure.selectPetGender(petInfo.getGender());

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

    @Test(priority=3, dataProvider = "petInfo")
    public void enterPetBirthdayAgeMax(DataPOJO petInfo) {
        petSure.typePetName(petInfo.getName());

        petSure.selectPetType(petInfo.getAnimal());

        petSure.selectPetGender(petInfo.getGender());

        LocalDate currentdate = LocalDate.now();

        int maxAge = currentdate.getYear() - 50;
        String birthyear = Integer.toString(maxAge);

        petSure.enterBirthday(petInfo.getBirthDay(), petInfo.getBirthMonth(), birthyear);
        petSure.verifyMaxAge();
    }

    @Test(priority=4, dataProvider = "petInfo")
    public void selectPetBreed(DataPOJO petInfo) {
        petSure.typePetName(petInfo.getName());

        petSure.selectPetType(petInfo.getAnimal());

        petSure.selectPetGender(petInfo.getGender());
        petSure.enterBirthday(petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());

        petSure.selectBreed(petInfo.getAnimal(), petInfo.getType(), petInfo.getBreed(), petInfo.getDominantBreed());
    }

    @Test(priority=5, dataProvider = "petDog")
    public void selectDogCrossBreeds(DataPOJO petInfo) {
        petSure.typePetName(petInfo.getName());

        petSure.selectPetType("dog");

        petSure.selectPetGender(petInfo.getGender());
        petSure.enterBirthday(petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());

        petSure.crossBreedNotListed(petInfo.getBreed(), petInfo.getDominantBreed());
    }

    @Test(priority=6, dataProvider = "petDog")
    public void selectDogMixedBreeds(DataPOJO petInfo) {
        petSure.typePetName(petInfo.getName());

        petSure.selectPetType("dog");

        petSure.selectPetGender(petInfo.getGender());
        petSure.enterBirthday(petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());

        petSure.mixedBreedNotSure();
    }

    @Test(priority=7, dataProvider = "petInfo")
    public void popupWhenNotMicrochipped(DataPOJO petInfo) {
        petSure.typePetName(petInfo.getName());

        petSure.selectPetType(petInfo.getAnimal());

        petSure.selectPetGender(petInfo.getGender());
        petSure.enterBirthday(petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());

        petSure.selectBreed(petInfo.getAnimal(), petInfo.getType(), petInfo.getBreed(), petInfo.getDominantBreed());

        petSure.answerNeuteredOrSpayedQuestion(petInfo.getNeuteredSpayed());
        petSure.answerMicrochipQuestion("no");
    }

    @Test(priority=8, dataProvider = "petInfo", enabled = false)
    public void petCostValidations(DataPOJO petInfo) {
        petSure.typePetName(petInfo.getName());

        petSure.selectPetType(petInfo.getAnimal());

        petSure.selectPetGender(petInfo.getGender());
        petSure.enterBirthday(petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());

        petSure.selectBreed(petInfo.getAnimal(), petInfo.getType(), petInfo.getBreed(), petInfo.getDominantBreed());

        petSure.answerNeuteredOrSpayedQuestion(petInfo.getNeuteredSpayed());
        petSure.answerMicrochipQuestion(petInfo.getMicrochipped());

        petSure.costPaidOrDonated("10001");
        petSure.verifyContinueButtonRemainsHidden();
    }

    @Test(priority=9, dataProvider = "petInfo")
    public void petMedicalConditions(DataPOJO petInfo) {
        petSure.typePetName(petInfo.getName());

        petSure.selectPetType(petInfo.getAnimal());

        petSure.selectPetGender(petInfo.getGender());
        petSure.enterBirthday(petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());

        petSure.selectBreed(petInfo.getAnimal(), petInfo.getType(), petInfo.getBreed(), petInfo.getDominantBreed());

        petSure.answerNeuteredOrSpayedQuestion(petInfo.getNeuteredSpayed());
        petSure.answerMicrochipQuestion(petInfo.getMicrochipped());

        petSure.costPaidOrDonated(petInfo.getDonation());

        petSure.dentalIllnessCover(petInfo.getDentalIllness());

        petSure.healthCover(petInfo.getHealthQuestion1(), petInfo.getHealthQuestion2(), petInfo.getAnimal());

        petSure.agreeToAssumptions();
    }

}

package tests;

import base.BaseClass;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.DataPOJO;
import utils.Log;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.List;

public class TestPolicyDetails extends BaseClass {
    @DataProvider
    public Object[][] petInfo() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/data/pet-min.json"));
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

    @Test(priority=1, dataProvider = "petInfo", enabled = false)
    public void addAlreadyCoveredPetDetails(DataPOJO petInfo) {
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

        LocalDate currentdate = LocalDate.now();

        String covered_pet = "Togo";

        int currentYear = currentdate.getYear() +1;
        String renew_year = Integer.toString(currentYear);

        int currentMonth = currentdate.getMonthValue() +1;
        String renew_month = Integer.toString(currentMonth);

        policyDetails.addAlreadyCoveredPetDetails(covered_pet, renew_month, renew_year);
    }

    @Test(priority=2, dataProvider = "petInfo")
    public void test(DataPOJO petInfo) {
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

        policyDetails.selectNoForAnyOtherPets();

        policyDetails.selectPolicyStartDate();

        policyDetails.fillOwnerDetails();
        petSure.clickContinueButton();
        Log.info("Submitted owner details.");

        policyDetails.selectVetFree(petInfo.getVetFee());
        policyDetails.selectExcess(petInfo.getExcess());
        policyDetails.selectBillShare(petInfo.getBillShare());
        petSure.clickContinueButton();

        policyDetails.selectDentalIllnessCover(petInfo.getDentalIllness());
        policyDetails.selectFarewellCover();
        policyDetails.selectTravelAndHolidayCover();
        policyDetails.selectMissingPetCover(petInfo.getMicrochipped());
        petSure.clickContinueButton();

        policyDetails.selectPaymentOption();
        Log.debug("bwoah");

        policyDetails.enterPaymentDetails();
        policyDetails.createAccount();
    }

}

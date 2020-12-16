package starTrekPeople;


import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class validatePeopleGetApi extends BaseTest {
    @Test
    public void validatePeopleGet() {
        test.log(LogStatus.INFO, "========TEST STARTED======");
        Response response = RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_PEOPLE);
        APIVerification.responseCodeValidation(response, 200);
        APIVerification.responseKeyValidationFromJsonObject(response,"name");
        APIVerification.responseKeyValidationFromJsonObject(response,"height");
        APIVerification.responseKeyValidationFromJsonObject(response,"vehicles");
        APIVerification.responseTimeValidation(response);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        test.log(LogStatus.INFO, "Status code:" + response.getStatusCode());
        test.log(LogStatus.INFO, response.getBody().asString());
        test.log(LogStatus.INFO, "Response Time:" + response.getTime());
        test.log(LogStatus.INFO, "========TEST FINISHED======");

    }
}

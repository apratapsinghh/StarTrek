package starTrekPeople;


import resources.APIPath;
import resources.APIVerification;
import resources.BaseTest;
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
        APIVerification.responseKeyValidationFromJsonObject(response, "name");
        APIVerification.responseKeyValidationFromJsonObject(response, "height");
        APIVerification.responseKeyValidationFromJsonObject(response, "vehicles");
        APIVerification.responseTimeValidation(response);
        test.log(LogStatus.INFO, "Status code:" + response.getStatusCode());
        test.log(LogStatus.INFO, response.getBody().asString());

    }
}

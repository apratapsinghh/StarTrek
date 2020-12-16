package starTrekPeople;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static java.util.OptionalDouble.empty;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertTrue;

import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ExtentReportGenerator;


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

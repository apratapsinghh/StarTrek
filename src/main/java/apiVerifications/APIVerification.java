package apiVerifications;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import utils.ExtentReportGenerator;
import org.json.JSONObject;
import io.restassured.response.Response;

public class APIVerification extends ExtentReportGenerator {

    public static void responseCodeValidation(Response response, int statusCode) {

        try {
            Assert.assertEquals(statusCode, response.getStatusCode());
            test.log(LogStatus.PASS,
                    "Successfully validated status code, status code is :: " + response.getStatusCode());
        } catch (AssertionError e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
            test.log(LogStatus.FAIL,
                    "Expected status code is :: " + statusCode + " , insted of getting :: " + response.getStatusCode());
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

    public static void responseKeyValidationFromJsonObject(Response response, String key) {
        try {
            JSONObject json = new JSONObject(response.getBody().asString());
            if (json.has(key) && json.get(key) != null) {
                test.log(LogStatus.PASS, "Successfully validated value of " + key + " It is " + json.get(key));
            } else {
                test.log(LogStatus.FAIL, "Key is not available");
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

    public static void responseTimeValidation(Response response) {
        try {
            long time = response.time();
            test.log(LogStatus.INFO, "Api response time is :: " + time);
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

}

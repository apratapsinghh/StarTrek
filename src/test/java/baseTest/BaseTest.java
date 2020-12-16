package baseTest;

import io.restassured.RestAssured;
import org.junit.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.ExtentReportGenerator;
import utils.FileEnv;

@Listeners(ExtentReportGenerator.class)
public class BaseTest extends ExtentReportGenerator {

    @BeforeClass
    public static void baseTest() {
        RestAssured.baseURI = FileEnv.envAndFile().get("ServerUrl");
//            RestAssured.baseURI = "https://swapi.dev/api/";
    }

}

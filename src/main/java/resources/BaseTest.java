package resources;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ExtentReportGenerator.class)
public class BaseTest extends ExtentReportGenerator {

    @BeforeClass
    public static void baseTest() {
        RestAssured.baseURI = EnvironmentConfig.envAndFile().get("ServerUrl");
    }

}

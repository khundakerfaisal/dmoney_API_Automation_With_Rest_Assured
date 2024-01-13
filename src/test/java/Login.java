import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Login {
    public Properties props;
    @BeforeTest
    public void setup() throws IOException {
        props=new Properties();
        FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
    }
    @Test(priority = 1)

    public void doLogin() throws ConfigurationException, IOException {
        RestAssured.baseURI = props.getProperty("baseUrl");
        Response res = given().contentType("application/json")
                .body("{\n" +
                        "    \"emailOrPhoneNumber\":\"01686606909\",\n" +
                        "    \"password\":\"1234\"\n" +
                        "}")
                .when()
                .post("user/login");
        JsonPath jsonPath = res.jsonPath();
        String token = jsonPath.get("token");
        Utils.setEnvVariable("token", token);


    }
    @Test(priority = 2)
    public void createUser() throws ConfigurationException, IOException {
        Properties props=new Properties();
        FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = props.getProperty("baseUrl");
        Response res = given().contentType("application/json")
                .header("Authorization",props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",props.getProperty("partnerKey"))
                .body("{\n" +
                        "    \"name\":\"Customer test3\",\n" +
                        "    \"email\":\"Customer_test3@roadtocareer.net\",\n" +
                        "    \"password\":\"1234\",\n" +
                        "    \"phone_number\":\"01874515447\",\n" +
                        "    \"nid\":\"87954644\",\n" +
                        "    \"role\":\"Customer\"\n" +
                        "}")
                .when()
                .post("/user/create");
        System.out.println(res.asString());
    }
}

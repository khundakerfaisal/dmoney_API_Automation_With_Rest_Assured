package pages;

import Config.UserModel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class createUser {

    private String baseUrl;
    private String token;
    private String partnerKey;

    public createUser(String baseUrl, String token, String partnerKey) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.partnerKey = partnerKey;

    }

    public createUser(String baseUrl, String token) {
        this.baseUrl = baseUrl;
        this.token = token;

    }

    public createUser(String baseUrl) {
        this.baseUrl = baseUrl;

    }

    public String doLogin(String email, String password) throws ConfigurationException, IOException {
        RestAssured.baseURI = baseUrl;
        UserModel userModel = new UserModel();
        userModel.setEmailOrPhoneNumber(email);
        userModel.setPassword(password);
        Response res = given().contentType("application/json")
                .body(userModel)
                .when()
                .post("/user/login");
        JsonPath jsonPath = res.jsonPath();
        String token = jsonPath.get("token").toString();
        Utils.setEnvVariable("token", token);
        return token;


    }

    public Response createUser(UserModel userModel) throws ConfigurationException, IOException, ParseException {
//        Properties props=new Properties();
//        FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
//        props.load(fis);
        RestAssured.baseURI = baseUrl;
        Response res = given().contentType("application/json")
                .header("Authorization", token)
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(userModel)
                .when()
                .post("/user/create");

        return res;

    }
}

package pages;

import Config.Setup;
import Config.TransactionModel;
import Config.UserModel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class Transaction extends Setup {

    public Response depositToAgent(TransactionModel transactionModel) throws ConfigurationException, IOException, ParseException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
//        RestAssured.baseURI = "http://dmoney.roadtocareer.net";
        RestAssured.baseURI = props.getProperty("baseUrl");
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .body(transactionModel)
                .when()
                .post("/transaction/deposit");

        return res;

    }

    public Response depositCustomerFromAgent(TransactionModel transactionModel) throws ConfigurationException, IOException, ParseException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = props.getProperty("baseUrl");
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .body(transactionModel)
                .when()
                .post("/transaction/deposit");

        return res;

    }

    public Response withdrawFromAgent(TransactionModel transactionModel) throws ConfigurationException, IOException, ParseException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = props.getProperty("baseUrl");
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .body(transactionModel)
                .when()
                .post("/transaction/withdraw");

        return res;

    }

    public Response sendMoney(TransactionModel transactionModel) throws ConfigurationException, IOException, ParseException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = props.getProperty("baseUrl");
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .body(transactionModel)
                .when()
                .post("/transaction/sendmoney");

        return res;

    }

    public Response merchantPayment(TransactionModel transactionModel) throws ConfigurationException, IOException, ParseException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = props.getProperty("baseUrl");
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .body(transactionModel)
                .when()
                .post("/transaction/payment");

        return res;

    }

    public Response checkCustomerBalance(String PhoneNumber) throws ConfigurationException, IOException, ParseException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = props.getProperty("baseUrl");
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .when()
                .get("/transaction/balance/" + PhoneNumber);

        return res;

    }


}

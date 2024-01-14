package pages;

import Config.Setup;
import Config.TransactionModel;
import Config.UserModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Transaction  {
    private String baseUrl;
    private String token;

    public Response depositToAgent(TransactionModel transactionModel) throws ConfigurationException, IOException, ParseException {
        Properties props=new Properties();
        FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = "http://dmoney.roadtocareer.net";
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(transactionModel)
                .when()
                .post("/transaction/deposit");

        return res;

    }
    public Response depositCustomerFromAgent(TransactionModel transactionModel) throws ConfigurationException, IOException, ParseException {
        Properties props=new Properties();
        FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = "http://dmoney.roadtocareer.net";
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(transactionModel)
                .when()
                .post("/transaction/deposit");

        return res;

    }
    public Response withdrawFromAgent(TransactionModel transactionModel) throws ConfigurationException, IOException, ParseException {
        Properties props=new Properties();
        FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = "http://dmoney.roadtocareer.net";
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(transactionModel)
                .when()
                .post("/transaction/withdraw");

        return res;

    }
    public Response sendMoney(TransactionModel transactionModel) throws ConfigurationException, IOException, ParseException {
        Properties props=new Properties();
        FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = "http://dmoney.roadtocareer.net";
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(transactionModel)
                .when()
                .post("/transaction/sendmoney");

        return res;

    }
    public Response merchantPayment(TransactionModel transactionModel) throws ConfigurationException, IOException, ParseException {
        Properties props=new Properties();
        FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = "http://dmoney.roadtocareer.net";
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(transactionModel)
                .when()
                .post("/transaction/payment");

        return res;

    }
    public Response checkCustomerBalance(String phoneNumber) throws ConfigurationException, IOException, ParseException {
        Properties props=new Properties();
        FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
        props.load(fis);
        RestAssured.baseURI = "http://dmoney.roadtocareer.net";
        Response res = given().contentType("application/json")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .body(phoneNumber)
                .when()
                .post("/transaction/balance/01479221992");

        return res;

    }




}

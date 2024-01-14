package testRunner;

import Config.Setup;
import Config.UserModel;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.createUser;
import utils.Utils;

import java.io.IOException;


public class userTestRunner extends Setup {
    @Test(priority = 1)
    public void login() throws ConfigurationException, IOException {
       createUser login=new createUser(props.getProperty("baseUrl"));
       String token=login.doLogin("salman@roadtocareer.net","1234");
       System.out.println(token);
    }
    @Test(priority = 2)
    public void createCustomer() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Faker faker=new Faker();
        String name=faker.name().firstName();
        String email=faker.internet().emailAddress();
        String password="123454";
        String phoneNumber="0147" + Utils.generateRandom(1000000,9999999);
        String nid="22554450";
        String role="Customer";
        UserModel userModel =new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phoneNumber);
        userModel.setNid(nid);
        userModel.setRole(role);
        Response res= login.createUser(userModel);
        System.out.println(res.asString());
        Utils.createCustomer(userModel);


    }

    @Test(priority = 3)
    public void createAgent() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Faker faker=new Faker();
        String name=faker.name().firstName();
        String email=faker.internet().emailAddress();
        String password="123454";
        String phoneNumber="0147" + Utils.generateRandom(1000000,9999999);
        String nid="22554450";
        String role="Agent";
        UserModel userModel =new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phoneNumber);
        userModel.setNid(nid);
        userModel.setRole(role);
        Response res= login.createUser(userModel);
        System.out.println(res.asString());
        Utils.createAgent(userModel);


    }



}

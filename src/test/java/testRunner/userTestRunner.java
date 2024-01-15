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
    @Test(priority = 1,description = "Admin user login successfully")
    public void login() throws ConfigurationException, IOException {
       createUser login=new createUser(props.getProperty("baseUrl"));
       String token=login.doLogin("salman@roadtocareer.net","1234");
       System.out.println(token);
    }
    @Test(priority = 2,description = "Customer create successfully")
    public void createCustomer() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Faker faker=new Faker();
        String name=faker.name().firstName();
        String email=faker.internet().emailAddress();
        String password="123454";
        String CustomerPhoneNumber="0147" + Utils.generateRandom(1000000,9999999);
        String nid="22554450";
        String role="Customer";
        UserModel userModel =new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(CustomerPhoneNumber);
        userModel.setNid(nid);
        userModel.setRole(role);
        Response res= login.createUser(userModel);
        System.out.println(res.asString());
        Utils.createCustomer(userModel);


    }

    @Test(priority = 3,description = "Agent create successfully")
    public void createAgent() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Faker faker=new Faker();
        String name=faker.name().firstName();
        String email=faker.internet().emailAddress();
        String password="123454";
        String AgentPhoneNumber="0147" + Utils.generateRandom(1000000,9999999);
        String nid="22554450";
        String role="Agent";
        UserModel userModel =new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(AgentPhoneNumber);
        userModel.setNid(nid);
        userModel.setRole(role);
        Response res= login.createUser(userModel);
        System.out.println(res.asString());
        Utils.createAgent(userModel);


    }
    @Test(priority = 4,description = "Customer Another(recipient ) create successfully")
    public void createCustomerAnother() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Faker faker=new Faker();
        String name=faker.name().firstName();
        String email=faker.internet().emailAddress();
        String password="123454";
        String customerAnotherPhoneNumber="0147" + Utils.generateRandom(1000000,9999999);
        String nid="22554450";
        String role="Customer";
        UserModel userModel =new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(customerAnotherPhoneNumber);
        userModel.setNid(nid);
        userModel.setRole(role);
        Response res= login.createUser(userModel);
        System.out.println(res.asString());
        Utils.createAnotherCustomer(userModel);


    }

}

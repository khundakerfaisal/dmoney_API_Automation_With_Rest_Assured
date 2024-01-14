package testRunner;

import Config.Setup;
import Config.TransactionModel;
import Config.UserModel;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.Transaction;
import pages.createUser;
import utils.Utils;

import java.io.IOException;

public class transactionTestRunner extends Setup {
    @Test(priority = 1)
    public void login() throws ConfigurationException, IOException {
        createUser login=new createUser(props.getProperty("baseUrl"));
        String token=login.doLogin("salman@roadtocareer.net","1234");
        System.out.println(token);
    }
    @Test(priority = 2,enabled = false)
    public void depositSystemToAgentNumber() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Transaction transaction=new Transaction();
        TransactionModel transactionModel=new TransactionModel();
        transactionModel.from_account="SYSTEM";
        transactionModel.to_account="01473022093";
        transactionModel.amount=2000;
        Response res = transaction.depositToAgent(transactionModel);
        System.out.println(res.asString());


//        Response res= transactionModel.toString();
//        System.out.println(transactionModel.());
//        Utils.createCustomer(userModel);


    }

    @Test(priority = 3,enabled = false)
    public void depositCustomerFromAgentNumber() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Transaction transaction=new Transaction();
        TransactionModel transactionModel=new TransactionModel();
        transactionModel.from_account="01473022093";
        transactionModel.to_account="01477074432";
        transactionModel.amount=1500;
        Response res = transaction.depositCustomerFromAgent(transactionModel);
        System.out.println(res.asString());


//        Response res= transactionModel.toString();
//        System.out.println(transactionModel.());
//        Utils.createCustomer(userModel);


    }
    @Test(priority = 4,enabled = false)
    public void withdrawCustomerToAgentNumber() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Transaction transaction=new Transaction();
        TransactionModel transactionModel=new TransactionModel();
        transactionModel.from_account="01477074432";
        transactionModel.to_account="01473022093";
        transactionModel.amount=500;
        Response res = transaction.withdrawFromAgent(transactionModel);
        System.out.println(res.asString());


//        Response res= transactionModel.toString();
//        System.out.println(transactionModel.());
//        Utils.createCustomer(userModel);


    }
    @Test(priority = 5,enabled = false)
    public void sendMoneyToAnotherCustomerNumber() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Transaction transaction=new Transaction();
        TransactionModel transactionModel=new TransactionModel();
        transactionModel.from_account="01477074432";
        transactionModel.to_account="01479221992";
        transactionModel.amount=500;
        Response res = transaction.sendMoney(transactionModel);
        System.out.println(res.asString());


//        Response res= transactionModel.toString();
//        System.out.println(transactionModel.());
//        Utils.createCustomer(userModel);

    }
    @Test(priority = 6,enabled = false)
    public void makePaymentCustomer() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Transaction transaction=new Transaction();
        TransactionModel transactionModel=new TransactionModel();
        transactionModel.from_account="01479221992";
        transactionModel.to_account="01686606905";
        transactionModel.amount=100;
        Response res = transaction.merchantPayment(transactionModel);
        System.out.println(res.asString());


//        Response res= transactionModel.toString();
//        System.out.println(transactionModel.());
//        Utils.createCustomer(userModel);

    }
    @Test(priority = 7)
    public void checkRecipientBalance() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        Transaction transaction=new Transaction();
//        TransactionModel transactionModel=new TransactionModel();
//        transactionModel.from_account="01479221992";
//        transactionModel.to_account="01686606905";
//        transactionModel.amount=100;
        Response res = transaction.checkCustomerBalance("01479221992");
        System.out.println(res.asString());


//        Response res= transactionModel.toString();
//        System.out.println(transactionModel.());
//        Utils.createCustomer(userModel);

    }

}

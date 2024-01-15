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
    @Test(priority = 2,description = "Deposit successfully system to agent number")
    public void depositSystemToAgentNumber() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        String agentPhoneNumber=Utils.getAgentPhoneNumber().get("AgentPhoneNumber").toString();
        Transaction transaction=new Transaction();
        TransactionModel transactionModel=new TransactionModel();
        transactionModel.from_account="SYSTEM";
        transactionModel.to_account=agentPhoneNumber;
        transactionModel.amount=2000;
        Response res = transaction.depositToAgent(transactionModel);
        System.out.println(res.asString());
    }
    @Test(priority = 3,description = "Deposit successfully customer from agent number")
    public void depositCustomerFromAgentNumber() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
            String agentPhoneNumber = Utils.getAgentPhoneNumber().get("AgentPhoneNumber").toString();
            String customerPhoneNumber = Utils.getCustomerPhoneNumber().get("CustomerPhoneNumber").toString();
            Transaction transaction = new Transaction();
            TransactionModel transactionModel = new TransactionModel();
            transactionModel.from_account = agentPhoneNumber;
            transactionModel.to_account = customerPhoneNumber;
            transactionModel.amount = 1500;
            Response res = transaction.depositCustomerFromAgent(transactionModel);
            System.out.println(res.asString());
        }


    @Test(priority = 4,description = "Withdraw successfully customer to agent number")
    public void withdrawCustomerToAgentNumber() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        String agentPhoneNumber=Utils.getAgentPhoneNumber().get("AgentPhoneNumber").toString();
        String customerPhoneNumber=Utils.getCustomerPhoneNumber().get("CustomerPhoneNumber").toString();
        Transaction transaction=new Transaction();
        TransactionModel transactionModel=new TransactionModel();
        transactionModel.from_account=customerPhoneNumber;
        transactionModel.to_account=agentPhoneNumber;
        transactionModel.amount=500;
        Response res = transaction.withdrawFromAgent(transactionModel);
        System.out.println(res.asString());

    }
    @Test(priority = 5,description = "Send money successfully customer to another customer number")
    public void sendMoneyToAnotherCustomerNumber() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        String customerPhoneNumber=Utils.getCustomerPhoneNumber().get("CustomerPhoneNumber").toString();
        String customerAnotherPhoneNumber= (String) Utils.getCustomerAnotherPhoneNumber().get("customerAnotherPhoneNumber");
        Transaction transaction=new Transaction();
        TransactionModel transactionModel=new TransactionModel();
        transactionModel.from_account=customerPhoneNumber;
        transactionModel.to_account=customerAnotherPhoneNumber;
        transactionModel.amount=500;
        Response res = transaction.sendMoney(transactionModel);
        System.out.println(res.asString());

    }
    @Test(priority = 6,description = "Customer payment successfully to the merchant number")
    public void makePaymentCustomer() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        String customerAnotherPhoneNumber= (String) Utils.getCustomerAnotherPhoneNumber().get("customerAnotherPhoneNumber");
        Transaction transaction=new Transaction();
        TransactionModel transactionModel=new TransactionModel();
        transactionModel.from_account=customerAnotherPhoneNumber;
        transactionModel.to_account="01686606905";
        transactionModel.amount=100;
        Response res = transaction.merchantPayment(transactionModel);
        System.out.println(res.asString());
    }
    @Test(priority = 7,description = "check balance of the recipient customer ")
    public void checkRecipientBalance() throws ConfigurationException, IOException, ParseException {
        createUser login= new createUser(props.getProperty("baseUrl"),props.getProperty("token"));
        String customerAnotherPhoneNumber= Utils.getCustomerAnotherPhoneNumber().get("customerAnotherPhoneNumber").toString();
        Transaction transaction=new Transaction();
        Response res =transaction.checkCustomerBalance(customerAnotherPhoneNumber);
        System.out.println(res.asString());
    }

}

package utils;

import Config.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static void setEnvVariable(String key,String value) throws ConfigurationException {
        PropertiesConfiguration propertiesConfiguration=new PropertiesConfiguration("./src/test/resources/config.properties");
        propertiesConfiguration.setProperty(key,value);
        propertiesConfiguration.save();
    }
    public static void createCustomer(UserModel model) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/customers.json";
        JSONParser parser=new JSONParser();
        JSONArray customerArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject customerObj = new JSONObject();
        customerObj.put("name",model.getName());
        customerObj.put("email", model.getEmail());
        customerObj.put("password", model.getPassword());
        customerObj.put("CustomerPhoneNumber", model.getPhone_number());
        customerObj.put("nid", model.getNid());
        customerObj.put("role", model.getRole());
        customerArray.add(customerObj);
        FileWriter writer = new FileWriter(fileLocation);
        writer.write(customerArray.toJSONString());
        writer.flush();
        writer.close();

    }
    public static void createAgent(UserModel model) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/agent.json";
        JSONParser parser=new JSONParser();
        JSONArray customerArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject customerObj = new JSONObject();
        customerObj.put("name",model.getName());
        customerObj.put("email", model.getEmail());
        customerObj.put("password", model.getPassword());
        customerObj.put("AgentPhoneNumber", model.getPhone_number());
        customerObj.put("nid", model.getNid());
        customerObj.put("role", model.getRole());
        customerArray.add(customerObj);
        FileWriter writer = new FileWriter(fileLocation);
        writer.write(customerArray.toJSONString());
        writer.flush();
        writer.close();

    }
    public static void createAnotherCustomer(UserModel model) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/customerAnother.json";
        JSONParser parser=new JSONParser();
        JSONArray customerArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject customerObj = new JSONObject();
        customerObj.put("name",model.getName());
        customerObj.put("email", model.getEmail());
        customerObj.put("password", model.getPassword());
        customerObj.put("customerAnotherPhoneNumber", model.getPhone_number());
        customerObj.put("nid", model.getNid());
        customerObj.put("role", model.getRole());
        customerArray.add(customerObj);
        FileWriter writer = new FileWriter(fileLocation);
        writer.write(customerArray.toJSONString());
        writer.flush();
        writer.close();

    }

//    public static int generateNumber(int min, int max) {
//
//        return (int) Math.round(Math.random() * (max - min) + min);
//    }

    public static int generateRandom(int min, int max){
        double rand= Math.random()*(max-min)+min;
        return (int) rand;
    }
    public static JSONObject getCustomerPhoneNumber() throws IOException, ParseException {
        String fileLocation = "./src/test/resources/customers.json";
        JSONParser parser = new JSONParser();
        JSONArray empArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject empObj = (JSONObject) empArray.get(empArray.size() - 1);
        return empObj;
    }
    public static JSONObject getAgentPhoneNumber() throws IOException, ParseException {
        String fileLocation = "./src/test/resources/agent.json";
        JSONParser parser = new JSONParser();
        JSONArray empArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject empObjAgent = (JSONObject) empArray.get(empArray.size() - 1);
        return empObjAgent;
    }
    public static JSONObject getCustomerAnotherPhoneNumber() throws IOException, ParseException {
        String fileLocation = "./src/test/resources/customerAnother.json";
        JSONParser parser = new JSONParser();
        JSONArray empArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject empObjCustomer = (JSONObject) empArray.get(empArray.size() - 1);
        return empObjCustomer;
    }

}

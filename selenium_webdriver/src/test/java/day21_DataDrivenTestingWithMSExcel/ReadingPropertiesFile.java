package day21_DataDrivenTestingWithMSExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {
    public static void main(String[] args) throws IOException {
        Properties propertiesobj = new Properties();
        FileInputStream file = new FileInputStream(
                "C:\\Users\\anura\\Desktop\\java_selenium\\selenium_webdriver\\testdata\\config.properties");
        propertiesobj.load(file);
        String url = propertiesobj.getProperty("url");
        String username = propertiesobj.getProperty("username");
        String password = propertiesobj.getProperty("password");
        String id = propertiesobj.getProperty("id");
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("ID: " + id);

        Set<String> keys = propertiesobj.stringPropertyNames();
        System.out.println("All keys in the properties file: " + keys);

        Set<Object> allkeys = propertiesobj.keySet();
        System.out.println("All keys using keySet(): " + allkeys);

        Collection<Object> values = propertiesobj.values();
        System.out.println("All values in the properties file: " + values);
    }
}

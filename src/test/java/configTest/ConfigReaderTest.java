package configTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderTest {
    private static Properties properties;

    static {
        try {
            String path = "src/test/resources/passwords.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String path = "src/test/resources/login.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTestProperty(String key) {
        return properties.getProperty(key).trim();
    }
}

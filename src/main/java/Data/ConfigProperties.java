package Data;

import java.util.Properties;

public class ConfigProperties {

    private static Properties properties;

    static {
        properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemResource("config.properties").openStream());
        } catch (Exception e) {
            System.out.println("config.properties file ERROR");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

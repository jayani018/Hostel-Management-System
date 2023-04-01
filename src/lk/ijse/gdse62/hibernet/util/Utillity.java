package lk.ijse.gdse62.hibernet.util;

import java.io.IOException;
import java.util.Properties;

public class Utillity {
    public static Properties getPropertise(){
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("PropertyFile.properties"));
        } catch (IOException e) {
            System.out.println("Property file not found!");
            e.printStackTrace();
        }
        return properties;
    }

}

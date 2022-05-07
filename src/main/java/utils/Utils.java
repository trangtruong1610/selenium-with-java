package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    public Properties getPropsFromConfigFile(){
        Properties prop = new Properties();
        String fileName = System.getProperty("user.dir") + "/src/main/resources/app.config";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
    public String getValueFromConfigFileByKey(String key){
        Properties prop = new Properties();
        String fileName = System.getProperty("user.dir") + "/src/main/resources/config.properties";

        try {
            prop.load(new FileInputStream(fileName));
        } catch (Exception e){
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }


}

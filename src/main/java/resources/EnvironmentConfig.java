package resources;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvironmentConfig {
    public static Map<String,String> fileandenv = new HashMap<String, String>();
    public static Properties propertiesMain = new Properties();

    public static Map<String,String> envAndFile(){
      String environment =  System.getProperty("env");
      try {
           if ((environment.equalsIgnoreCase("dev"))){
               FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir")+"/inputs/dev.properties");
               propertiesMain.load(fisDev);
               fileandenv.put("ServerUrl",propertiesMain.getProperty("ServerUrl"));
           }
           else if ((environment.equalsIgnoreCase("qa"))) {
               FileInputStream fisQa = new FileInputStream(System.getProperty("user.dir")+"/inputs/qa.properties");
               propertiesMain.load(fisQa);
               fileandenv.put("ServerUrl",propertiesMain.getProperty("ServerUrl"));
           }
      }
      catch (Exception e){

      }
        return fileandenv;
    }

    public static Map<String,String> getConfigReader(){
        if(fileandenv == null){
            fileandenv = envAndFile();
        }
        return fileandenv;
    }
}

package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFilesRead {
    private static final Logger LOGGER= LogManager.getLogger(ConfigFilesRead.class);
    public Properties getPropertyValue() throws IOException {
        Properties prop=new Properties();
        InputStream inputStream=null;
        try{
            String propFileName="config.properties";
            inputStream=getClass().getClassLoader().getResourceAsStream(propFileName);
            if(inputStream !=null){
                prop.load(inputStream);
            }else {
                throw new FileNotFoundException("property file"+propFileName+"not found in the classpath");
            }
        }catch(Exception e){
            LOGGER.error("Exception is:"+e.getMessage());
        }finally {
            inputStream.close();
        }
        return prop;
    }
    @Test
    public void test() throws IOException{
        Properties prop;
        prop = getPropertyValue();
        System.out.println("this is username: " + prop.getProperty("userName"));
        System.out.println("this is Password: " + prop.getProperty("passWord"));
    }
}

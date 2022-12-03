import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyReader {

    protected WebDriver driver;

    public static String getProperty(String propertyName){
        if(System.getProperty(propertyName)==null){
            return getPropertyFromFile(propertyName);
        }
        else{
            return System.getProperty(propertyName);
        }
    }
    private static String getPropertyFromFile(String propertyName){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new
                    FileInputStream("src/test/java/framework.properties");
            prop.load(input);
        } catch (IOException ex) {
            System.out.println("Cannot read property value for " +
                    propertyName);
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop.getProperty(propertyName);
    }
    public static String getWindow(){
        return getProperty("maximize");
    }
    public void CheckWindow(){
        File file = new File("src/test/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",
                file.getAbsolutePath());
        driver = new ChromeDriver();

    }
}

package Proecting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;

public abstract class BaseTest {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    };

    @BeforeClass
    public void setUp(){
        File file = new File("src/test/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",
                file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.navigate().to( "https://www.google.com/");
        driver.manage().window().maximize();
        WebElement searchField2 = driver.findElement(By.id("L2AGLb"));
        searchField2.click();
    }
    @AfterClass
    public void shutDown(){
        driver.quit();
    }

    @AfterMethod
    public void goBack() {


        driver.navigate().back();
    }

    @DataProvider(name="dataProvider")
    public Object[] [] dataProviderMethod(){
        return new Object[][] {{"selenium java"}, {"selenium java"}};
    }
}

package Patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import steps.SearchSteps;
import utils.Browser;
import utils.DriverFactory;
import utils.PropertyReader;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class BaseTest {
    private static WebDriver driver;
    SearchSteps steps;
    public static WebDriver getDriver() {
        return driver;
    }




    @BeforeClass
    public void setUp(){

        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.navigate().to( PropertyReader.getUrl());



       // driver.manage().window().maximize();
        WebElement searchField2 = driver.findElement(By.id("L2AGLb"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchField2 ));
        searchField2.click();
        steps = new SearchSteps();
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class SearchTest {
    @Test
    public void openGoogleChromeInChromeTest() {
        File file = new File("src/test/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",
                file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.navigate().to( "https://www.google.com/");
        //driver.get("https://www.google.com/");
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        WebElement searchField2 = driver.findElement(By.id("L2AGLb"));
        searchField2.click();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.click();
        WebElement googleAppsButton = driver.findElement(By.cssSelector("div#gbwa a"));
        googleAppsButton.click();


        List<WebElement> imFeelingLucky = driver.findElements(By.xpath("//input[@name='btnI']"));
        imFeelingLucky.get(1).click();
        driver.quit();

    }

}

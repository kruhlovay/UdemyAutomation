import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.List;

public class SearchTest {
    @Test
    public void openGoogleChromeInChromeTest() throws InterruptedException {
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
        searchField.sendKeys("selenium webdriver");
        searchField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//*[@id='result-stats']")).getText().replaceAll("[^0-9, .]", ""));
        //WebElement googleAppsButton = driver.findElement(By.cssSelector("div#gbwa a"));
       // googleAppsButton.click();
       // WebElement

       // List<WebElement> imFeelingLucky = driver.findElements(By.xpath("//input[@name='btnI']"));
      //  imFeelingLucky.get(1).click();
       driver.quit();

    }

}

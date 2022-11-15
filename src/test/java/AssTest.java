import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;


import java.io.File;
import java.util.List;

public class AssTest {
    @Test
    public void openGoogleChromeInChromeTest() throws InterruptedException {
        File file = new File("src/test/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",
                file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.navigate().to( "https://www.google.com/");
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        WebElement searchField2 = driver.findElement(By.id("L2AGLb"));
        searchField2.click();
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("selenium webdriver");
        search.sendKeys(Keys.RETURN);

        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//*[@id='result-stats']")).getText().replaceAll("[^0-9, .]", ""));
        WebElement resultRow = driver.findElement(By.xpath("//div[@id='rso']//h3"));

        System.out.println(resultRow.getText());
        System.out.println(resultRow.getAttribute("class"));

       assertThat (resultRow.getText().toLowerCase()).as("Test is not found").contains("selenium", "webdriver");
        Assert.assertTrue(resultRow.isDisplayed(),"Element is not found");
       Assert.assertEquals(resultRow.getText(), "WebDriver - Selenium", "Wrong text is shown");
        Assert.assertEquals(resultRow.getAttribute("class"), "LC20lb MBeuO DKV0Md", "Wrong attribute text");
        //WebElement googleAppsButton = driver.findElement(By.cssSelector("div#gbwa a"));
        // googleAppsButton.click();
        // WebElement

        // List<WebElement> imFeelingLucky = driver.findElements(By.xpath("//input[@name='btnI']"));
        //  imFeelingLucky.get(1).click();
        //   driver.quit();

    }

}

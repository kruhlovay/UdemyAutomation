import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PlotTest extends Preconditions{
    @Test(dataProvider = "dataProvider")
    public void openGoogleChromeInChromeTest(String text) throws InterruptedException {
       
        WebElement search = driver.findElement(By.name("q"));
        search.click();
        search.sendKeys(text);
        search.sendKeys(Keys.RETURN);

        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//*[@id='result-stats']")).getText().replaceAll("[^0-9, .]", ""));
        WebElement resultRow = driver.findElement(By.xpath("//div[@id='rso']//h3"));

        System.out.println(resultRow.getText());
        System.out.println(resultRow.getAttribute("class"));

        assertThat (resultRow.getText().toLowerCase()).as("Text is not found").contains("selenium", "project");
        assertTrue(resultRow.isDisplayed(),"Element is not found");
        assertEquals(resultRow.getText(), "The Selenium Browser Automation Project", "Wrong text is shown");
        assertEquals(resultRow.getAttribute("class"), "LC20lb MBeuO DKV0Md", "Wrong attribute text");




            List<WebElement> searchResultURLs = (List<WebElement>) driver.findElements(By.xpath("//div[@class='s6JM6d']"));
            //   assertEquals(searchResultURLs.get(0).getText(),"expectedValue", expectedValue+" is not the first result");
            int s=searchResultURLs.size();

            for(int i = 0; i<s; i++){

                assertThat(searchResultURLs.get(i).getText().toLowerCase()).as("is not the first result").contains("selenium");

            }


        }


}

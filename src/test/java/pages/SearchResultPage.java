package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//div[@class='g']//h3")
    private WebElement resultRow;

    @FindBy(className = "lnXdpd")
    private WebElement header;

   // private By resultRow = By.xpath("//div[@class='g']//h3");
    public SearchResultPage() {
        super();
    }

    public void headerIsInvisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(header));
    }

    public void assertThatTopResultContainsText(String expected){
   //     WebElement resultRowElement = driver.findElement(resultRow);

        assertThat (resultRow.getText().toLowerCase()).as("Text is not found").isEqualTo(expected);
        assertTrue(resultRow.isDisplayed(),"Element is not found");
        System.out.println(resultRow.getText());
      //  assertEquals(resultRowElement.getText(), expected, "Wrong text is shown");
    }
    public void assertThatTopResultContainsPropertyAttributeText(String expected){
     //   WebElement resultRowElement = driver.findElement(resultRow);
        System.out.println(resultRow.getAttribute("class"));
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute text").contains("LC20lb");
    }


}

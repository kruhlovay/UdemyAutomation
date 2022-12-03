package Proecting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
@Test

public class SearchResultPage extends BasePage{
    private By searchResultURLsBy = By.xpath("//cite[@class='iUh30']");
    public SearchResultPage(){super();}
    public void assertThatExpectedValueIsOnSearchTop(String expectedValue){
        List<WebElement> searchResultURLs = (List<WebElement>) driver.findElement(searchResultURLsBy);
     //   assertEquals(searchResultURLs.get(0).getText(),"expectedValue", expectedValue+" is not the first result");
        int s=searchResultURLs.size();

            for(int i = 0; i<=s; i++){

                assertEquals(searchResultURLs.get(i).getText(),"expectedValue", expectedValue+" is not the first result");

            }


        }
    }


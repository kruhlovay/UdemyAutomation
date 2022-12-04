package Patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleinChrome1(String text) throws InterruptedException {
    steps.executeSearchByKeyword(text)
            .verifyThatTopResultContainsCorrectText("the selenium browser automation project")
            .verifyThatTopResultContainsProperAttributeText("LC20lb MBeuO DKV0Md").headerCheck();


    }

}

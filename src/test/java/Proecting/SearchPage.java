package Proecting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{
    private By searchFieldBy = By.id("lst-ib");
    public SearchPage(){super();}
    public void fillTheSearchField(String keyword){
        WebElement searchField = driver.findElement(searchFieldBy);
        searchField.sendKeys(keyword);
    }
    public void pressEnter(){
        WebElement searchField = driver.findElement(searchFieldBy);
        searchField.sendKeys(Keys.RETURN);
    }
}

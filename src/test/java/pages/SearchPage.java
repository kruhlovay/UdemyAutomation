package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    @FindBy(name="q")
    private WebElement searchField;

   // WebElement searchField = driver.findElement(By.name("q"));
    public SearchPage() {
        super();
    }
    public void fillSearchField(String text){
        searchField.click();
        searchField.sendKeys(text);

    }
    public void pressEnter(){
      //  searchField searchFieldElement = driver.findElement(searchField); - реализация с использованием WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(Keys.RETURN);

    }
}

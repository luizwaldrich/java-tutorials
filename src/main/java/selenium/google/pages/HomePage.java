package selenium.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private String URL = "https://www.google.com";

    @FindBy(name = "q")
    private WebElement searchInput;

    public HomePage(WebDriver driver) {
        driver.get(URL);
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String query) {
        searchInput.clear();
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
    }
}

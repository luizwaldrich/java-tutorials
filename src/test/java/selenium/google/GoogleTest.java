package selenium.google;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.TestBase;
import selenium.google.pages.HomePage;
import selenium.google.pages.ResultsPage;

public class GoogleTest extends TestBase {

    @Test
    public void shouldReturnResultsWhenSearchForSelenium() {
        HomePage home = new HomePage(getDriver());
        home.searchFor("selenium");
        ResultsPage resultsPage = new ResultsPage(getDriver());
        for (WebElement result : resultsPage.getResults()) {
            WebElement h3 = result.findElement(By.tagName("h3"));
            Assert.assertTrue("Keyword 'selenium' not found in the title", h3.getText().toLowerCase().contains("selenium"));
        }
        Assert.assertEquals(7, resultsPage.getResults().size());
    }
}

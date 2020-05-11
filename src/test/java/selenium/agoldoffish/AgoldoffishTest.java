package selenium.agoldoffish;

import challenges.objects.Quote;
import org.junit.Test;
import selenium.TestBase;
import selenium.agoldoffish.pages.AgoldoffishPage;

import java.util.List;

public class AgoldoffishTest extends TestBase {

    /**
     * This test gets, via selenium, all quotes from a selected person from the site A gold of fish
     * and print them into console. Eg.: All the quotes and authors mentioned by Gideon will be printed.
     */
    @Test
    public void shouldPrintAllGideonQuotesIntoConsole() {
        AgoldoffishPage agoldoffishPage = new AgoldoffishPage(getDriver());
        List<Quote> quotes = agoldoffishPage.getQuotesBy("Gideon");
        for (Quote quote : quotes) {
            System.out.println(quote.toString());
        }
    }
}

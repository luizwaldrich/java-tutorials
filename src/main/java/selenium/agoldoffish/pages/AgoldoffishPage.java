package selenium.agoldoffish.pages;
import challenges.objects.Quote;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
public class AgoldoffishPage {

    private WebDriver driver;

    private static String PAGE_URL = "https://agoldoffish.wordpress.com/criminal-minds-opening-and-closing-quotes/";

    public AgoldoffishPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public List<Quote> getQuotesBy(String name) {
        List<WebElement> pageParagraphs = this.driver.findElements(By.xpath("//*[@id=\"post-462\"]/div/p"));
        return getQuoteFromParagraphs(name, pageParagraphs);
    }

    private List<Quote> getQuoteFromParagraphs(String name, List<WebElement> paragraphs) {
        List<Quote> quotes = new ArrayList<Quote>();
        for (WebElement paragraph : paragraphs) {
            Quote quote = getQuoteFromParagraph(name, paragraph);
            if (quote != null) {
                quotes.add(quote);
                System.out.println("[author=" + quote.getAuthor() + " | quote=\"" + quote.getQuote() + "\"]");
            }
        }
        return quotes;
    }

    private Quote getQuoteFromParagraph(String name, WebElement paragraph) {
        String p = paragraph.getText();
        if (p.toLowerCase().contains(name.toLowerCase())) {
            Quote quote = new Quote();
            int twoPoints = p.indexOf(":");
            p = p.substring(twoPoints + 2);
            String[] words = p.split(" ");
            for (String word : words) {
                if (word != null
                        && !word.isEmpty()
                        && Character.isUpperCase(word.charAt(0))
                        && !hasNotNameWord(word)) {
                    // remove some capital words that are not names
                    if (quote.getAuthor() == null) {
                        quote.setAuthor(word);
                    } else {
                        quote.setAuthor(quote.getAuthor() + " " + word);
                    }
                } else if (word.equals("de")
                        || word.equals("la")) {
                    // middle names
                    quote.setAuthor(quote.getAuthor() + " " + word);
                } else if (quote.getAuthor() != null) {
                    break;
                }
            }
            int quotationMarks = p.indexOf('“');
            if (quotationMarks > 0) {
                quote.setQuote(p.substring(quotationMarks+1, p.length()-1));
                return quote;
            }
            return null;
        }
        return null;
    }

    private boolean hasNotNameWord(String str) {
        String[] notName = {"The", "French", "Sir", "Playwright", "Writer", "Dr", "Condemned"};
        for (String s : notName) {
            if (str.equals(notName)) {
                return true;
            }
        }
        return false;
    }
}

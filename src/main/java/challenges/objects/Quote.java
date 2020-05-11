package challenges.objects;

public class Quote {
    private String author;
    private String quote;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}

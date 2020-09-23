package library;

import java.util.Date;

public class Book extends CatalogItem{

    private String author;
    private int numberOfPages;

    public Book(String code, String title, Date publishDate, String author, int numberOfPages) {
        super(code, title, publishDate);
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author=author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int Number) {
        this.numberOfPages=numberOfPages;
    }

    @Override
    public String toString() {
        return "Book_" +getCode()+"_"+getTitle()+"_"+getPublishDate()+"_"+
                author + "_" + numberOfPages;
    }
}

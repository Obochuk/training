package epam.training.practice2.task2.model.entity;


import java.util.Date;

public class Book {
    private String name;
    private String author;
    private String publisher;
    private int published;
    private int pagesAmount;
    private double price;

    public Book(){}

    public Book(String name, String author, String publisher, int published, int pagesAmount, double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.published = published;
        this.pagesAmount = pagesAmount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book, name=" + name + ", author="+author + ", publisher=" + publisher
                + ", year of publishing=" + published + ", pages amount=" + pagesAmount
                + ", price=$" + price;
    }
}

package model.entity;

import java.io.Serializable;

public class Book implements Serializable{
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (published != book.published) return false;
        if (pagesAmount != book.pagesAmount) return false;
        if (Double.compare(book.price, price) != 0) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return publisher != null ? publisher.equals(book.publisher) : book.publisher == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + published;
        result = 31 * result + pagesAmount;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

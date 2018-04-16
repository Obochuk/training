package model;


import model.comparator.BookPublisherComparator;
import model.data.DataSource;
import model.data.StaticDataSource;
import model.data.file.FileAccess;
import model.data.file.FileDataSource;
import model.entity.Book;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class LibraryModel {
    private List<Book> books;

    public LibraryModel(){
        readBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void readBooks(){
        StaticDataSource source = new StaticDataSource();
        books = source.getBooks();
    }

    public void readBooks(String fileName) throws IOException {
        DataSource source = new FileDataSource(fileName);
        books = source.getBooks();
    }

    public void saveBooks(String fileName) throws IOException{
        FileAccess.writeToFile(books, fileName);
    }

    public List<Book> getBooksByAuthor(String author){
        return (filter(book -> book.getAuthor().equals(author)));
    }

    public List<Book> getBooksByPublisher(String publisher){
        return (filter(book -> book.getPublisher().equals(publisher)));
    }

    public List<Book> getBooksPublishedAfter(int date){
        return (filter(book -> book.getPublished() > date));
    }

    private List<Book> filter(Predicate<Book> predicate){
        List<Book> filteredBooks = new LinkedList<>();
        for (Book book : books) {
            if (predicate.test(book)){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public List<Book> sortBooksByPublisher(){
        return sort(new BookPublisherComparator());
    }

    private List<Book> sort(Comparator<Book> comparator){
        books.sort(comparator);
        return books;
    }
}

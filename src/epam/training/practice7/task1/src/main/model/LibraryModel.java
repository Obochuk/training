package model;

import file.FileAccessor;
import model.data.DataSource;
import model.data.FileDataSource;
import model.data.StaticDataSource;
import model.entity.Book;
import model.entity.comparator.BookPublisherComparator;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class LibraryModel {
    private final static Logger LOGGER = Logger.getLogger(LibraryModel.class);

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
        LOGGER.info("books loaded from static data source");
    }

    public void readBooks(String fileName) throws FileNotFoundException{
        DataSource source = new FileDataSource(fileName);
        books = source.getBooks();
        LOGGER.info("books loaded from file: " + fileName);
    }

    public void saveBooks(String fileName) throws IOException{
        FileAccessor.writeObjectsToFile(books, fileName);
        LOGGER.info("books write into '" + fileName + "' file");
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

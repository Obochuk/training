package model;

import model.data.FileDataSource;
import model.data.StaticDataSource;
import model.entity.Book;
import model.entity.comparator.BookPublisherComparator;
import org.apache.log4j.Logger;
import utils.FileAccessor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryModel {
    private static final Logger LOGGER = Logger.getLogger(LibraryModel.class);

    public static final LibraryModel INSTANCE = new LibraryModel();

    private List<Book> books;

    private LibraryModel(){
        readBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void readBooks(){
        StaticDataSource source = new StaticDataSource();
        books = source.getBooks();
        LOGGER.info("books loaded from static data source");
    }

    public void readBooks(String fileName) throws FileNotFoundException{
        FileDataSource source = new FileDataSource(fileName);
        books = source.getBooks();
        LOGGER.info("books loaded from file: " + fileName);
    }

    public void saveBooks(String fileName) throws IOException{
        FileAccessor.writeObjectsToFile(books, fileName);
        LOGGER.info("books write into '" + fileName + "' file");
    }

    public List<Book> getBooksByAuthor(String author){
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByPublisher(String publisher){
        return books.stream()
                .filter(book -> book.getPublisher().equals(publisher))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksPublishedAfter(int date){
        return books.stream()
                .filter(book -> book.getPublished() > date)
                .collect(Collectors.toList());
    }


    public List<Book> sortBooksByPublisher(){
        return sort(new BookPublisherComparator());
    }

    private List<Book> sort(Comparator<Book> comparator){
        books.sort(comparator);
        return books;
    }
}
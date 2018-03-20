package model;

import model.comparator.BookPublisherComparator;
import model.entity.Book;

import java.util.*;
import java.util.function.Predicate;

public class LibraryModel {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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

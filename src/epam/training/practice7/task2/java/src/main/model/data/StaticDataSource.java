package src.main.model.data;

import src.main.model.entity.Book;

import java.util.Arrays;
import java.util.List;

public class StaticDataSource implements DataSource {
    @Override
    public List<Book> getBooks(){
        return Arrays.asList(
                new Book("Harry Potter", "Rowling", "Airplane", 1998, 769, 10),
                new Book("The Hunger Games", "Collins", "Zarbo", 2001, 538, 20),
                new Book("To Kill a Mockingbird", "Lee", "Airplane", 1956, 428, 5),
                new Book("Pride And Prejudice", "Austen", "Zarbo", 1965, 899, 8),
                new Book("Twilight", "Meyer", "OD1", 2005, 610, 15),
                new Book("The Book Thief", "Zusak", "Humberg", 1973, 536, 9),
                new Book("The Chronicles of Narnia", "Lewis", "Airlane", 1949, 767, 50),
                new Book("Harry Potter and the Goblet of Fire", "Rowling", "Greenfield", 2000, 734, 10)
        );
    }
}

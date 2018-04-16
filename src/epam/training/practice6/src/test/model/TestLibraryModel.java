package model;

import model.entity.Book;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLibraryModel {
    private static LibraryModel model = new LibraryModel();

    private static Book arr0 = new Book("name", "Obochuk", "Obochuk Inc.", 1997, 800, 7_000_000);
    private static Book arr1 = new Book("name", "author2", "Obochuk Inc.", 2008, 856, 5);
    private static Book arr2 = new Book("name", "Obochuk", "publ", 1990, 555, 5);
    private static Book arr3 = new Book("name", "author3", "publ3", 2001, 555, 8);

    @Parameterized.Parameter
    public String author;

    @Parameterized.Parameter(1)
    public List<Book> expectedByAuthor;

    @Parameterized.Parameter(2)
    public String publisher;

    @Parameterized.Parameter(3)
    public List<Book> expectedByPublisher;

    @Parameterized.Parameter(4)
    public int year;

    @Parameterized.Parameter(5)
    public List<Book> expectedByYear;

    @BeforeClass
    public static void setUp(){
        model.setBooks(Arrays.asList(arr0, arr1, arr2, arr3));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        String author = "Obochuk";
        List<Book> expectedByAuthor = Arrays.asList(arr0, arr2);

        String publisher = "Obochuk Inc.";
        List<Book> expectedByPublisher = Arrays.asList(arr0, arr1);

        int year = 2000;
        List<Book> expectedByYear = Arrays.asList(arr1, arr3);

        return Arrays.asList(new Object[][]{
                {author, expectedByAuthor, publisher, expectedByPublisher, year, expectedByYear}
        });
    }

    @Test
    public void testGetBooksByAuthor(){
        assertEquals(expectedByAuthor, model.getBooksByAuthor(author));
    }

    @Test
    public void testGetBooksByPublisher(){
        assertEquals(expectedByPublisher, model.getBooksByPublisher(publisher));
    }

    @Test
    public void testGetBooksPublishedAfter(){
        assertEquals(expectedByYear, model.getBooksPublishedAfter(year));
    }

}

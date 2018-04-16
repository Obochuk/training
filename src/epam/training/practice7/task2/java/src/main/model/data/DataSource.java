package model.data;


import model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface DataSource {

    List<Book> getBooks() throws IOException;

}

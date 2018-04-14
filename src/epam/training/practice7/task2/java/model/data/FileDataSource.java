package model.data;

import utils.FileAccessor;
import model.entity.Book;

import java.io.FileNotFoundException;
import java.util.List;

public class FileDataSource implements DataSource {
    private String fileName;

    public FileDataSource(String fileName){
        this.fileName = fileName;
    }

    @Override
    public List<Book> getBooks() throws FileNotFoundException{
        return FileAccessor.readObjectsFromFile(fileName, Book.class);
    }
}

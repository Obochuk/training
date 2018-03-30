package model.data.file;

import model.data.DataSource;
import model.entity.Book;

import java.io.IOException;
import java.util.List;

public class FileDataSource implements DataSource {
    private String fileName;

    public FileDataSource(String fileName){
        this.fileName = fileName;
    }

    @Override
    public List<Book> getBooks() throws IOException{
        return FileAccess.readFromFile(fileName);
    }
}

package view;

import model.entity.Book;

import java.util.List;

public class LibraryView {

    public static final LibraryView INSTANCE = new LibraryView();

    private LibraryView(){}

    public void printMessage(Object value){
        System.out.println(value);
    }
    
    public void print(List<Book> books){
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println('\n');
    }
}
